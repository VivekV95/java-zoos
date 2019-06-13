package com.vivekvishwanath.zoos.controller

import com.vivekvishwanath.zoos.model.Zoo
import com.vivekvishwanath.zoos.service.ZooService
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

@RestController
@RequestMapping("/admin")
class AdminController {

    @Autowired
    private lateinit var zooService: ZooService

    @PutMapping (value = ["/zoos/{zooid}"],
            consumes = ["application/json"],
            produces = ["application/json"])
    fun updateZooById(request: HttpServletRequest, @Valid @RequestBody updateZoo: Zoo,
                      @PathVariable zooid: Long): ResponseEntity<Any> {
        val updateZoo = zooService.updateZoo(updateZoo, zooid)
        val responseHeaders = HttpHeaders()
        val newZooURI = ServletUriComponentsBuilder.fromUriString(request.serverName +
                ":" + request.localPort + "/zoos/zoo/{zooid}").buildAndExpand(updateZoo.zooid).toUri()
        responseHeaders.location = newZooURI
        return ResponseEntity(null, responseHeaders, HttpStatus.OK)
    }

    @PostMapping(value = ["/zoos"],
            consumes = ["application/json"],
            produces = ["application/json"])
    fun addNewZoo(request: HttpServletRequest,
                  @Valid @RequestBody zoo: Zoo): ResponseEntity<Any> {
        val newZoo = zooService.addZoo(zoo)

        val responseHeaders = HttpHeaders()
        val newZooURI = ServletUriComponentsBuilder.fromUriString(request.serverName +
        ":" + request.localPort + "/zoos/zoo/{zooid}").buildAndExpand(newZoo.zooid).toUri()
        responseHeaders.location = newZooURI
        return ResponseEntity(newZoo, responseHeaders, HttpStatus.OK)
    }

    @DeleteMapping(value = ["/zoos/{zooid}"])
    fun deleteZooById(@PathVariable zooid: Long): ResponseEntity<Any> {
        zooService.deleteZoo(zooid)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping(value = ["/zoos/{zooid}/animals/{animalid}"])
    fun deleteZooAnimalIds(@PathVariable zooid: Long,
                           @PathVariable animalid: Long): ResponseEntity<Any> {
        zooService.deleteZooAnimalIds(zooid, animalid)
        return ResponseEntity(HttpStatus.OK)
    }
}