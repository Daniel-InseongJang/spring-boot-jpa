package com.example.jpa.domain.order;

import com.example.jpa.config.web.CursorBasedResponse;
import com.example.jpa.config.web.OneBasedPageRequest;
import com.example.jpa.config.web.PagedResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Slice;
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

    @ApiOperation("주문 리스트 조회(List)")
    @GetMapping("jpa")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @ApiOperation("주문 리스트 조회(Qlrm)")
    @GetMapping("qlrm")
    public List<CustomOrderByQlrm> getOrdersByQlrm() {
        return orderService.getOrdersByQlrm();
    }

    @ApiOperation("주문 리스트 조회(Paged)")
    @GetMapping("paged")
    public PagedResponse<Order> getOrdersByPaged(OneBasedPageRequest pageRequest) {
        return new PagedResponse(orderService.getOrdersByPaged(pageRequest.toZeroBasedPageable()));
    }

    @ApiOperation("주문 리스트 조회(Sliced)")
    @GetMapping("sliced")
    public Slice<Order> getOrdersBySliced(OneBasedPageRequest pageRequest) {
        return orderService.getOrdersBySliced(pageRequest.toZeroBasedPageable());
    }

    @ApiOperation("주문 리스트 조회(Paged convert Cursored)")
    @GetMapping("cursored")
    public CursorBasedResponse<Order, String> getOrdersByCursored(OneBasedPageRequest pageRequest) {
        return CursorBasedResponse.ofPage(orderService.getOrdersByPaged(pageRequest.toZeroBasedPageable()));
    }
}
