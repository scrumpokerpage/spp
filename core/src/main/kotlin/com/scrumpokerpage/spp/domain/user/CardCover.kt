package com.scrumpokerpage.spp.domain.user

import com.scrumpokerpage.spp.domain.vote.Card
import javax.persistence.*

/**
 * Punkteschema
 */
@Entity
data class CardCover(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    val id: Int,

    @OneToOne
    val card: Card,

    @Column
    val image: String,

)
