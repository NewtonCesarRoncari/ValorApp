package com.nroncari.valorapp.data.datasource

import com.nroncari.valorapp.domain.model.AgentDomain

interface AgentRemoteDataSource {

    suspend fun getAgents(): List<AgentDomain>

    suspend fun getAgentDetail(uuid: String): AgentDomain
}
