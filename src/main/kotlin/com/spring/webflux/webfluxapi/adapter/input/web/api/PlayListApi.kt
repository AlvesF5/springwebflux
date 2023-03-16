package com.spring.webflux.webfluxapi.adapter.input.web.api

import com.spring.webflux.webfluxapi.application.domain.PlayList
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.util.function.Tuple2

@RequestMapping("/playlist", produces = [MediaType.APPLICATION_JSON_VALUE])
interface PlayListApi {

    @GetMapping("/all")
    fun getAllPlaylist() : Flux<PlayList>

    @GetMapping("/{id}")
    fun getById(@PathVariable id : String) : Mono<PlayList>

    @PostMapping
    fun save(@RequestBody playList: PlayList) : Mono<PlayList>

    @GetMapping("/events", produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    fun getPlayListsByEvents() : Flux<Tuple2<Long,PlayList>>
}