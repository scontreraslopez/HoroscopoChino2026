package net.iessochoa.sergiocontreras.horoscopochino2026.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.HoroscopoViewModel
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.detalle.SignoDetailScreen
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.lista.SignoListScreen

object Routes {
    const val LISTA = "lista"
    const val DETALLE = "detalle"
}

@Composable
fun AppNavigation(
    viewModel: HoroscopoViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Routes.LISTA,
        modifier = modifier,
    ) {
        composable(Routes.LISTA) {
            SignoListScreen(
                uiState = uiState,
                onSignoClick = { id ->
                    viewModel.onSignoSelected(id)
                    navController.navigate(Routes.DETALLE)
                },
            )
        }
        composable(Routes.DETALLE) {
            SignoDetailScreen(
                uiState = uiState,
                onAnioChange = viewModel::onAnioNacimientoChange,
            )
        }
    }
}