# Horóscopo Chino 2026

Aplicación Android que muestra los **12 signos del horóscopo chino** y la predicción de cada uno para **2026, el Año del Caballo**. El usuario recorre una cuadrícula de signos, entra al detalle de uno y, además de leer su predicción, puede **calcular su elemento chino** (Madera, Fuego, Tierra, Metal, Agua) introduciendo su año de nacimiento.

> Proyecto desarrollado como implementación de referencia para una práctica/examen de desarrollo Android (Kotlin + Jetpack Compose). A diferencia del examen *idealista / FFX Monster Hunter* (centrado en Retrofit), esta convocatoria evalúa **únicamente MVVM + Navigation**: la capa de datos es local y está resuelta, y el alumno trabaja sobre el `ViewModel`, el estado de UI y la navegación.

### Simplificaciones

Para acotar el alcance del examen se han hecho algunas simplificaciones deliberadas:

- **Datos en memoria**: no hay red ni persistencia. Los 12 signos viven hardcodeados en un `object HoroscopoRepository`; no se usan Retrofit, Coil ni Room (aunque esas librerías sigan declaradas en el version catalog, no se enlazan en código).
- **Signo seleccionado en el estado**: la pantalla de detalle no recibe el id por argumento de navegación, sino que lee `signoSeleccionado` del `HoroscopoUiState`. La navegación es por ruta simple (`"lista"` / `"detalle"`), sin parámetros.
- **Sin estados de carga/error**: al ser todo síncrono y en memoria, el `UiState` no modela `Loading` / `Error`; arranca directamente con la lista de signos disponible.
- **Cálculo de elemento simplificado**: el elemento se deriva del año de nacimiento mediante una regla acotada, una aproximación didáctica al ciclo real de los troncos celestes (la regla concreta es parte del ejercicio).

## Funcionalidad

- **Cuadrícula de signos** (`LazyVerticalGrid` de 2 columnas): cada `SignoCard` muestra el emoji, el nombre y los 3 años representativos más recientes del signo.
- **Detalle del signo**: cabecera con emoji y descripción (`SignoHeader`), tarjeta con la **predicción 2026** (`PrediccionCard`), **calculadora de elemento** (`ElementoCalculadorCard`) y la lista completa de años representativos.
- **Calcular elemento chino**: el usuario escribe su año de nacimiento en un `OutlinedTextField` numérico; el `ViewModel` calcula el `ElementoChino` correspondiente (solo para años válidos) y la UI muestra su emoji y nombre en tiempo real.
- **Navegación con back**: el `TopAppBar` cambia de título (`Horóscopo Chino 2026` ↔ `Tu horóscopo`) y muestra la flecha *Volver* solo en el detalle.

### Casos de uso

| # | Caso de uso | Pantalla origen | Acción |
|---|---|---|---|
| 1 | Ver los 12 signos del horóscopo chino | `SignoListScreen` | Carga inicial |
| 2 | Entrar al detalle de un signo | `SignoListScreen` | Tap sobre una `SignoCard` |
| 3 | Leer la predicción 2026 de un signo | `SignoDetailScreen` | Navegación desde la lista |
| 4 | Calcular el elemento chino por año de nacimiento | `SignoDetailScreen` | Escribir el año en el `ElementoCalculadorCard` |
| 5 | Volver al listado de signos | `SignoDetailScreen` | Flecha *Volver* del `TopAppBar` |

## Flujo

```
┌──────────────────────┐      tap signo       ┌──────────────────────┐
│   SignoListScreen    │ ───────────────────▶ │  SignoDetailScreen   │
│  (grid de 12 signos) │                      │ (predicción 2026 +   │
│                      │ ◀─────────────────── │  calculadora elemento)│
└──────────────────────┘   flecha "Volver"    └──────────────────────┘
```

### Ejemplo de uso

1. **Abrimos la app**: aparece la cuadrícula con los 12 signos (🐀 Rata, 🐂 Buey, … 🐎 Caballo, …), cada uno con sus años recientes.
2. **Tap en un signo** (p. ej. *Caballo*): navegamos al detalle, que muestra su descripción y la predicción para el Año del Caballo.
3. **Introducimos un año** en la calculadora: la tarjeta muestra al instante el elemento correspondiente con su emoji y nombre.
4. **Volvemos atrás**: el campo del año se limpia al seleccionar otro signo (el `ViewModel` resetea `anioNacimiento` y `elementoCalculado`).

## Tecnología

| Capa | Librería / herramienta |
|---|---|
| Lenguaje | Kotlin 2.3 |
| UI | Jetpack Compose + Material 3 |
| Navegación | Navigation Compose 2.9 |
| Arquitectura | MVVM con `ViewModel` + `StateFlow` |
| Datos | `object` repositorio en memoria (sin red ni persistencia) |
| Build | Gradle (Kotlin DSL) + version catalog `libs.versions.toml` |
| Min / Compile SDK | `minSdk 26` / `compileSdk 36` |

## Arquitectura

Patrón **MVVM** con un único `ViewModel` compartido por toda la app:

