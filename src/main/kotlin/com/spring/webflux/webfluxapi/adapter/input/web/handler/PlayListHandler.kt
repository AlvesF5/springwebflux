package com.spring.webflux.webfluxapi.adapter.input.web.handler

import com.spring.webflux.webfluxapi.application.domain.PlayList
import com.spring.webflux.webfluxapi.application.port.PlayListService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromPublisher
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

//@Component
class PlayListHandler(
    private val playListService: PlayListService
) {
    fun findAll(request: ServerRequest) : Mono<ServerResponse>{
        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(playListService.findAll(),PlayList::class.java)
    }

    fun findById(request: ServerRequest) : Mono<ServerResponse>{
        val id = request.pathVariable("id")
        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(playListService.findById(id),PlayList::class.java)
    }

    fun save(request: ServerRequest): Mono<ServerResponse>{
        val playList: Mono<PlayList> = request.bodyToMono(PlayList::class.java)
        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromPublisher(playList.flatMap(playListService::save),PlayList::class.java))
    }
}