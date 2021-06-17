package com.nroncari.valorapp.presentation.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nroncari.valorapp.databinding.DialogSkinBottomSheetBinding
import com.nroncari.valorapp.presentation.model.WeaponSkinPresentation
import com.nroncari.valorapp.presentation.ui.slider.SkinWeaponSliderItem
import com.nroncari.valorapp.presentation.ui.slider.adapter.SkinWeaponSliderAdapter
import kotlin.math.abs

class SkinBottomSheetDialog(private val skins: List<WeaponSkinPresentation>) :
    BottomSheetDialogFragment() {

    private val viewBinding by lazy {
        DialogSkinBottomSheetBinding.inflate(layoutInflater)
    }
    private lateinit var viewPager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPager2 = viewBinding.weaponViewPager
        initWeaponSkinSlider(skins)
    }

    private fun initWeaponSkinSlider(skins: List<WeaponSkinPresentation>) {
        val sliderItems = skins.map { SkinWeaponSliderItem(it.displayIcon) }
        val sliderItemsWithImages = mutableListOf<SkinWeaponSliderItem>()

        for (slideItem in sliderItems) {
            if (slideItem.image.isNotEmpty())
                sliderItemsWithImages.add(slideItem)
        }

        with(viewPager2) {
            adapter = SkinWeaponSliderAdapter(sliderItemsWithImages)
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER
        }

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { view: View, fl: Float ->
            val r = 1 - abs(fl)
            view.scaleY = 0.85f + r * 0.15f
        }

        viewPager2.setPageTransformer(compositePageTransformer)
    }
}
