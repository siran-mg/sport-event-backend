package com.siran.sportevent.event.domain.valueobjects

class OrganizerName(value: String) {
    init {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Organizer name cannot be empty")
        }
    }
}