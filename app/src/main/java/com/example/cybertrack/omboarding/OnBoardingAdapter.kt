package com.example.cybertrack.omboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cybertrack.R

class OnBoardingAdapter : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    var item = mutableListOf<Triple<Int, String, String>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_onboarding, parent, false)
        return OnBoardingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size


    inner class OnBoardingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Triple<Int, String, String>) {
            val image = itemView.findViewById<AppCompatImageView>(R.id.onboarding_image)
            val title = itemView.findViewById<TextView>(R.id.onboarding_title)
            val description = itemView.findViewById<TextView>(R.id.onboarding_description)

            image.setImageResource(item.first)
            title.text = item.second
            description.text = item.third
        }
    }
}