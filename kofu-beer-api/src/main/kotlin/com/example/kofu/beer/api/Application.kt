package com.example.kofu.beer.api

import com.example.kofu.beer.api.controller.UserHandler
import com.example.kofu.beer.api.controller.routes
import com.example.kofu.beer.api.service.BarService
import org.springframework.boot.kofu.application
import org.springframework.boot.kofu.web.jackson
import org.springframework.boot.kofu.web.server
import org.springframework.context.support.beans

val beans = beans {
    bean<UserHandler>()
    bean<BarService>()
}

val app = application {
    import(beans)
    server {
        port = 8084
        codecs {
            string()
            jackson()
        }
        import(::routes)
    }
}

fun main(args: Array<String>) = app.run()