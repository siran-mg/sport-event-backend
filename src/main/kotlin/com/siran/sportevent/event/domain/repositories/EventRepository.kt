package com.siran.sportevent.event.domain.repositories

import com.siran.sportevent.event.domain.entities.Event

interface EventRepository {
    suspend fun save(event: Event)
}