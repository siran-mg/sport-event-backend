package com.siran.sportevent.event.domain.usecases.commands

import com.siran.sportevent.common.domain.usecases.UseCase

data class CreateEventRequest(
    val userId: String,
    val name: String,
    val description: String,
    val sportId: String,
)

interface ICreateEvent: UseCase<CreateEventRequest, Unit>