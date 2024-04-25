package com.siran.sportevent.common.domain.valueobjects

import com.siran.sportevent.event.domain.valueobjects.EventAction
import java.time.LocalDate

data class PublishedAction(
    val eventAction: EventAction,
    val publishedAt: LocalDate,
    val data: Any? = null,
)