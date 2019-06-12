package com.vivekvishwanath.zoos.service

import com.vivekvishwanath.zoos.model.Zoo

interface ZooService {
    fun findAll(): MutableList<Zoo>

    fun addZoo(zoo: Zoo): Zoo

    fun updateZoo(zoo: Zoo, zooid: Long): Zoo

    fun deleteZoo(zooid: Long)
}