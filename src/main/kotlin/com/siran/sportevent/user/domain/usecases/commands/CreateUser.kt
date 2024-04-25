package com.siran.sportevent.user.domain.usecases.commands

import com.siran.sportevent.user.domain.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class CreateUser(
    val userRepository: UserRepository
): ICreateUser {
    override suspend fun execute(input: CreateUserRequest) = userRepository.createUser(input.email, input.password)
}