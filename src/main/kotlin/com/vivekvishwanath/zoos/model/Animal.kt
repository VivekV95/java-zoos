package com.vivekvishwanath.zoos.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "animals")
data class Animal(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var animalid: Long? = 0,

        var animaltype: String,

        @ManyToMany(mappedBy = "animals")
        var zoos: MutableList<Zoo> = mutableListOf()
)