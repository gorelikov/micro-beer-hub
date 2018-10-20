package com.example.kofu.beer.api.controller

import com.example.kofu.beer.api.entity.Order
import com.example.kofu.beer.api.service.BarService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse

class UserHandler(
        private val service: BarService
) {

    fun makeOrder(request: ServerRequest) = ServerResponse
            .status(HttpStatus.CREATED)
            .contentType(MediaType.TEXT_PLAIN)
            .body(request.bodyToMono(Order::class.java)
                    .map { order -> service.makeOrder(order) },
                    String::class.java
            )

}