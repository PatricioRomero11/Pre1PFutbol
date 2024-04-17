package com.example.mypre1p

data class Equipo(
    val id: Int,
    val nombre: String,
    val apodo: String,
    val estadio: String,
    val escudo: String,
    val pais: Pais,
)
enum class Pais{
    ARGENTINA,BRAZIL, CHILE, COLOMBIA,URUGUAY
}
