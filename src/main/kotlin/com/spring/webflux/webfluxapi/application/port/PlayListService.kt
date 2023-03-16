package com.spring.webflux.webfluxapi.application.port

import com.spring.webflux.webfluxapi.application.domain.PlayList
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PlayListService {
    fun findAll() : Flux<PlayList>
    fun findById(id : String) : Mono<PlayList>
    fun save(playList: PlayList) : Mono<PlayList>
}