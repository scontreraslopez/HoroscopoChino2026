package net.iessochoa.sergiocontreras.horoscopochino2026.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.HoroscopoViewModel

/**
 * STARTER — Navegación (Navigation Compose).
 *
 * Monta el NavHost con dos destinos: la lista de signos y el detalle.
 * Las pantallas (SignoListScreen / SignoDetailScreen) ya existen y son stateless:
 * reciben el uiState y callbacks. El ViewModel NO se pasa a las pantallas, solo aquí.
 *
 * Reglas:
 *  - El destino inicial es la lista.
 *  - El signo seleccionado viaja en el ESTADO, no como argumento de ruta.
 *  - Recoge el estado del ViewModel y pásalo a cada pantalla.
 *  - Al pulsar un signo: primero actualiza el estado en el ViewModel y luego navega al detalle.
 *
 * Nota: en la entrega del examen este fichero se renombra a AppNavigation.kt; el objeto de
 * rutas y la función pierden el sufijo Starter.
 */

object RoutesStarter {
    // TODO 1: define las constantes de ruta (una para la lista y otra para el detalle).
}

@Composable
fun AppNavigationStarter(
    viewModel: HoroscopoViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    // TODO 2: recoge el estado del ViewModel como State de Compose (collectAsState()).

    // TODO 3: declara el NavHost(navController, startDestination = <ruta lista>, modifier) con
    //         dos composable():
    //
    //   - Ruta lista -> SignoListScreen(uiState, onSignoClick = { id -> ... }).
    //       En onSignoClick: actualiza el estado con el ViewModel y luego navega al detalle.
    //
    //   - Ruta detalle -> SignoDetailScreen(uiState, onAnioChange = ...).
    //       Conecta onAnioChange con el método correspondiente del ViewModel.
    TODO("Implementa el NavHost con las rutas de lista y detalle")
}
