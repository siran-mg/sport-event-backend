package com.siran.sportevent.event.infrastructure.data.models

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "sports")
class SportModel(
    @Id val id: String,
    val name: String
)
