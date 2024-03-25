package com.geektext.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
@Builder
@Table(name = "credit_cards")
@Entity

public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer user_id;

    @Column(nullable = false)
    private BigInteger card_number;

    @Column(nullable = false)
    private Date expiration_date;

    @Column(nullable = false)
    private Integer cvv;


    public CreditCard(Integer id, Integer user_id, BigInteger card_number, Date expiration_date, Integer cvv) {
        this.id = id;
        this.user_id = user_id;
        this.card_number = card_number;
        this.expiration_date = expiration_date;
        this.cvv = cvv;
    }

    public CreditCard() {

    }

    public CreditCard(Integer user_id, BigInteger card_number, Date expiration_date, Integer cvv) {
        this.user_id = user_id;
        this.card_number = card_number;
        this.expiration_date = expiration_date;
        this.cvv = cvv;
    }
    public CreditCard(BigInteger card_number, Date expiration_date, Integer cvv) {
        this.card_number = card_number;
        this.expiration_date = expiration_date;
        this.cvv = cvv;
    }
}
