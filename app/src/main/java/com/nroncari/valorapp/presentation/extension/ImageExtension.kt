package com.nroncari.valorapp.presentation.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.makeramen.roundedimageview.RoundedImageView

fun ImageView.loadImage(
    imageAddress: String,
) {
    Glide.with(this)
        .load(imageAddress)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .centerCrop()
        .into(this)
}

fun RoundedImageView.loadImage(
    imageAddress: String,
) {
    Glide.with(this)
        .load(imageAddress)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .centerCrop()
        .into(this)
}
