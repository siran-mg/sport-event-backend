package com.siran.sportevent.event.domain.repositories

import com.siran.sportevent.event.domain.entities.Organizer

interface OrganizerRepository {
    fun save(organizer: Organizer)
}