package com.nroncari.valorapp.data.model

data class BaseModel<T>(
    val status: Int,
    val data: T
)
