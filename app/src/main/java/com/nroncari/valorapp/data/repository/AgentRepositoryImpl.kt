package com.nroncari.valorapp.data.repository

import com.nroncari.valorapp.data.datasource.AgentRemoteDataSource
import com.nroncari.valorapp.domain.mapper.AgentsToPresentationMapper
import com.nroncari.valorapp.domain.repository.AgentRepository
import com.nroncari.valorapp.presentation.model.AgentPresentation

class AgentRepositoryImpl(
    private val remoteDataSource: AgentRemoteDataSource
) : AgentRepository {

    private val mapper = AgentsToPresentationMapper()

    override suspend fun getAgents(): List<AgentPresentation> =
        mapper.map(remoteDataSource.getAgents())

    override suspend fun getAgentById(uuid: String): AgentPresentation =
        mapper.map(remoteDataSource.getAgentDetail(uuid))
}
