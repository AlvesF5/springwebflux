package com.spring.webflux.webfluxapi.adapter.input.web.controller

import com.spring.webflux.webfluxapi.adapter.input.web.api.PlayListApi
import com.spring.webflux.webfluxapi.application.domain.PlayList
import com.spring.webflux.webfluxapi.application.port.PlayListService
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.util.function.Tuple2
import java.time.Duration

@RestController
class PlayListController(
    private val playListService: PlayListService
    ) : PlayListApi {

    override fun getAllPlaylist(): Flux<PlayList> {
        return playListService.findAll()
    }

    override fun getById(id: String): Mono<PlayList> {
        return playListService.findById(id)
    }

    override fun save(playList: PlayList): Mono<PlayList> {
        return playListService.save(playList)
    }

    override fun getPlayListsByEvents(): Flux<Tuple2<Long, PlayList>> {
        val interval = Flux.interval(Duration.ofSeconds(1))
        val events: Flux<PlayList> = playListService.findAll()
        println("Passou aqui events!")
        return Flux.zip(interval,events)
    }
}