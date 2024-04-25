package com.siran.sportevent.event.domain.usecases.commands

import com.siran.sportevent.common.domain.usecases.UseCase
import java.util.*

data class ParticipateToEventRequest(
    val user: UUID,
    val eventId: UUID,
)
interface IParticipateToEvent: UseCase<ParticipateToEventRequest, Unit>