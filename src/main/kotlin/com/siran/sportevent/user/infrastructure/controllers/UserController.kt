package com.siran.sportevent.user.infrastructure.controllers

import com.siran.sportevent.user.domain.usecases.commands.CreateUserRequest
import com.siran.sportevent.user.domain.usecases.commands.ICreateUser
import com.siran.sportevent.user.domain.usecases.commands.IGetUserByEmail
import org.springframework.web.bind.annotation.*

data class GetUserByEmailResponse(
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
    suspend fun createUser(@RequestBody createUserRequest: CreateUserRequest) = createUser.execute(createUserRequest)

    @GetMapping("/{email}")
    suspend fun getUserByEmail(@PathVariable email: String): GetUserByEmailResponse? =
        getUserByEmail.execute(email)?.let {
            return GetUserByEmailResponse(
                email = it.email.value,
                userName = it.email.value,
                photoUrl = it.photoUrl
            )
        }
}