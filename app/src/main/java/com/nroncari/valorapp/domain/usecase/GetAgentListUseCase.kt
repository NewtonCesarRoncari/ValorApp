package com.nroncari.valorapp.domain.usecase

import com.nroncari.valorapp.domain.repository.AgentRepository
import com.nroncari.valorapp.presentation.model.AgentPresentation

class GetAgentListUseCase(
    private val repository: AgentRepository
) {

    suspend operator fun invoke(): List<AgentPresentation> {
        val agentListPresentation = repository.getAgents().toMutableList()
        agentListPresentation.removeAt(4)
        return agentListPresentation.toList()
    }
}
