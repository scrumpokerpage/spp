package com.scrumpokerpage.spp.domain.vote

import javax.persistence.*

/**
 * Punkteschema
 */
@Entity
data class Deck(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    val id: Int,

    @Column
    val name: String,

    @OneToMany(mappedBy = "deck")
    @OrderColumn(name = "rank")
    val cards: List<Card>,

)
