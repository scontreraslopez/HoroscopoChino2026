package net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.detalle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.horoscopochino2026.data.model.ElementoChino
import net.iessochoa.sergiocontreras.horoscopochino2026.data.repository.HoroscopoRepository
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.HoroscopoUiState
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.theme.HoroscopoChino2026Theme

@Composable
fun SignoDetailScreen(
    uiState: HoroscopoUiState,
    onAnioChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val signo = uiState.signoSeleccionado ?: return

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = signo.emoji,
            style = MaterialTheme.typography.displayLarge,
        )
        Text(
            text = signo.nombre,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = signo.descripcion,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        HorizontalDivider()

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "Predicción 2026",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = signo.prediccion2026,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
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
                    value = uiState.anioNacimiento,
                    onValueChange = onAnioChange,
                    label = { Text("Año de nacimiento") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                )
                uiState.elementoCalculado?.let { elemento ->
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

        Text(
            text = "Años de la ${signo.nombre}: ${signo.aniosRepresentativos.joinToString(", ")}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SignoDetailScreenPreview() {
    HoroscopoChino2026Theme() {
        SignoDetailScreen(
            uiState = HoroscopoUiState(
                signoSeleccionado = HoroscopoRepository.signos.firstOrNull(),
                anioNacimiento = "1990",
                elementoCalculado = ElementoChino.METAL

                // Assuming HoroscopoUiState has a way to provide a mock or default sign
                // This follows the pattern of the existing UI code
            ),
            onAnioChange = {}
        )
    }
}
