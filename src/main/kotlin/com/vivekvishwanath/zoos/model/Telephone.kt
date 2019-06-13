package com.vivekvishwanath.zoos.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "telephones")
data class Telephone (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var phoneid: Long? = 0,

        var phonetype: String? = null,
        var phonenumber: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "zooid", nullable = false)
        @JsonIgnoreProperties("telephones")
        var zoo: Zoo? = null
)