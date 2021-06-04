package com.scrumpokerpage.spp.domain.core

import com.scrumpokerpage.spp.domain.vote.Card
import java.util.*
import javax.persistence.*

/**
 * (finale) Schätzung
 */
@Entity
data class Estimate(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    val id: Int,

    @Column
    val date: Calendar,

    @OneToOne
    @JoinColumn(name = "card_id")
    val points: Card,

    @OneToOne
    val meeting: PlanningMeeting,

)
