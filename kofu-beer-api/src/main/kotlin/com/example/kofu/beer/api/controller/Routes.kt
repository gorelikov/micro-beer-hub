package com.example.kofu.beer.api.controller

import org.springframework.web.reactive.function.server.router

fun routes(userHandler: UserHandler) = router {
    POST("/beer", userHandler::makeOrder)
}