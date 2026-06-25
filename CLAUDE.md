# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this is

Android reference project for a vocational exam (2º DAM). The app — **Horóscopo Chino 2026** — shows the 12 Chinese zodiac signs and a per-sign 2026 prediction, plus a calculator that derives the user's Chinese element from a birth year. Unlike the related idealista/FFX exam (Retrofit-focused), **this edition evaluates only MVVM + Navigation**: the data layer is local and already solved.

## Commands

Use the Gradle wrapper (`gradlew.bat` on Windows, `./gradlew` on macOS/Linux):

```powershell
.\gradlew.bat assembleDebug          # build debug APK
.\gradlew.bat installDebug           # install on connected device/emulator
.\gradlew.bat test                   # JVM unit tests
.\gradlew.bat test --tests "net.iessochoa.sergiocontreras.horoscopochino2026.SomeTest.method"  # single test
.\gradlew.bat connectedDebugAndroidTest   # instrumented tests (needs device)
.\gradlew.bat lint                   # Android lint
```

Targets: `minSdk 26`, `compileSdk 36`, Kotlin 2.3, AGP 8.13, Compose BOM 2026.01.01.

## Architecture

MVVM with a **single shared `HoroscopoViewModel`** for the whole app. Key invariant: the `ViewModel` is created once in `HoroscopoChinoApp` and passed only to `AppNavigation` — **never directly to a screen**. Screens are stateless: they receive `HoroscopoUiState` and callbacks.

- `data/repository/HoroscopoRepository.kt` — `object` holding the 12 signs hardcoded **in memory**. No Retrofit/Coil/Room/network/persistence (those libs sit unused in the version catalog). Data resets every launch.
- `ui/screens/HoroscopoUiState.kt` — immutable state: `signos`, `signoSeleccionado`, `anioNacimiento`, `elementoCalculado`. No `Loading`/`Error` states (everything is synchronous).
- `ui/screens/HoroscopoViewModel.kt` — exposes `StateFlow<HoroscopoUiState>`; `onSignoSelected(id)` sets the selected sign, `onAnioNacimientoChange` runs the element calculation (the "logic point" of the exam: handles empty/non-numeric/out-of-range `1900..2100`, element = `anio % 10`).
- `ui/navigation/AppNavigation.kt` — `NavHost` with two routes (`Routes.LISTA`, `Routes.DETALLE`). **No nav arguments**: the selected sign travels in `UiState`, not the route. Tap calls `onSignoSelected` then `navigate(DETALLE)`.
- `ui/HoroscopoChinoApp.kt` — `Scaffold` + `CenterAlignedTopAppBar` with dynamic title and a back arrow shown only on the detail route (via `currentBackStackEntryAsState`).

## Exam context

`README.md` documents the rubric. The data layer is given; the graded axes are `HoroscopoUiState`, `HoroscopoViewModel`, `AppNavigation`, `HoroscopoChinoApp`, and the two stateless screens. When modifying, preserve the deliberate simplifications (in-memory repo, sign-in-state navigation, no load/error states) — they are pedagogical, not oversights.

## Naming note

Package and identifiers are Spanish (`SignoChino`, `ElementoChino`, `prediccion2026`); UI strings are Spanish. Match this when adding code.
</content>
