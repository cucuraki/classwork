package com.example.hiltexample.ui.cources.models


data class NewCursesModel(
    val id: Int,
    val iconType: Type,
    val duration: Long,
    val title: String,
    val question: String,
    val mainColor: String
)