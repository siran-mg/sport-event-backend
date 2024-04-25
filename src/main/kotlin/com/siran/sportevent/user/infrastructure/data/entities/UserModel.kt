package com.siran.sportevent.user.infrastructure.data.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.NamedQuery

@Entity(name = "users")
@NamedQuery(name = "findUserByEmail", query = "SELECT u FROM users u WHERE u.email = :email")
class UserModel(
    @Id val id: String,
    val email: String,
    val password: String,
    val role: String
)