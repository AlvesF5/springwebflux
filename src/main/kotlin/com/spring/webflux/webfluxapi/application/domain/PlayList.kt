package com.spring.webflux.webfluxapi.application.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class PlayList(
    @Id
    val id: String?,
    val name : String
)
