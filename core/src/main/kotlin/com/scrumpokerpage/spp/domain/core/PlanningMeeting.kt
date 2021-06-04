package com.scrumpokerpage.spp.domain.core

import com.scrumpokerpage.spp.domain.vote.Deck
import java.util.*
import javax.persistence.*

@Entity
data class PlanningMeeting(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    val id: Int,

    @Column
    val name: String,

    @Column
    val date: Calendar,

    @Embedded
    val settings: VotingSettings,

    @ManyToMany
    @JoinTable(
        name = "meeting_items",
        joinColumns = [JoinColumn(name = "meeting_id")],
        inverseJoinColumns = [JoinColumn(name = "item_id")]
    )
    @OrderColumn(name = "rank")
    val items: List<Item>,

    @OneToMany
    @JoinTable(
        name = "meeting_rounds",
        joinColumns = [JoinColumn(name = "meeting_id")],
        inverseJoinColumns = [JoinColumn(name = "round_id")]
    )
    val votingRounds: List<VotingRound>,

)

@Embeddable
data class VotingSettings(

    @OneToOne
    val deck: Deck,

    @Column
    val allowNoVote: Boolean,

    @Column
    val allowCovers: Boolean,

)