```
ui/
 ├─ HoroscopoChinoApp.kt              ── Scaffold + CenterAlignedTopAppBar (título dinámico, back automático)
 ├─ navigation/AppNavigation.kt       ── NavHost con rutas LISTA y DETALLE (object Routes)
 ├─ screens/
 │   ├─ HoroscopoViewModel.kt         ── ViewModel, expone StateFlow<HoroscopoUiState>
 │   ├─ HoroscopoUiState.kt           ── data class inmutable de estado
 │   ├─ lista/SignoListScreen.kt      ── cuadrícula de signos
 │   └─ detalle/SignoDetailScreen.kt  ── detalle + calculadora de elemento
 └─ components/                       ── SignoCard, SignoHeader, PrediccionCard, ElementoCalculadorCard

data/
 ├─ model/SignoChino.kt               ── modelo de signo
 ├─ model/ElementoChino.kt            ── enum de los 5 elementos (nombre + emoji)
 └─ repository/HoroscopoRepository.kt ── object con los 12 signos hardcodeados
```

Las pantallas son **stateless**: reciben el `HoroscopoUiState` y callbacks (`onSignoClick`, `onAnioChange`). El `ViewModel` nunca se pasa directamente a una `screen`, solo a `AppNavigation`, que enlaza las acciones con métodos del VM.

### Navegación

`AppNavigation` define un `NavHost` con dos destinos (lista y detalle), siendo la lista el destino inicial:

- **Lista → Detalle**: al pulsar un signo hay que actualizar primero el estado del `ViewModel` (signo seleccionado) y después navegar al detalle.
- **Detalle → Lista**: el botón *Volver* del `TopAppBar` regresa atrás en la pila. La flecha solo se muestra cuando el destino actual es el detalle.

No se pasan argumentos por la ruta: el signo seleccionado viaja en el `UiState`. Es una simplificación consciente para centrar el examen en el cableado VM ↔ navegación.

## Modelo de dominio

```kotlin
data class SignoChino(
    val id: String,
    val nombre: String,
    val emoji: String,
    val aniosRepresentativos: List<Int>,
    val descripcion: String,
    val prediccion2026: String,
)

enum class ElementoChino(val nombre: String, val emoji: String) {
    MADERA("Madera", "🌿"),
    FUEGO("Fuego", "🔥"),
    TIERRA("Tierra", "🌍"),
    METAL("Metal", "⚙️"),
    AGUA("Agua", "💧"),
}
```

El estado de la sesión vive en `HoroscopoUiState` (lo declara el alumno). Debe mantener,
de forma inmutable, los signos a mostrar, el signo seleccionado (nullable), el texto del año
introducido y el elemento calculado (nullable). El estado es "tonto": no contiene lógica.

### Punto de lógica: cálculo del elemento

El `ViewModel` deriva el `ElementoChino` a partir del año de nacimiento. Es la pieza de
lógica "con nota" del examen: hay que convertir el texto del campo a número de forma segura,
validar que sea un año razonable (en caso contrario el elemento queda sin calcular) y aplicar
la regla del ciclo chino que asocia cada año con un elemento. La implementación concreta es
parte de lo que se evalúa y **no se incluye aquí**.

## Cómo ejecutar

Requisitos: **Android Studio** (Kotlin 2.3, AGP 8.13, `compileSdk 36`) y un emulador o dispositivo con **API 26+**.

```powershell
# Build debug APK
.\gradlew.bat assembleDebug

# Instalar en el dispositivo / emulador conectado
.\gradlew.bat installDebug

# Tests unitarios
.\gradlew.bat test

# Lint
.\gradlew.bat lint
```

En macOS / Linux, usar `./gradlew` en lugar de `.\gradlew.bat`.

## Examen: ejes evaluados (MVVM + Navigation)

Esta convocatoria evalúa **MVVM y Navigation**; la capa de datos (`HoroscopoRepository`) viene resuelta. El alumno debe completar el cableado del estado, el `ViewModel` y la navegación:

| Eje | Qué debe implementar el alumno |
|---|---|
| `HoroscopoUiState` | Modelar el estado de la UI (signos, signo seleccionado, año, elemento). |
| `HoroscopoViewModel` | Exponer `StateFlow<HoroscopoUiState>`, `onSignoSelected` y `onAnioNacimientoChange` (incluido el cálculo del elemento). |
| `AppNavigation` | `NavHost` con rutas `LISTA`/`DETALLE`, conectar callbacks de las pantallas con el VM y `navigate` / `popBackStack`. |
| `HoroscopoChinoApp` | `Scaffold` + `TopAppBar` con título dinámico y flecha *Volver* según la ruta actual. |
| Pantallas (`SignoListScreen`, `SignoDetailScreen`) | Renderizar el estado y emitir callbacks (stateless). |

### Rúbrica orientativa (sobre 10)

**Para optar a un nivel hay que tener resueltos los anteriores** — no se puede saltar etapas.

- **4** — `HoroscopoUiState` modelado y `SignoListScreen` muestra la cuadrícula de los 12 signos a partir del estado.
- **6** — Navegación lista → detalle funcionando: `onSignoSelected` fija el signo en el estado y `SignoDetailScreen` muestra su predicción 2026.
- **8** — Back correcto (`TopAppBar` con título dinámico y flecha *Volver* solo en detalle) y `popBackStack` cableado.
- **10** — **Punto de lógica**: la calculadora de elemento funciona (campo numérico → `ElementoChino`), manejando entrada vacía / no numérica / fuera de rango.

## Notas de proyecto

- **Sin persistencia ni red**: todo es en memoria; los datos se reinician en cada arranque.
- **Sin DI**: las dependencias se cablean a mano (`HoroscopoRepository` es un `object`).
- **Tema**: `HoroscopoChino2026Theme` usa color dinámico y sigue el modo claro/oscuro del sistema (`isSystemInDarkTheme()`).
- **Paquete Kotlin**: `net.iessochoa.sergiocontreras.horoscopochino2026`.
</content>
</invoke>
