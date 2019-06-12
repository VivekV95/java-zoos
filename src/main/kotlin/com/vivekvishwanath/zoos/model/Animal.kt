package com.vivekvishwanath.zoos.model

import javax.persistence.*

@Entity
@Table(name = "animals")
data class Animal(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var animalid: Long,

        var animaltype: String,

        @ManyToMany(mappedBy = "animals")
        var zoos: MutableList<Zoo> = mutableListOf()
)