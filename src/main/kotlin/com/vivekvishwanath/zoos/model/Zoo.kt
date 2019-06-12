package com.vivekvishwanath.zoos.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "zoos")
data class Zoo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var zooid: Long,

        var zooname: String,

        @OneToMany(mappedBy = "zoo",
                cascade = [CascadeType.ALL],
                orphanRemoval = true,
                fetch = FetchType.LAZY)
        @JsonIgnoreProperties("zoo")
        var telephones: MutableList<Telephone> = mutableListOf(),

        @ManyToMany(mappedBy = "zoos")
        var animals: MutableList<Animal> = mutableListOf()
)
