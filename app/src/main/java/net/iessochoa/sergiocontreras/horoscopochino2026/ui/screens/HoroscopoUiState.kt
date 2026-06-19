package net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens

import net.iessochoa.sergiocontreras.horoscopochino2026.data.model.ElementoChino
import net.iessochoa.sergiocontreras.horoscopochino2026.data.model.SignoChino
import net.iessochoa.sergiocontreras.horoscopochino2026.data.repository.HoroscopoRepository

data class HoroscopoUiState(
    val signos: List<SignoChino> = HoroscopoRepository.signos,
    val signoSeleccionado: SignoChino? = null,
    val anioNacimiento: String = "",
    val elementoCalculado: ElementoChino? = null,
)