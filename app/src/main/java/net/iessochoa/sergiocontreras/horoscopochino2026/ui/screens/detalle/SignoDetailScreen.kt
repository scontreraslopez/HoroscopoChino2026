package net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.detalle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.horoscopochino2026.data.repository.HoroscopoRepository
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.components.ElementoCalculadorCard
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.components.PrediccionCard
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.components.SignoHeader
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.theme.HoroscopoChino2026Theme

//TODO: Tendras que modificar la firma del composable para que reciba el estado y el callback
@Composable
fun SignoDetailScreen(
    modifier: Modifier = Modifier,
) {

    //TODO: el signo tiene que venir del estado (uiState.signoSeleccionado), aqui esta a fuego
    val signo = HoroscopoRepository.signos.first()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        SignoHeader(signo = signo)

        HorizontalDivider()

        PrediccionCard(prediccion = signo.prediccion2026)

        ElementoCalculadorCard(
            //TODO: el año tiene que venir del estado (uiState.anioNacimiento)
            anioNacimiento = "",
            //TODO: tienes que conectar el callback que avisa al ViewModel del cambio
            onAnioChange = { /*TODO*/ },
            //TODO: el elemento calculado tiene que venir del estado (uiState.elementoCalculado)
            elementoCalculado = null,
        )

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

        )
    }
}