package com.scrumpokerpage.spp.domain.user

import javax.persistence.*

@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    val id: Int,

    @Column
    val name: String,

    @Column
    val email: String,

    @Embedded
    val userSettings: UserSettings,

)

@Embeddable
data class UserSettings(

    @OneToOne
    val theme: Theme,

    @ManyToOne
    val cover: DeckCover,

)