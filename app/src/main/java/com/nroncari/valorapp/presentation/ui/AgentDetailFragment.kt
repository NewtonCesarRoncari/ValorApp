package com.nroncari.valorapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.nroncari.valorapp.databinding.FragmentAgentDetailBinding
import com.nroncari.valorapp.presentation.extension.loadImage
import com.nroncari.valorapp.presentation.model.AgentPresentation
import com.nroncari.valorapp.presentation.viewModel.AgentDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AgentDetailFragment : Fragment() {

    private val args by navArgs<AgentDetailFragmentArgs>()
    private val agentId by lazy { args.uuid }
    private val viewModel: AgentDetailViewModel by viewModel()
    private val viewBinding by lazy {
        FragmentAgentDetailBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getAgentDetail(agentId)
        listeners()
    }

    private fun listeners() {
        viewModel.agent.observe(viewLifecycleOwner, { agentPresentation ->
            bindingFields(agentPresentation)
            viewBinding.shimmerLayout.stopShimmer()
            viewBinding.shimmerLayout.visibility = GONE
            viewBinding.layout.visibility = VISIBLE
        })
    }

    private fun bindingFields(agentPresentation: AgentPresentation) {
        with(viewBinding) {
            agentName.text = agentPresentation.displayName
            agentNameRole.text = agentPresentation.role?.displayName ?: ""
            agentPresentation.displayIcon.let { agentImage.loadImage(it) }
            textBiography.text = agentPresentation.description
            agentPresentation.abilities[0].displayIcon?.let { imageAbilities.loadImage(it) }
            titleAbilities.text = agentPresentation.abilities[0].displayName
            descriptionAbilities.text = agentPresentation.abilities[0].description
            agentPresentation.abilities[1].displayIcon?.let { imageAbilities1.loadImage(it) }
            titleAbilities1.text = agentPresentation.abilities[1].displayName
            descriptionAbilities1.text = agentPresentation.abilities[1].description
            agentPresentation.abilities[2].displayIcon?.let { imageAbilities2.loadImage(it) }
            titleAbilities2.text = agentPresentation.abilities[2].displayName
            descriptionAbilities2.text = agentPresentation.abilities[2].description
            agentPresentation.abilities[3].displayIcon?.let { imageAbilities3.loadImage(it) }
            titleAbilities3.text = agentPresentation.abilities[3].displayName
            descriptionAbilities3.text = agentPresentation.abilities[3].description
        }
    }
}
