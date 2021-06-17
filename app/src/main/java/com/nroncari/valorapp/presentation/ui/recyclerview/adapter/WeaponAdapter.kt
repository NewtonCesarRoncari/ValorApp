package com.nroncari.valorapp.presentation.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.nroncari.valorapp.R
import com.nroncari.valorapp.presentation.extension.loadImage
import com.nroncari.valorapp.presentation.model.WeaponPresentation
import com.nroncari.valorapp.presentation.model.WeaponSkinPresentation

class WeaponAdapter(
    private val context: Context,
    private val weapons: List<WeaponPresentation> = listOf(),
    var onItemClickListener: (skins: List<WeaponSkinPresentation>) -> Unit = {}
) : RecyclerView.Adapter<WeaponAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_weapon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weapons[position])
    }

    override fun getItemCount() = weapons.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var weapon: WeaponPresentation
        private val image: AppCompatImageView by lazy { itemView.findViewById(R.id.image_weapon) }
        private val name: AppCompatTextView by lazy { itemView.findViewById(R.id.title_weapon) }
        private val category: AppCompatTextView by lazy { itemView.findViewById(R.id.category_weapon) }

        fun bind(weapon: WeaponPresentation) {
            this.weapon = weapon
            weapon.displayIcon.let { imageAddress ->
                image.loadImage(imageAddress)
            }
            name.text = weapon.displayName
            category.text = weapon.category
        }

        init {
            itemView.setOnClickListener {
                if (::weapon.isInitialized)
                    onItemClickListener(weapon.skins)
            }
        }
    }
}
