package com.vivekvishwanath.zoos.repo

import com.vivekvishwanath.zoos.model.Zoo
import org.springframework.data.repository.CrudRepository

interface ZooRepository: CrudRepository<Zoo, Long> {}