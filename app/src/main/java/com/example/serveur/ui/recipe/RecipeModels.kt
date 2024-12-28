package com.example.serveur.ui.recipe

data class CookingMethod(
    val name: String,
    val imageUrl: String,
    val isFavorite: Boolean = false
)

data class CuisineType(
    val name: String,
    val flag: String
)
