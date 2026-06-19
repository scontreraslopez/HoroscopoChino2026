package net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iessochoa.sergiocontreras.horoscopochino2026.data.model.ElementoChino
import net.iessochoa.sergiocontreras.horoscopochino2026.data.repository.HoroscopoRepository

class HoroscopoViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HoroscopoUiState())
    val uiState: StateFlow<HoroscopoUiState> = _uiState.asStateFlow()

    fun onSignoSelected(signoId: String) {
        val signo = HoroscopoRepository.getSignoPorId(signoId) ?: return
        _uiState.update { it.copy(signoSeleccionado = signo, anioNacimiento = "", elementoCalculado = null) }
    }

    fun onAnioNacimientoChange(anio: String) {
        val anioInt = anio.toIntOrNull()
        val elemento = if (anioInt != null && anioInt in 1900..2100) calcularElemento(anioInt) else null
        _uiState.update { it.copy(anioNacimiento = anio, elementoCalculado = elemento) }
    }

    private fun calcularElemento(anio: Int): ElementoChino {
        return when (anio % 10) {
            0, 1 -> ElementoChino.METAL
            2, 3 -> ElementoChino.AGUA
            4, 5 -> ElementoChino.MADERA
            6, 7 -> ElementoChino.FUEGO
            else -> ElementoChino.TIERRA
        }
    }
}