package com.example.jpa.config;

import com.example.jpa.domain.order.Order;
import com.example.jpa.domain.order.OrderService;
import com.example.jpa.domain.user.User;
import com.example.jpa.domain.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent cse) {
        logger.info("Data Checkn And Data Insert");
        dataCheckAndInsert();
    }

    @Transactional
    void dataCheckAndInsert() {
        List<User> users = userService.getUsers();
        if(users.isEmpty()){
            List<User> insertUesrList = createBasicDataByUser();
            List<Order> insertOrderList = new ArrayList<>();

            userService.addAll(insertUesrList).forEach(user -> {
                insertOrderList.add(new Order(user.getId(), user.getId().intValue() * 1000));
            });

            orderService.addAll(insertOrderList);
        }
    }

    private List<User> createBasicDataByUser() {
        final List<User> users = new ArrayList<>();
        users.add(new User("A-User"));
        users.add(new User("B-User"));
        users.add(new User("C-User"));
        users.add(new User("D-User"));
        users.add(new User("E-User"));
        users.add(new User("F-User"));
        users.add(new User("G-User"));
        return users;
    }
}