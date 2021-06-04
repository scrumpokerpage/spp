package com.scrumpokerpage.spp.domain.user

import com.scrumpokerpage.spp.domain.vote.Card
import javax.persistence.*

/**
 * Punkteschema
 */
@Entity
data class DeckCover(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    val id: Int,

    @Column
    val name: String,

    @OneToOne
    @JoinColumn(name="creator_id")
    val creator: User,

    @Column
    val shared: Boolean,

    @OneToMany
    @JoinTable(name = "deck_card_covers",
        inverseJoinColumns = [ JoinColumn(name = "card_cover_id")]
    )
    @MapKeyJoinColumn(name = "card_id")
    val cards: Map<Card,CardCover>,

)
