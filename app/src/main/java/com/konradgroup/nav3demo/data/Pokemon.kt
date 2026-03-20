package com.konradgroup.nav3demo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Double,
    val height: Double,
    val abilities: List<String>,
    val types: List<String>,
    val evolutions: List<Int>,
    val description: String,
    val images: PokemonImages
)

@Serializable
data class PokemonImages(
    val full: String,
    @SerialName("sprite_front") val spriteFront: String,
    @SerialName("sprite_back") val spriteBack: String
)
