package net.iessochoa.sergiocontreras.horoscopochino2026.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.navigation.AppNavigation
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.navigation.Routes
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.HoroscopoViewModel
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.lista.SignoListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HoroscopoChinoApp() {

    //TODO: Completa

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = "CAMBIAME POR EL TITULO",
                ) }
                //TODO: Completa el navigationIcon = {
            )
        },
    ) { innerPadding ->
        //TODO Aquí engancha la navegación
        SignoListScreen(


        )
    }
}