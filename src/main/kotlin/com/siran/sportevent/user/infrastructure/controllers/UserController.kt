package com.siran.sportevent.user.infrastructure.controllers

import com.siran.sportevent.user.domain.exceptions.UserAlreadyExistsException
import com.siran.sportevent.user.domain.usecases.commands.CreateUserRequest
import com.siran.sportevent.user.domain.usecases.commands.ICreateUser
import com.siran.sportevent.user.domain.usecases.commands.IGetUserByEmail
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

data class GetUserByEmailResponse(
    val id: String,
    val userName: String,
    val email: String,
    val photoUrl: String,
)

@RestController
@RequestMapping("/user")
class UserController(
    val createUser: ICreateUser,
    val getUserByEmail: IGetUserByEmail,
) {

    @PostMapping
    suspend fun createUser(@RequestBody createUserRequest: CreateUserRequest) {
        try {
            return createUser.execute(createUserRequest)
        } catch (e: Exception) {
            println(e.printStackTrace())
            if (e is UserAlreadyExistsException) {
                throw ResponseStatusException(HttpStatus.CONFLICT, e.message)
            }
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.message)
        }
    }

    @GetMapping("/{email}")
    suspend fun getUserByEmail(@PathVariable email: String): GetUserByEmailResponse? =
        getUserByEmail.execute(email)?.let {
            return GetUserByEmailResponse(
                email = it.email.value,
                userName = it.email.value,
                photoUrl = it.photoUrl,
                id = it.id.toString()
            )
        }
}