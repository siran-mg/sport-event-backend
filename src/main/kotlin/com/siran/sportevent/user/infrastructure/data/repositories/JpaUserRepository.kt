package com.siran.sportevent.user.infrastructure.data.repositories

import com.siran.sportevent.common.domain.valueobjects.Email
import com.siran.sportevent.user.domain.entities.Role
import com.siran.sportevent.user.domain.entities.User
import com.siran.sportevent.user.domain.repositories.UserRepository
import com.siran.sportevent.user.domain.valueobjects.Password
import com.siran.sportevent.user.infrastructure.data.entities.UserModel
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class JpaUserRepository(
    val entityManager: EntityManager,
    val passwordEncoder: PasswordEncoder,
) : UserRepository {

    @Transactional
    override fun createUser(email: String, password: String) {
        val user = User(
            email = Email(email),
            password = Password(password),
            role = Role.USER,
            id = UUID.randomUUID()
        )
        entityManager.persist(
            UserModel(
                id = user.id.toString(),
                email = user.email.value,
                password = passwordEncoder.encode(user.password.value),
                role = user.role.name
            )
        )
    }

    @Transactional
    override fun getUserByEmail(email: String): User? {
        val user = entityManager.createNamedQuery("findUserByEmail", UserModel::class.java)
            .setParameter("email", email)
            .singleResult
        return user?.let {
            return User(
                email = Email(it.email),
                password = Password(it.password),
                role = Role.valueOf(it.role),
                id = UUID.fromString(it.id)
            )
        }
    }
}