package net.iessochoa.sergiocontreras.horoscopochino2026.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.navigation.AppNavigation
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.navigation.Routes
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens.HoroscopoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HoroscopoChinoApp() {
    val navController = rememberNavController()
    val viewModel: HoroscopoViewModel = viewModel()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val enDetalle = backStackEntry?.destination?.route == Routes.DETALLE

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (enDetalle) "Tu horóscopo" else "Horóscopo Chino 2026") },
                navigationIcon = {
                    if (enDetalle) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Volver",
                            )
                        }
                    }
                },
            )
        },
    ) { innerPadding ->
        AppNavigation(
            viewModel = viewModel,
            navController = navController,
            modifier = Modifier.padding(innerPadding),
        )
    }
}