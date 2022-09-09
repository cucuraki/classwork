package com.example.hiltexample.ui.cources.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.hiltexample.ui.cources.models.ActiveCourcesModel

class ActiveDiffUtil : DiffUtil.ItemCallback<ActiveCourcesModel>() {
    override fun areItemsTheSame(
        oldItem: ActiveCourcesModel,
        newItem: ActiveCourcesModel
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ActiveCourcesModel,
        newItem: ActiveCourcesModel
    ) = oldItem == newItem
}