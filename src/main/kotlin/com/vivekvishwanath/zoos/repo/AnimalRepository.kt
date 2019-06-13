package com.vivekvishwanath.zoos.repo

import com.vivekvishwanath.zoos.model.Animal
import org.springframework.data.repository.CrudRepository

interface AnimalRepository: CrudRepository<Animal, Long>