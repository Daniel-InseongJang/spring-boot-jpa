package com.example.jpa.domain.order;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepositoryCustom {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<CustomOrderByQlrm> getOrdersByQlrm() {
        String query;
        query = "SELECT o.id as native_id, o.customer_id as native_customer_id, o.price as native_price FROM orders o;";

        final Query nativeQuery = entityManager.createNativeQuery(query);
        JpaResultMapper jpaResultMapper = new JpaResultMapper();
        return jpaResultMapper.list(nativeQuery, CustomOrderByQlrm.class);
//        final List<CustomOrderByNative> orders = nativeQuery.getResultList();
//        return orders;
    }
}
