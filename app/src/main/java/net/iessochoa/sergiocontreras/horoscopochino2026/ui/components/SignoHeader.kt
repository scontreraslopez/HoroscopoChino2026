package net.iessochoa.sergiocontreras.horoscopochino2026.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.horoscopochino2026.data.model.SignoChino
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.theme.HoroscopoChino2026Theme

/**
 * Cabecera visual de un signo del horóscopo chino.
 *
 * Muestra el emoji grande, el nombre en titular y la descripción centrada.
 * Se usa en la pantalla de detalle para identificar el signo de un vistazo.
 *
 * @param signo Datos del [SignoChino] a mostrar.
 * @param modifier Modificador opcional para el layout externo.
 */
@Composable
fun SignoHeader(
    signo: SignoChino,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
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
    }
}

@Preview(showBackground = true)
@Composable
private fun SignoHeaderPreview() {
    val signoCaballo = SignoChino(
        id = "caballo",
        nombre = "Caballo",
        emoji = "🐎",
        aniosRepresentativos = listOf(1966, 1978, 1990, 2002, 2014, 2026),
        descripcion = "Libre, enérgico e independiente. El Caballo necesita espacio para correr y se apaga cuando lo encadenan a la rutina.",
        prediccion2026 = "¡Es tu año! El Caballo galopa con fuerza renovada hacia sus sueños.",
    )
    HoroscopoChino2026Theme {
        SignoHeader(signo = signoCaballo)
    }
}
