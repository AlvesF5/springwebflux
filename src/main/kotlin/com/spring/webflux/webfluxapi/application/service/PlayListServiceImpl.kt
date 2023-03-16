package com.spring.webflux.webfluxapi.application.service

import com.spring.webflux.webfluxapi.adapter.output.mongodb.port.PlayListRepository
import com.spring.webflux.webfluxapi.application.domain.PlayList
import com.spring.webflux.webfluxapi.application.port.PlayListService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class PlayListServiceImpl(
    private val playListRepository: PlayListRepository
) : PlayListService {
    override fun findAll(): Flux<PlayList> {
        return playListRepository.findAll()
    }

    override fun findById(id: String): Mono<PlayList> {
        return playListRepository.findById(id)
    }

    override fun save(playList: PlayList): Mono<PlayList> {
        return playListRepository.save(playList)
    }
}