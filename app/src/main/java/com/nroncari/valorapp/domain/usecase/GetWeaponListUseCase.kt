package com.nroncari.valorapp.domain.usecase

import com.nroncari.valorapp.domain.repository.WeaponRepository

class GetWeaponListUseCase(
    private val repository: WeaponRepository
) {

    suspend operator fun invoke() = repository.getListWeapon()
}
