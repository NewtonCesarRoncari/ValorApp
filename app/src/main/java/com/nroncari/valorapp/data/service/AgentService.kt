package com.nroncari.valorapp.data.service

import com.nroncari.valorapp.data.model.AgentResponse
import com.nroncari.valorapp.data.model.BaseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface AgentService {

    @GET("agents?language=pt-BR")
    suspend fun getAgents(): BaseModel<List<AgentResponse>>

    @GET("agents/{agentUuid}?language=pt-BR")
    suspend fun getAgentDetailById(@Path("agentUuid")uuid: String): BaseModel<AgentResponse>
}
