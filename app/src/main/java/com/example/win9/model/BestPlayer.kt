package com.example.win9.model


import com.google.gson.annotations.SerializedName

data class BestPlayer(
    val description: String,
    val img: String,
    val name: String,
    val playerstyle: String,
    val rank: String,
    val team: String
)