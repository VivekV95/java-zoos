package com.vivekvishwanath.zoos.repo

import com.vivekvishwanath.zoos.model.Zoo
import com.vivekvishwanath.zoos.view.CountZoosForAnimals
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ZooRepository: CrudRepository<Zoo, Long> {
    @Query(value = "SELECT z.animalid, a.animaltype, count(z.zooid) as countzoos FROM zooanimals z INNER JOIN animals a ON a.animalid = z.animalid GROUP BY z.animalid", nativeQuery = true)
    fun getCountZoosForAnimals(): MutableList<CountZoosForAnimals>

    @Modifying
    @Query(value = "DELETE FROM zooanimals WHERE zooid = :zooid AND animalid = :animalid", nativeQuery = true)
    fun deleteZooAnimalIds(zooid: Long, animalid: Long)
}