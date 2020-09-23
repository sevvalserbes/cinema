package com.ss.cinema.domain.mapper

interface Mapper<R, M>{
    fun mapFrom(response: R) : M
}