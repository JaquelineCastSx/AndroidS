package com.example.roomprojectapp.data.mockData

import com.example.roomprojectapp.domain.models.Player

class MockData {
    companion object{
        val players = listOf<Player>(
            Player(1, "Cuauhtémoc Blanco", "Delantero", "imagen_cuauhtemoc.jpg"),
            Player(2, "Hugo Sánchez", "Delantero", "imagen_hugo.jpg"),
            Player(3, "Carlos Reinoso", "Centrocampista", "imagen_reinoso.jpg"),
            Player(4, "Germán Villa", "Defensa", "imagen_villa.jpg"),
            Player(5, "Luis Roberto Alves", "Delantero", "imagen_zague.jpg"),
            Player(6, "Luis Miguel Salvador", "Portero", "imagen_salvador.jpg"),
            Player(7, "Ramón Ramírez", "Centrocampista", "imagen_ramirez.jpg"),
            Player(8, "Alfredo Tena", "Defensa", "imagen_tena.jpg"),
            Player(9, "Emilio Butragueño", "Delantero", "imagen_butragueno.jpg"),
            Player(10, "Raúl Jiménez", "Delantero", "imagen_raul.jpg")
        )
    }
}