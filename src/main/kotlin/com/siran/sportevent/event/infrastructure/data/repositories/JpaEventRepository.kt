package com.siran.sportevent.event.infrastructure.data.repositories

import com.siran.sportevent.event.domain.entities.Event
import com.siran.sportevent.event.domain.repositories.EventRepository
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class JpaEventRepository(
    entityManager: EntityManager
): EventRepository {

    override suspend fun save(event: Event) {

    }

}