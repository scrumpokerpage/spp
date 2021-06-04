package com.scrumpokerpage.spp.domain.core

import com.scrumpokerpage.spp.domain.vote.UserVote
import java.util.*
import javax.persistence.*

/**
 * Schätzrunde/Wahlgang
 */
@Entity
data class VotingRound(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    val id: Int,

    @ManyToOne
    val item: Item,

    @Column
    val startDate: Calendar,

    @Column
    val endDate: Calendar,

    @Embedded
    val settings: VotingSettings,

    @ManyToOne
    val meeting: PlanningMeeting,

    @OneToMany(mappedBy = "round")
    @OrderBy("date ASC")
    val userVotes: List<UserVote>,

)
