package com.example.spark.beer.api;

import com.example.spark.beer.api.entity.Order;
import com.example.spark.beer.api.service.BarService;
import com.google.gson.Gson;
import org.eclipse.jetty.http.HttpStatus;

import static spark.Spark.post;

public class Application {
    private final static Gson gson = new Gson();
    private final static BarService barService = new BarService();
    public static void main(String[] args) {
        post("/beer", (req, res) -> {
            Order order = gson.fromJson(req.body(), Order.class);
            res.status(HttpStatus.CREATED_201);
            return barService.makeOrder(order);
        });
    }
}
