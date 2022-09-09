package com.example.hiltexample.ui.cources.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltexample.databinding.Item1Binding
import com.example.hiltexample.ui.cources.adapters.diffutils.HorizontalDiffUtil
import com.example.hiltexample.ui.cources.models.NewCursesModel
import java.util.concurrent.TimeUnit


class HorizontalAdapter :
    ListAdapter<NewCursesModel, HorizontalAdapter.ViewHolder>(HorizontalDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        Item1Binding.inflate(
            LayoutInflater.from(parent.context)
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(private val binding: Item1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            val model = getItem(position)
            val color = Color.parseColor("#${model.mainColor}")
            with(binding){
                root.backgroundTintList = ColorStateList.valueOf(color)
                title.text = model.title
                icon.setImageResource(model.iconType.getIcon())
                val timeMin = TimeUnit.SECONDS.toMinutes(model.duration)
                duration.text = "${timeMin} min"
                question.text = model.question
            }
        }
    }
}
