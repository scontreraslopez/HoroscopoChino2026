package net.iessochoa.sergiocontreras.horoscopochino2026.ui.screens

import net.iessochoa.sergiocontreras.horoscopochino2026.data.model.ElementoChino
import net.iessochoa.sergiocontreras.horoscopochino2026.data.model.SignoChino
import net.iessochoa.sergiocontreras.horoscopochino2026.data.repository.HoroscopoRepository

/**
 * STARTER — Estado de la UI (MVVM).
 *
 * Declara aquí la data class inmutable que representa TODO el estado de la pantalla.
 * La capa de datos (HoroscopoRepository) ya está resuelta: úsala como valor por defecto
 * de la lista de signos.
 *
 * Pistas — el estado debe poder responder a estas preguntas:
 *  - ¿Qué signos hay que mostrar en la cuadrícula?            -> lista de signos
 *  - ¿Qué signo ha elegido el usuario (o ninguno todavía)?   -> signo seleccionado (nullable)
 *  - ¿Qué año de nacimiento ha escrito en la calculadora?    -> texto del campo
 *  - ¿Qué elemento se ha calculado (o ninguno todavía)?      -> elemento (nullable)
 *
 * Recuerda: el estado es "tonto" e inmutable. No metas lógica aquí; las pantallas
 * derivan lo que necesiten directamente del estado.
 *
 * Nota: en la entrega del examen este fichero se renombra a HoroscopoUiState.kt y la clase
 * pasa a llamarse HoroscopoUiState. Mientras convive con la versión canónica usa el sufijo
 * Starter para no chocar con ella.
 */
data class HoroscopoUiStateStarter(
    // TODO: declara las propiedades del estado. Por ejemplo:
    //  - signos: List<SignoChino> con valor por defecto HoroscopoRepository.signos
    //  - signoSeleccionado: SignoChino? = null
    //  - anioNacimiento: String = ""
    //  - elementoCalculado: ElementoChino? = null
    val placeholder: Unit = Unit, // TODO: elimina esta línea al declarar tus propiedades
)
