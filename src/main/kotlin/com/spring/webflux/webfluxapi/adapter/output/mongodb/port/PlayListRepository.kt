package com.spring.webflux.webfluxapi.adapter.output.mongodb.port

import com.spring.webflux.webfluxapi.application.domain.PlayList
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface PlayListRepository {

    fun save(playList: PlayList): Mono<PlayList>

    fun findById(id: String): Mono<PlayList>

    fun findAll(): Flux<PlayList>
}