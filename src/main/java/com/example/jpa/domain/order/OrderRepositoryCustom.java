package com.example.jpa.domain.order;

import java.util.List;

public interface OrderRepositoryCustom {
    List<CustomOrderByQlrm> getOrdersByQlrm();
}
