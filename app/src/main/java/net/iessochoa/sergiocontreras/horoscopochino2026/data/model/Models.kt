package net.iessochoa.sergiocontreras.horoscopochino2026.data.model

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