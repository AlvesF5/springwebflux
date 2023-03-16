package com.spring.webflux.webfluxapi.adapter.output.mongodb

import com.spring.webflux.webfluxapi.application.domain.PlayList
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface MongoRepository : ReactiveMongoRepository<PlayList, String>