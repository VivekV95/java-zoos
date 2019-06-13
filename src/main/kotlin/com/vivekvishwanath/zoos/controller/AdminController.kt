package com.vivekvishwanath.zoos.controller

import com.vivekvishwanath.zoos.model.Zoo
import com.vivekvishwanath.zoos.service.ZooService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/admin")
class AdminController {

    @Autowired
    private lateinit var zooService: ZooService

    @PutMapping (value = ["/zoos/{zooid}"],
            consumes = ["application/json"],
            produces = ["application/json"])
    fun updateZooById(@Valid @RequestBody updateZoo: Zoo,
                      @PathVariable zooid: Long): ResponseEntity<Any> {
        zooService.updateZoo(updateZoo, zooid)
        return ResponseEntity(HttpStatus.OK)
    }

    @PostMapping(value = ["/zoos"],
            consumes = ["application/json"],
            produces = ["application/json"])
    fun addNewZoo(@Valid @RequestBody zoo: Zoo): ResponseEntity<Any> {
        return ResponseEntity(zooService.addZoo(zoo), HttpStatus.OK)
    }
}