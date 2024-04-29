package com.siran.sportevent.event.domain.usecases.commands

import com.siran.sportevent.event.domain.entities.Organizer
import com.siran.sportevent.event.domain.repositories.OrganizerRepository
import com.siran.sportevent.event.domain.valueobjects.PhotoProfile
import java.util.*

class CreateOrganizer(
    private val organizerRepository: OrganizerRepository,
) : ICreateOrganizer {
    override fun execute(input: CreateOrganizerRequest) {
        val organizer = Organizer(
            userId = UUID.fromString(input.userId),
            photoProfile = PhotoProfile(
                value = input.photoProfile
            )
        )
        organizerRepository.save(organizer)
    }
}