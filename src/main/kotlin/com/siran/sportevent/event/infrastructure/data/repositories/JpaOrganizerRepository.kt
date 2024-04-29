package com.siran.sportevent.event.infrastructure.data.repositories

import com.siran.sportevent.event.domain.entities.Organizer
import com.siran.sportevent.event.domain.repositories.OrganizerRepository
import com.siran.sportevent.event.infrastructure.data.models.OrganizerModel
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class JpaOrganizerRepository(
    val entityManager: EntityManager,
) : OrganizerRepository {
    @Transactional
    override fun save(organizer: Organizer) {
        val organizerModel = OrganizerModel(
            userId = organizer.userId.toString(),
            photoProfile = organizer.photoProfile?.value,
            id = organizer.id.toString()
        )
        entityManager.persist(organizerModel)
    }
}