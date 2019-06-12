package com.vivekvishwanath.zoos.service

import com.vivekvishwanath.zoos.model.Zoo
import com.vivekvishwanath.zoos.repo.ZooRepository
import com.vivekvishwanath.zoos.view.CountZoosForAnimals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service(value = "zooService")
class ZooServiceImpl: ZooService {

    @Autowired
    private lateinit var zooRepository: ZooRepository

    override fun findAll(): MutableList<Zoo> {
        val zooList = mutableListOf<Zoo>()
        zooRepository.findAll().iterator().forEachRemaining{zooList.add(it)}
        return zooList
    }

    override fun getCountZoosForAnimals(): MutableList<CountZoosForAnimals> {
        return zooRepository.getCountZoosForAnimals()
    }


    override fun addZoo(zoo: Zoo): Zoo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateZoo(zoo: Zoo, zooid: Long): Zoo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteZoo(zooid: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}