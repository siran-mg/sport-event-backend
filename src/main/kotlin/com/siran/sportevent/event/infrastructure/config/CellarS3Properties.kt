package com.siran.sportevent.event.infrastructure.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("cellar")
class CellarS3Properties(
    val keyId: String,
    val keySecret: String,
    val host: String,
    val bucket: String,
    val region: String,
)