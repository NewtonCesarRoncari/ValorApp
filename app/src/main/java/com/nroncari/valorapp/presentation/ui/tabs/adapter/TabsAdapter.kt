package com.nroncari.valorapp.presentation.ui.tabs.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nroncari.valorapp.presentation.ui.ListAgentFragment
import com.nroncari.valorapp.presentation.ui.ListWeaponFragment

class TabsAdapter(fm: FragmentActivity) :
    FragmentStateAdapter(fm) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ListAgentFragment()
            1 -> ListWeaponFragment()
            else -> ListAgentFragment()
        }
    }
}
