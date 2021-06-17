package com.nroncari.valorapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nroncari.valorapp.databinding.FragmentWeaponListBinding
import com.nroncari.valorapp.presentation.ui.dialog.SkinBottomSheetDialog
import com.nroncari.valorapp.presentation.ui.recyclerview.adapter.WeaponAdapter
import com.nroncari.valorapp.presentation.viewModel.WeaponListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListWeaponFragment : Fragment() {

    private val viewBinding by lazy {
        FragmentWeaponListBinding.inflate(layoutInflater)
    }
    private val viewModel: WeaponListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getWeaponList()

        listeners()
    }

    private fun listeners() {
        viewModel.weapons.observe(viewLifecycleOwner, { weaponList ->
            viewBinding.weaponListRv.adapter =
                WeaponAdapter(requireContext(), weaponList, onItemClickListener = { skins ->
                    val skinBottomSheetDialog = SkinBottomSheetDialog(skins)
                    skinBottomSheetDialog.show(parentFragmentManager, "bottomSheet")
                })

            viewBinding.shimmerLayout.stopShimmer()
            viewBinding.shimmerLayout.visibility = GONE
            viewBinding.weaponListRv.visibility = VISIBLE
        })
    }
}
