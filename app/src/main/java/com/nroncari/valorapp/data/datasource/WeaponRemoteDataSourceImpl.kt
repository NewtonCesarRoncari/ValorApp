package com.nroncari.valorapp.data.datasource

import com.nroncari.valorapp.data.mapper.WeaponToDomainMapper
import com.nroncari.valorapp.data.service.WeaponService

class WeaponRemoteDataSourceImpl(
    private val service: WeaponService
) : WeaponRemoteDataSource {

    private val mapper = WeaponToDomainMapper()

    override suspend fun getWeapons() = mapper.map(service.getWeapons().data)
}
