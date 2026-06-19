package net.iessochoa.sergiocontreras.horoscopochino2026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.HoroscopoChinoApp
import net.iessochoa.sergiocontreras.horoscopochino2026.ui.theme.HoroscopoChino2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HoroscopoChino2026Theme {
                HoroscopoChinoApp()
            }
        }
    }
}