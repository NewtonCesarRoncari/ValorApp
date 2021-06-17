package com.nroncari.valorapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nroncari.valorapp.databinding.FragmentAgentListBinding
import com.nroncari.valorapp.presentation.ui.recyclerview.adapter.AgentAdapter
import com.nroncari.valorapp.presentation.viewModel.AgentListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListAgentFragment : Fragment() {

    private val viewBinding by lazy {
        FragmentAgentListBinding.inflate(layoutInflater)
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

        listeners()
    }

    private fun listeners() {
        viewModel.agents.observe(viewLifecycleOwner, { agentList ->
            viewBinding.agentListRv.adapter =
                AgentAdapter(requireContext(), agentList, onItemClickListener = { uuid ->
                    goToAgentDetailFragment(uuid)
                })

            viewBinding.shimmerLayout.stopShimmer()
            viewBinding.shimmerLayout.visibility = GONE
            viewBinding.agentListRv.visibility = VISIBLE
        })
    }

    private fun goToAgentDetailFragment(uuid: String) {
        val direction = HomeFragmentDirections
            .actionHomeFragmentToAgentDetailFragment(uuid)
        findNavController().navigate(direction)
    }
}
