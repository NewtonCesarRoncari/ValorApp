package com.nroncari.valorapp.data.repository

import com.nroncari.valorapp.data.datasource.WeaponRemoteDataSource
import com.nroncari.valorapp.domain.mapper.WeaponToPresentationMapper
import com.nroncari.valorapp.domain.repository.WeaponRepository

class WeaponRepositoryImpl(
    private val remoteDataSource: WeaponRemoteDataSource
) : WeaponRepository {

    private val mapper = WeaponToPresentationMapper()

    override suspend fun getListWeapon() = mapper.map(remoteDataSource.getWeapons())
}
