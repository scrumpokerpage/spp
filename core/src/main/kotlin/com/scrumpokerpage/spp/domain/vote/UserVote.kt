package com.scrumpokerpage.spp.domain.vote

import com.scrumpokerpage.spp.domain.core.VotingRound
import com.scrumpokerpage.spp.domain.user.User
import java.util.*
import javax.persistence.*

/**
 * Stimme
 */
@Entity
data class UserVote(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    val id: Int,

    @OneToOne
    val user: User,

    @Column
    val date: Calendar,

    @OneToOne
    @JoinColumn(name = "card_id")
    val points: Card,

    @ManyToOne
    val round: VotingRound,

)
