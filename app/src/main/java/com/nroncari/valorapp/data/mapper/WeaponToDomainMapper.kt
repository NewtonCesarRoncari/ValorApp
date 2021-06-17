package com.nroncari.valorapp.data.mapper

import com.nroncari.valorapp.data.model.WeaponResponse
import com.nroncari.valorapp.domain.model.WeaponDomain
import com.nroncari.valorapp.domain.model.WeaponSkinDomain
import com.nroncari.valorapp.utils.Mapper

class WeaponToDomainMapper : Mapper<List<WeaponResponse>, List<WeaponDomain>> {

    override fun map(source: List<WeaponResponse>): List<WeaponDomain> {
        return source.map { weaponResponse ->
            WeaponDomain(
                weaponResponse.uuid,
                weaponResponse.displayName,
                weaponResponse.category,
                weaponResponse.defaultSkinUuid,
                weaponResponse.displayIcon,
                weaponResponse.assetPath,
                weaponResponse.skins.map { weaponSkinResponse ->
                    WeaponSkinDomain(
                        weaponSkinResponse.uuid,
                        weaponSkinResponse.displayName,
                        weaponSkinResponse.themeUuid,
                        weaponSkinResponse.displayIcon ?: "",
                        weaponSkinResponse.assetPath
                    )
                }
            )
        }
    }
}
