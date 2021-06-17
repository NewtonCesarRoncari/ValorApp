package com.nroncari.valorapp.domain.mapper

import com.nroncari.valorapp.domain.model.WeaponDomain
import com.nroncari.valorapp.presentation.model.WeaponPresentation
import com.nroncari.valorapp.presentation.model.WeaponSkinPresentation
import com.nroncari.valorapp.utils.Mapper

class WeaponToPresentationMapper : Mapper<List<WeaponDomain>, List<WeaponPresentation>> {

    override fun map(source: List<WeaponDomain>): List<WeaponPresentation> {
        return source.map { weaponDomain ->
            WeaponPresentation(
                weaponDomain.uuid,
                weaponDomain.displayName,
                weaponDomain.category,
                weaponDomain.defaultSkinUuid,
                weaponDomain.displayIcon,
                weaponDomain.assetPath,
                weaponDomain.skins.map { weaponSkinDomain ->
                    WeaponSkinPresentation(
                        weaponSkinDomain.uuid,
                        weaponSkinDomain.displayName,
                        weaponSkinDomain.themeUuid,
                        weaponSkinDomain.displayIcon,
                        weaponSkinDomain.assetPath
                    )
                }
            )
        }
    }
}
