package com.example.jpa.domain.order;

import com.example.jpa.config.web.PagedResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public List<Order> getOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    public List<CustomOrderByQlrm> getOrdersByQlrm(){
        List<CustomOrderByQlrm> orders = orderRepository.getOrdersByQlrm();
        return orders;
    }

    public List<Order> addAll(List<Order> insertOrderList) {
        if(insertOrderList.isEmpty()){
            new Exception("insert list is empty");
        }
        return orderRepository.saveAll(insertOrderList);
    }

    public Page<Order> getOrdersByPaged(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Slice<Order> getOrdersBySliced(Pageable pageable) {
        return orderRepository.findBy(pageable);
    }
}
