package com.example.hiltexample.data.models

import com.example.hiltexample.ui.cources.models.ActiveCourcesModel
import com.squareup.moshi.Json

data class CourcesModel(
    @Json(name = "new_courses")
    val newCourses: List<NewCourses>,
    @Json(name = "active_courses")
    val activeCourses: List<ActiveCourses>
) {
    data class NewCourses(
        val id: Int,
        @Json(name = "icon_type")
        val iconType: String,
        val duration: Long,
        val title: String,
        val question: String,
        @Json(name = "main_color")
        val mainColor: String
    )

    data class ActiveCourses(
        val id: Int,
        @Json(name = "booking_time")
        val bookingTime: String,
        val progress: Int,
        val title: String,
        @Json(name = "main_color")
        val mainColor: String,
        @Json(name = "background_color_percent")
        val backgroundColorPercent: Int,
        @Json(name = "play_button_color_percent")
        val playButtonColorPercent: Int,
        val image: String
    )

    fun toActiveCourcesList(): List<ActiveCourcesModel> {
        return this.activeCourses.map {
            ActiveCourcesModel(
                id = it.id,
                buckingTime = it.bookingTime,
                progress = it.progress,
                title = it.title,
                mainColor = it.mainColor,
                backgroundColorPercent = it.backgroundColorPercent,
                playButtonColorPercent = it.playButtonColorPercent,
                image = it.image
            )
        }
    }
}