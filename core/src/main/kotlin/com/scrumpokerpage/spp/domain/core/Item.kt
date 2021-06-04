package com.scrumpokerpage.spp.domain.core

import javax.persistence.*

/**
 * Schätzgegenstand
 */
@Entity
data class Item(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    val id: Int,

    @Column
    val name: String,

    @Column(name = "ext_reference")
    val externalReference: String,

    @Enumerated(EnumType.STRING)
    val type: ItemType,

    @OneToMany
    @JoinColumn(name="item_id")
    val estimates: List<Estimate>,

) {
    enum class ItemType {
        ITEM, USERSTORY, TASK, BUG, INCIDENT
    }
}
