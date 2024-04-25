package com.siran.sportevent.event.domain.usecases.commands

import com.siran.sportevent.event.domain.repositories.EventRepository
import com.siran.sportevent.event.domain.valueobjects.EventAction
import com.siran.sportevent.event.domain.valueobjects.EventDescription
import com.siran.sportevent.event.domain.valueobjects.EventName
import com.siran.sportevent.common.domain.repositories.ActionPublisher
import com.siran.sportevent.event.domain.entities.Event
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreateEvent(
    private val eventRepository: EventRepository,
    private val actionPublisher: ActionPublisher
): ICreateEvent {
    override suspend fun execute(input: CreateEventRequest) {
        val event = Event(
            name = EventName(input.name),
            description = EventDescription(input.description),
            organizerId = UUID.fromString(input.userId),
            sportId = UUID.fromString(input.sportId),
        )
        eventRepository.save(event);
        actionPublisher.publish(EventAction.CREATE_EVENT_SUCCESS)
    }
}