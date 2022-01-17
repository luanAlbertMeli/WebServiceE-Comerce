package com.example.curso.entities.enums;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPING(3),
    DELIVERED(4),
    CANCELLED(5);

    private int code;

    public static OrderStatus valueOf(int code) {
        for (OrderStatus status : OrderStatus.values()) {
            if(status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Ivalid order status code");
    }

}
