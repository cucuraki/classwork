package com.example.hiltexample.ui.cources.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltexample.databinding.Item2Binding
import com.example.hiltexample.extrnsions.load
import com.example.hiltexample.ui.cources.adapters.diffutils.ActiveDiffUtil
import com.example.hiltexample.ui.cources.models.ActiveCourcesModel

class VerticalAdapter :
    ListAdapter<ActiveCourcesModel, VerticalAdapter.ViewHolder>(ActiveDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            Item2Binding.inflate(
                LayoutInflater.from(parent.context)
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(private val binding: Item2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = getItem(position)
            val opsBck = Integer.toHexString((model.backgroundColorPercent * 255 / 100))
            val opsPlay = Integer.toHexString((model.playButtonColorPercent * 255 / 100))
            val colorBackground = Color.parseColor("#$opsBck${model.mainColor}")
            val colorText = Color.parseColor("#${model.mainColor}")
            val colorPlayButton = Color.parseColor("#$opsPlay${model.mainColor}")
            with(binding){
                //rm.setBackgroundColor(color)
                rm.backgroundTintList = ColorStateList.valueOf(colorBackground)
                image.load(model.image)
                progressBar.progress = model.progress
                time.text = model.buckingTime
                time.setTextColor(colorText)
                play.backgroundTintList = ColorStateList.valueOf(colorPlayButton)
                //time.setBackgroundColor(colo r)
            }
        }
    }


}