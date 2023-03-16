package com.spring.webflux.webfluxapi.application.configuration

import com.spring.webflux.webfluxapi.adapter.input.web.handler.PlayListHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

//@Configuration
class PlayListRouter {

    @Bean
    fun route(playListHandler: PlayListHandler): RouterFunction<ServerResponse>{
        return RouterFunctions
            .route(GET("/playlist/all").and(accept(MediaType.APPLICATION_JSON)),playListHandler::findAll)
            .andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)),playListHandler::findById)
            .andRoute(POST("/playlist").and(accept(MediaType.APPLICATION_JSON)),playListHandler::save)
    }
}