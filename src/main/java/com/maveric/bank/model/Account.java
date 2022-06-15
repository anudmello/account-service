package com.maveric.bank.model;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    String type;
    int customerId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public Account(String type, int customerId) {
        this.type = type;
        this.customerId = customerId;
    }
}
