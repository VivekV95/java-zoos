package com.vivekvishwanath.zoos.repo

import com.vivekvishwanath.zoos.model.Telephone
import org.springframework.data.repository.CrudRepository

interface TelephoneRepository: CrudRepository<Telephone, Long>
