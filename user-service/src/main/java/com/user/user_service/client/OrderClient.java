package com.user.user_service.client;

import com.user.user_service.config.FeignConfig;
import com.user.user_service.model.Order;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "ORDER-SERVICE", configuration = FeignConfig.class) // Use LoadBalancer
public interface OrderClient {

    @GetMapping("/orders/user/{userId}")
    List<Order> getOrdersByUserId(@PathVariable Long userId);

   /*// @CircuitBreaker(name = "orderService", fallbackMethod = "fallbackGetOrdersByUserId")
    *  // Fallback method to return empty orders when service is down
    default List<Order> fallbackGetOrdersByUserId(Long userId, Throwable throwable) {
        System.out.println("Order Service is down, returning default empty list. Error: " + throwable.getMessage());
        return Collections.emptyList();
    }*/
}
