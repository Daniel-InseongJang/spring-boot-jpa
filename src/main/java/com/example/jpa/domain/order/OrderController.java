package com.example.jpa.domain.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Api(value = "주문", tags = {"Order 주문"})
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ApiOperation("주문 리스트 조회")
    @GetMapping("")
    public List<Order> getOrders() {
        return orderService.orders();
    }
}
