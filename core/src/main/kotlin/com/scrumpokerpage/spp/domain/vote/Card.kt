package com.scrumpokerpage.spp.domain.vote

import javax.persistence.*

@Entity
data class Card(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    val id: Int,

    @Column
    val name: String,

    @ManyToOne
    val deck: Deck,

    @Column
    val value: Double,

    @Enumerated(EnumType.STRING)
    val special: SpecialCardValue,

)

enum class SpecialCardValue {
    UNCLEAR, BREAK, JOKER, CUSTOM
}
