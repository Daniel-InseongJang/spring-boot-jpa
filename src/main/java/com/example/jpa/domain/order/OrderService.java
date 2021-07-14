package com.example.jpa.domain.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public List<Order> orders(){
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    public List<Order> addAll(List<Order> insertOrderList) {
        if(insertOrderList.isEmpty()){
            new Exception("insert list is empty");
        }
        return orderRepository.saveAll(insertOrderList);
    }
}
