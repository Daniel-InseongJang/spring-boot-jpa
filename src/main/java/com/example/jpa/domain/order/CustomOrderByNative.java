package com.example.jpa.domain.order;

import lombok.*;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomOrderByNative {

    private long nativeId;

    private long nativeCustomerId;

    private int nativePrice;


    public CustomOrderByNative(BigInteger nativeId, BigInteger nativeCustomerId, Integer nativePrice) {
        this.nativeId = nativeId.longValue();
        this.nativeCustomerId = nativeCustomerId.longValue();
        this.nativePrice = nativePrice;
    }
}
