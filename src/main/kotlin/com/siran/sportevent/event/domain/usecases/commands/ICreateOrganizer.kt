package com.siran.sportevent.event.domain.usecases.commands

import com.siran.sportevent.common.domain.usecases.UseCase

data class CreateOrganizerRequest(
    val userId: String,
    val photoProfile: String,
    val name: String,
)

interface ICreateOrganizer : UseCase<CreateOrganizerRequest, Unit>