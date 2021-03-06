package com.nroncari.valorapp.data.datasource

import com.nroncari.valorapp.data.mapper.AgentsToDomainMapper
import com.nroncari.valorapp.data.service.AgentService

class AgentRemoteDataSourceImpl(
    private val service: AgentService
) : AgentRemoteDataSource {

    private val mapper = AgentsToDomainMapper()

    override suspend fun getAgents() = mapper.map(service.getAgents().data)

    override suspend fun getAgentDetail(uuid: String) = mapper.map(service.getAgentDetailById(uuid).data)
}
