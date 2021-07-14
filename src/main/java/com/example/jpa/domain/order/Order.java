package com.example.jpa.domain.order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long customerId;

    @Column(nullable = false)
    private int price;

    @CreationTimestamp
    @Setter(AccessLevel.PRIVATE)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Setter(AccessLevel.PRIVATE)
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Order(long customerId, int price) {
        this.customerId = customerId;
        this.price = price;
    }


}
