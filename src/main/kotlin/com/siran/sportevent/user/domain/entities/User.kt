package com.siran.sportevent.user.domain.entities

import com.siran.sportevent.common.domain.valueobjects.Email
import com.siran.sportevent.user.domain.valueobjects.Password
import java.util.*

data class User(
    val id: UUID,
    val email: Email,
    val password: Password,
    val role: Role,
    val photoUrl: String = "",
)