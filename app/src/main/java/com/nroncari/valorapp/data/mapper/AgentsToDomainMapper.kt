package com.nroncari.valorapp.data.mapper

import com.nroncari.valorapp.data.model.AgentResponse
import com.nroncari.valorapp.domain.model.AgentAbilityDomain
import com.nroncari.valorapp.domain.model.AgentDomain
import com.nroncari.valorapp.domain.model.AgentRoleDomain
import com.nroncari.valorapp.utils.Mapper

class AgentsToDomainMapper : Mapper<List<AgentResponse>, List<AgentDomain>> {

    override fun map(source: List<AgentResponse>): List<AgentDomain> {
        return source.map { agentResponse ->
            AgentDomain(
                uuid = agentResponse.uuid,
                displayName = agentResponse.displayName,
                description = agentResponse.description,
                developerName = agentResponse.developerName,
                displayIcon = agentResponse.displayIcon,
                bustPortrait = agentResponse.bustPortrait,
                fullPortrait = agentResponse.fullPortrait,
                isFullPortraitRightFacing = agentResponse.isFullPortraitRightFacing,
                killfeedPortrait = agentResponse.killfeedPortrait,
                isPlayableCharacter = agentResponse.isPlayableCharacter,
                isAvailableForTest = agentResponse.isAvailableForTest,
                role = agentResponse.role?.let { agentRoleResponse ->
                    AgentRoleDomain(
                        agentRoleResponse.uuid,
                        agentResponse.role.displayName,
                        agentResponse.role.description,
                        agentResponse.role.displayIcon,
                        agentResponse.role.assetPath,
                    )
                },
                abilities = agentResponse.abilities.map { agentAbilityResponse ->
                    AgentAbilityDomain(
                        agentAbilityResponse.slot,
                        agentAbilityResponse.displayName,
                        agentAbilityResponse.description,
                        agentAbilityResponse.displayIcon,
                    )
                }
            )
        }
    }

    fun map(source: AgentResponse): AgentDomain {
        return AgentDomain(
            uuid = source.uuid,
            displayName = source.displayName,
            description = source.description,
            developerName = source.developerName,
            displayIcon = source.displayIcon,
            bustPortrait = source.bustPortrait,
            fullPortrait = source.fullPortrait,
            killfeedPortrait = source.killfeedPortrait,
            isFullPortraitRightFacing = source.isFullPortraitRightFacing,
            isPlayableCharacter = source.isPlayableCharacter,
            isAvailableForTest = source.isAvailableForTest,
            role = source.role?.let { agentRoleDomain ->
                AgentRoleDomain(
                    agentRoleDomain.uuid,
                    source.role.displayName,
                    source.role.description,
                    source.role.displayIcon,
                    source.role.assetPath,
                )
            },
            abilities = source.abilities.map { agentAbilityResponse ->
                AgentAbilityDomain(
                    agentAbilityResponse.slot,
                    agentAbilityResponse.displayName,
                    agentAbilityResponse.description,
                    agentAbilityResponse.displayIcon,
                )
            }
        )
    }
}
