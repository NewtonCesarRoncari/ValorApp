package com.nroncari.valorapp.utils

interface Mapper<S, T> {
    fun map(source: S): T
}
