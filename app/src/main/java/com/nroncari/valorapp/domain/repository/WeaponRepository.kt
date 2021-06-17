package com.nroncari.valorapp.domain.repository

import com.nroncari.valorapp.presentation.model.WeaponPresentation

interface WeaponRepository {

    suspend fun getListWeapon(): List<WeaponPresentation>
}
