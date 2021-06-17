package com.nroncari.valorapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.nroncari.valorapp.R
import com.nroncari.valorapp.databinding.FragmentHomeBinding
import com.nroncari.valorapp.presentation.ui.tabs.adapter.TabsAdapter
import com.nroncari.valorapp.presentation.viewModel.AgentListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private val viewModel: AgentListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getAgents()
        initTabLayout(view)
    }

    private fun initTabLayout(view: View) {
        val tabsAdapter = TabsAdapter(requireActivity())
        val viewPager by lazy {
            view.findViewById<ViewPager2>(R.id.view_pager)
        }

        viewPager.adapter = tabsAdapter
        viewPager.isSaveEnabled = false
        TabLayoutMediator(viewBinding.tabLayout, viewPager) { tab, position ->
            val tabTitles = arrayOf("Agentes", "Armas")
            tab.text = tabTitles[position]
        }.attach()
    }
}
