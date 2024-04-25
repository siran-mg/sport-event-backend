package com.siran.sportevent.user.domain.usecases.commands

import com.siran.sportevent.common.domain.usecases.UseCase

data class CreateUserRequest(
    val email: String,
    val password: String,
)

interface ICreateUser: UseCase<CreateUserRequest, Unit>