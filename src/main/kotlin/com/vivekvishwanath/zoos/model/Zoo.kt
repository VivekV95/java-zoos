package com.vivekvishwanath.zoos.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "zoos")
data class Zoo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var zooid: Long? = 0,

        var zooname: String,

        @OneToMany(mappedBy = "zoo",
                cascade = [CascadeType.ALL],
                orphanRemoval = true,
                fetch = FetchType.LAZY)
        @JsonIgnoreProperties("zoo")
        var telephones: MutableList<Telephone> = mutableListOf(),

        @ManyToMany(cascade = [CascadeType.MERGE])
        @JoinTable(name = "zooanimals",
                joinColumns = [JoinColumn(name = "zooid")],
                inverseJoinColumns = [JoinColumn(name = "animalid")])
        @JsonIgnoreProperties("zoos")
        var animals: MutableList<Animal> = mutableListOf()
)
