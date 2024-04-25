package com.siran.sportevent.event.infrastructure.controllers

import com.siran.sportevent.event.domain.usecases.commands.CreateEventRequest
import com.siran.sportevent.event.domain.usecases.commands.ICreateEvent
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController("api")
class EventController(
    private val createEvent: ICreateEvent
) {

    @PostMapping("/events")
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun createEvent(createEventRequest: CreateEventRequest) {
        return createEvent.execute(createEventRequest)
    }
}