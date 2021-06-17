package com.nroncari.valorapp.presentation.model

class AgentPresentation(
    val uuid: String,
    val displayName: String,
    val description: String,
    val developerName: String,
    val displayIcon: String,
    val bustPortrait: String?,
    val fullPortrait: String?,
    val killfeedPortrait: String?,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val isAvailableForTest: Boolean,
    val role: AgentRolePresentation?,
    val abilities: List<AgentAbilityPresentation>
)

data class AgentRolePresentation(
    val uuid: String,
    val displayName: String,
    val description: String,
    val displayIcon: String,
    val assetPath: String
)

data class AgentAbilityPresentation(
    val slot: String,
    val displayName: String?,
    val description: String?,
    val displayIcon: String?
)
