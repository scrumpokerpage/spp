package com.scrumpokerpage.spp.domain.user

import javax.persistence.*

/**
 * Punkteschema
 */
@Entity
data class Theme(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    val id: Int,

    @Column
    val name: String,

)
