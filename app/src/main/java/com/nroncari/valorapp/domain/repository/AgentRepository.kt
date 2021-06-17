package com.nroncari.valorapp.domain.repository

import com.nroncari.valorapp.presentation.model.AgentPresentation

interface AgentRepository {

    suspend fun getAgents(): List<AgentPresentation>

    suspend fun getAgentById(uuid: String): AgentPresentation
}
