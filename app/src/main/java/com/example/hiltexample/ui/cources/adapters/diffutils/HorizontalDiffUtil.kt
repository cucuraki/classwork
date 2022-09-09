package com.example.hiltexample.ui.cources.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.hiltexample.ui.cources.models.NewCursesModel

class HorizontalDiffUtil : DiffUtil.ItemCallback<NewCursesModel>() {
    override fun areItemsTheSame(oldItem: NewCursesModel, newItem: NewCursesModel) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: NewCursesModel, newItem: NewCursesModel) =
        oldItem == newItem
}