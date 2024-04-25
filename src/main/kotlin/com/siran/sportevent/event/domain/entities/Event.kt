package com.siran.sportevent.event.domain.entities

import com.siran.sportevent.event.domain.valueobjects.EventDescription
import com.siran.sportevent.event.domain.valueobjects.EventName
import com.siran.sportevent.event.domain.valueobjects.EventStatus
import java.time.LocalDateTime
import java.util.*

data class Event(
    val id: UUID = UUID.randomUUID(),
    val organizerId: UUID,
    val name: EventName,
    val description: EventDescription,
    val sportId: UUID,
    var eventStatus: EventStatus? = EventStatus.OPENED,
    var startDate: LocalDateTime? = LocalDateTime.now(),
    var endDate: LocalDateTime? = null,
    var sponsors: ArrayList<Sponsor>? = arrayListOf(),
)