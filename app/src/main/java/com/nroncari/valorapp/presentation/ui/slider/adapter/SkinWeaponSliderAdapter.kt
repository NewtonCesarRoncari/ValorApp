package com.nroncari.valorapp.presentation.ui.slider.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView
import com.nroncari.valorapp.R
import com.nroncari.valorapp.presentation.ui.slider.SkinWeaponSliderItem
import com.squareup.picasso.Picasso

class SkinWeaponSliderAdapter(
    private val skins: List<SkinWeaponSliderItem>,
) : RecyclerView.Adapter<SkinWeaponSliderAdapter.SliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_skin_weapon, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.setImageView(skins[position])
    }

    override fun getItemCount() = skins.size

    inner class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: RoundedImageView by lazy { itemView.findViewById(R.id.image_slide) }

        fun setImageView(sliderItem: SkinWeaponSliderItem) {
            Picasso.get().load(sliderItem.image).into(imageView)

        }
    }
}
