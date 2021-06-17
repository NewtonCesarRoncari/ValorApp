package com.nroncari.valorapp.domain.usecase

import com.nroncari.valorapp.domain.repository.AgentRepository

class GetAgentDetailUseCase(
    private val repository: AgentRepository
) {

    suspend operator fun invoke(uuid: String) = repository.getAgentById(uuid)
}
