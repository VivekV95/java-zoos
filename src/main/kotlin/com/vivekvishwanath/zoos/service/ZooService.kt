package com.vivekvishwanath.zoos.service

import com.vivekvishwanath.zoos.model.Zoo
import com.vivekvishwanath.zoos.view.CountZoosForAnimals

interface ZooService {
    fun findAll(): MutableList<Zoo>

    fun addZoo(zoo: Zoo): Zoo

    fun updateZoo(zoo: Zoo, zooid: Long): Zoo

    fun deleteZoo(zooid: Long)

    fun getCountZoosForAnimals(): MutableList<CountZoosForAnimals>

    fun findZooById(zooid: Long): Zoo

    fun deleteZooAnimalIds(zooid: Long, animalid: Long)
}