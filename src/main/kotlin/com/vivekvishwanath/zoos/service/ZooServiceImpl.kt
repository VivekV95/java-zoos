package com.vivekvishwanath.zoos.service

import com.vivekvishwanath.zoos.model.Zoo
import com.vivekvishwanath.zoos.repo.ZooRepository
import com.vivekvishwanath.zoos.view.CountZoosForAnimals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

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

    @Transactional
    override fun updateZoo(zoo: Zoo, zooid: Long): Zoo {
        val currentZoo = zooRepository.findById(zooid).
                orElseThrow{EntityNotFoundException(zooid.toString())}
        currentZoo.zooname = zoo.zooname
        currentZoo.telephones.clear()
        for (telephone in zoo.telephones) {
            telephone.zoo = currentZoo
            currentZoo.telephones.add(telephone)
        }
        currentZoo.animals.clear()
        for (animal in zoo.animals) {
            currentZoo.animals.add(animal)
        }
        return zooRepository.save(currentZoo)
    }

    @Transactional
    override fun deleteZoo(zooid: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}