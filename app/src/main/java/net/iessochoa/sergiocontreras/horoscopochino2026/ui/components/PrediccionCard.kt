package net.iessochoa.sergiocontreras.horoscopochino2026.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.theme.HoroscopoChino2026Theme

/**
 * Tarjeta que muestra la predicción anual de un signo del horóscopo chino.
 *
 * @param prediccion Texto de la predicción a mostrar.
 * @param modifier Modificador opcional para el layout externo de la tarjeta.
 */
@Composable
fun PrediccionCard(
    prediccion: String,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier.fillMaxWidth()) {
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
                text = prediccion,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrediccionCardPreview() {
    HoroscopoChino2026Theme {
        PrediccionCard(
            prediccion = "¡Es tu año! El Caballo galopa con fuerza renovada hacia sus sueños. Todo lo que desees construir tiene el viento a favor.",
        )
    }
}