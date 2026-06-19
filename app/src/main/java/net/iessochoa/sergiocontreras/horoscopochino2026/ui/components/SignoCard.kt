package net.iessochoa.sergiocontreras.horoscopochino2026.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.horoscopochino2026.data.model.SignoChino
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.theme.HoroscopoChino2026Theme

/**
 * Tarjeta visual que representa un signo del horóscopo chino.
 *
 * Muestra el emoji, el nombre y los tres últimos años representativos del signo,
 * con una disposición centrada y espaciado uniforme. Es interactiva: al pulsar sobre
 * ella se navega al detalle del signo.
 *
 * @param signo Datos del [SignoChino] a mostrar (emoji, nombre y años representativos).
 * @param onClick Acción ejecutada al pulsar la tarjeta (normalmente navegar al detalle).
 * @param modifier Modificador opcional para personalizar el layout externo de la tarjeta.
 *
 * @sample net.iessochoa.sergiocontreras.horoscopochino2026.ui.components.SignoCardPreview
 */
@Composable
fun SignoCard(
    signo: SignoChino,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Text(
                text = signo.emoji,
                style = MaterialTheme.typography.displaySmall,
            )
            Text(
                text = signo.nombre,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = signo.aniosRepresentativos.takeLast(3).joinToString(", "),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignoCardPreview() {

    val signoCaballo = SignoChino (
        id = "caballo",
        nombre = "Caballo",
        emoji = "🐎",
        aniosRepresentativos = listOf(1966, 1978, 1990, 2002, 2014, 2026),
        descripcion = "Libre, enérgico e independiente. El Caballo necesita espacio para correr y se apaga cuando lo encadenan a la rutina.",
        prediccion2026 = "¡Es tu año! El Caballo galopa con fuerza renovada hacia sus sueños. Todo lo que desees construir tiene el viento a favor."
    )

    HoroscopoChino2026Theme() {
        SignoCard(
            signo = signoCaballo,
            onClick = {},
        )
    }
}