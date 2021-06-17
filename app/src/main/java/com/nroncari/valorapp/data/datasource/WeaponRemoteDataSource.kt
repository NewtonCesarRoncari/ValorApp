package com.nroncari.valorapp.data.datasource

import com.nroncari.valorapp.domain.model.WeaponDomain

interface WeaponRemoteDataSource {

    suspend fun getWeapons(): List<WeaponDomain>
}
