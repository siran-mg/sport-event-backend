package com.siran.sportevent.event.infrastructure.config

import com.siran.sportevent.common.domain.repositories.ActionPublisher
import com.siran.sportevent.event.domain.repositories.EventRepository
import com.siran.sportevent.event.domain.repositories.FileRepository
import com.siran.sportevent.event.domain.repositories.OrganizerRepository
import com.siran.sportevent.event.domain.usecases.commands.CreateEvent
import com.siran.sportevent.event.domain.usecases.commands.CreateOrganizer
import com.siran.sportevent.event.domain.usecases.commands.UploadOrganizerProfilePhoto
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfig(
    val organizerRepository: OrganizerRepository,
    val eventRepository: EventRepository,
    val actionPublisher: ActionPublisher,
    val fileRepository: FileRepository,
) {
    @Bean
    internal fun createOrganizer() = CreateOrganizer(organizerRepository)

    @Bean
    internal fun createEvent() = CreateEvent(
        actionPublisher = actionPublisher,
        eventRepository = eventRepository
    )

    @Bean
    internal fun uploadOrganizerProfilePhoto() = UploadOrganizerProfilePhoto(fileRepository)
}