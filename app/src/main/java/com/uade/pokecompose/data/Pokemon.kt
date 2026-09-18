package com.uade.pokecompose.data

/**
 * Representa un Pokémon dentro de la Pokédex.
 * Contiene el nombre y la URL canónica de la PokeAPI para extraer su ID y sprite.
 */
data class Pokemon(
    val name: String,
    val url: String
) {
    // Extrae el ID numérico desde el final de la URL (ej: ".../pokemon/25/" -> 25)
    val id: Int
        get() = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0

    // Formatea el nombre con la primera letra en mayúscula
    val nameFormatted: String
        get() = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }

    // URL oficial del sprite del Pokémon
    val spriteUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}
