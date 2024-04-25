package com.siran.sportevent.event.infrastructure.data.models

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "organizers")
class OrganizerModel(
    @Id val id: String,
    val userId: String,
)