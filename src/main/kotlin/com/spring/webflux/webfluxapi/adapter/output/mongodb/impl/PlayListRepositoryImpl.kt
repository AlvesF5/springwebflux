package com.spring.webflux.webfluxapi.adapter.output.mongodb.impl

import com.spring.webflux.webfluxapi.adapter.output.mongodb.MongoRepository
import com.spring.webflux.webfluxapi.adapter.output.mongodb.port.PlayListRepository
import com.spring.webflux.webfluxapi.application.domain.PlayList
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class PlayListRepositoryImpl(
    private val mongoRepository : MongoRepository
) : PlayListRepository {

    override fun save(playList: PlayList): Mono<PlayList> {
        return mongoRepository.save(playList)
    }

    override fun findById(id: String): Mono<PlayList> {
        return mongoRepository.findById(id)
    }

    override fun findAll(): Flux<PlayList> {
        return mongoRepository.findAll()
    }
}