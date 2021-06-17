package com.nroncari.valorapp.data.service

import com.nroncari.valorapp.data.model.BaseModel
import com.nroncari.valorapp.data.model.WeaponResponse
import retrofit2.http.GET

interface WeaponService {

    @GET("weapons?language=pt-BR")
    suspend fun getWeapons(): BaseModel<List<WeaponResponse>>
}
