package com.siran.sportevent.event.domain.valueobjects

class EventDescription(val value: String) {
    init {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Event description cannot be empty")
        }
    }
}