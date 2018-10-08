package com.example.kofu.beer.api.service

import com.example.kofu.beer.api.entity.Order
import org.slf4j.LoggerFactory
import java.util.*

class BarService {
    val Log = LoggerFactory.getLogger(BarService::class.java.name)
    fun makeOrder(order: Order): String {
        Log.debug("Order {} accepted", order)
        return UUID.randomUUID().toString()
    }
}