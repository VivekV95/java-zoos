package com.vivekvishwanath.zoos.service

import com.vivekvishwanath.zoos.model.Zoo
import com.vivekvishwanath.zoos.repo.ZooRepository
import com.vivekvishwanath.zoos.view.CountZoosForAnimals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service(value = "zooService")
class ZooServiceImpl : ZooService {

    @Autowired
    private lateinit var zooRepository: ZooRepository

    override fun findAll(): MutableList<Zoo> {
        val zooList = mutableListOf<Zoo>()
        zooRepository.findAll().iterator().forEachRemaining { zooList.add(it) }
        return zooList
    }

    override fun getCountZoosForAnimals(): MutableList<CountZoosForAnimals> {
        return zooRepository.getCountZoosForAnimals()
    }


    @Transactional
    override fun addZoo(zoo: Zoo): Zoo {
        val newZoo = zoo.copy()
        for (telephone in newZoo.telephones) {
            telephone.zoo = newZoo
        }
        return zooRepository.save(newZoo)
    }

    @Transactional
    override fun updateZoo(zoo: Zoo, zooid: Long): Zoo {
        val currentZoo = zooRepository.findById(zooid).orElseThrow { EntityNotFoundException(zooid.toString()) }
        currentZoo.zooname = zoo.zooname
        for (telephone in zoo.telephones) {
            telephone.zoo = currentZoo
            currentZoo.telephones.add(telephone)
        }
        for (animal in zoo.animals) {
            animal.zoos.add(currentZoo)
            currentZoo.animals.add(animal)
        }
        return zooRepository.save(currentZoo)
    }

    @Transactional
    override fun deleteZoo(zooid: Long) {
        if (zooRepository.findById(zooid).isPresent) {
            zooRepository.deleteById(zooid)
        }
    }

    override fun findZooById(zooid: Long): Zoo {
        return zooRepository.findById(zooid).orElseThrow { EntityNotFoundException(zooid.toString()) }
    }

    @Transactional
    override fun deleteZooAnimalIds(zooid: Long, animalid: Long) {
        zooRepository.deleteZooAnimalIds(zooid, animalid)
    }
}