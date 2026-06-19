package net.iessochoa.sergiocontreras.horoscopochino2026.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.horoscopochino2026.data.model.ElementoChino
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.theme.HoroscopoChino2026Theme

/**
 * Tarjeta interactiva que calcula y muestra el elemento chino según el año de nacimiento.
 *
 * El usuario introduce su año de nacimiento y, si el cálculo produce un resultado,
 * se muestra el emoji y nombre del [ElementoChino] correspondiente.
 *
 * @param anioNacimiento Valor actual del campo de texto (año introducido por el usuario).
 * @param onAnioChange Callback invocado cada vez que el usuario modifica el campo.
 * @param elementoCalculado Elemento resultante del cálculo, o `null` si aún no hay resultado.
 * @param modifier Modificador opcional para el layout externo de la tarjeta.
 */
@Composable
fun ElementoCalculadorCard(
    anioNacimiento: String,
    onAnioChange: (String) -> Unit,
    elementoCalculado: ElementoChino?,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "Tu elemento chino",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
            )
            OutlinedTextField(
                value = anioNacimiento,
                onValueChange = onAnioChange,
                label = { Text("Año de nacimiento") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )
            elementoCalculado?.let { elemento ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Text(
                        text = elemento.emoji,
                        style = MaterialTheme.typography.headlineMedium,
                    )
                    Text(
                        text = "Elemento ${elemento.nombre}",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ElementoCalculadorCardPreview() {
    HoroscopoChino2026Theme {
        ElementoCalculadorCard(
            anioNacimiento = "1990",
            onAnioChange = {},
            elementoCalculado = ElementoChino.METAL,
        )
    }
}