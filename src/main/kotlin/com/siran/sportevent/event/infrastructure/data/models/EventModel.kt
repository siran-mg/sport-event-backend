package com.siran.sportevent.event.infrastructure.data.models

import com.siran.sportevent.event.domain.entities.Sport
import com.siran.sportevent.event.domain.valueobjects.EventStatus
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import java.time.LocalDateTime

@Entity(name = "events")
class EventModel(
    @Id val id: String,
    val name: String,
    val description: String,
    @OneToMany
    val sports: List<SportModel>,
    @OneToOne
    val organizer: OrganizerModel,
    val eventStatus: EventStatus,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val createdAt: LocalDateTime,
    val modifiedAt: LocalDateTime
)