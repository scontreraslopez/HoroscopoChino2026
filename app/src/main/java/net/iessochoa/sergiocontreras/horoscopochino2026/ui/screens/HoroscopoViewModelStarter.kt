package net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import net.iessochoa.sergiocontreras.horoscopochino2026.data.model.ElementoChino
import net.iessochoa.sergiocontreras.horoscopochino2026.data.repository.HoroscopoRepository

/**
 * STARTER — ViewModel (MVVM).
 *
 * Responsabilidades:
 *  1. Mantener un estado privado y mutable y exponerlo como StateFlow inmutable.
 *  2. Ofrecer métodos de acción que la navegación/pantallas invocan para actualizar el estado.
 *
 * Reglas:
 *  - El estado NUNCA se expone como mutable hacia fuera.
 *  - Cada acción produce un NUEVO estado con copy(...); no mutes el actual.
 *  - La capa de datos (HoroscopoRepository) ya está resuelta: úsala para buscar el signo.
 *
 * Nota: en la entrega del examen este fichero se renombra a HoroscopoViewModel.kt y la clase
 * a HoroscopoViewModel (sin sufijo Starter).
 */
class HoroscopoViewModelStarter : ViewModel() {

    // TODO 1: declara el estado privado mutable (MutableStateFlow) y su versión pública
    //         de solo lectura (StateFlow, con asStateFlow()).

    /**
     * El usuario ha pulsado un signo en la lista.
     * Debe fijar el signo seleccionado en el estado y resetear la calculadora
     * (año en blanco y elemento sin calcular).
     */
    fun onSignoSelected(signoId: String) {
        // TODO 2:
        //  - busca el signo con HoroscopoRepository.getSignoPorId(signoId); si es null, no hagas nada.
        //  - actualiza el estado: signo seleccionado = signo, año = "", elemento = null
        TODO("Implementa la selección de signo")
    }

    /**
     * El usuario ha escrito/modificado el año en la calculadora de elemento.
     * Debe guardar el texto y, si es un año válido (rango razonable de años),
     * calcular el elemento; en caso contrario, dejar el elemento a null.
     */
    fun onAnioNacimientoChange(anio: String) {
        // TODO 3:
        //  - convierte el texto a Int de forma segura.
        //  - valida que sea un año razonable; si no, el elemento queda sin calcular (null).
        //  - actualiza el estado con el nuevo texto y el elemento resultante.
        TODO("Implementa el cambio de año y el cálculo del elemento")
    }

    /**
     * Punto de lógica: deriva el elemento chino a partir del año de nacimiento.
     * Investiga la relación entre el último dígito del año y el elemento del ciclo chino.
     */
    private fun calcularElemento(anio: Int): ElementoChino {
        // TODO 4: implementa la regla que asigna un ElementoChino a cada año.
        TODO("Implementa el cálculo del elemento")
    }
}
