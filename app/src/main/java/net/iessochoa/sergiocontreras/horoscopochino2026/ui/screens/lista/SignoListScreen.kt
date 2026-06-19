package net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.lista

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.components.SignoCard
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.HoroscopoUiState

@Composable
fun SignoListScreen(
    uiState: HoroscopoUiState,
    onSignoClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(uiState.signos, key = { it.id }) { signo ->
            SignoCard(
                signo = signo,
                onClick = { onSignoClick(signo.id) },
            )
        }
    }
}