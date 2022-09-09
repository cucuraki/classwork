package com.example.hiltexample.ui.cources.models

data class ActiveCourcesModel(
    val id: Int,
    val buckingTime: String,
    val progress: Int,
    val title: String,
    val mainColor: String,
    val backgroundColorPercent: Int,
    val playButtonColorPercent: Int,
    val image: String
)