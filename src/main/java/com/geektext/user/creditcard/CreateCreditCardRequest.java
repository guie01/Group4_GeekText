package com.geektext.user.creditcard;

import java.math.BigInteger;
import java.util.Date;

public record CreateCreditCardRequest(Integer user_id, String card_number, Date expiration_date, String cvv) {
}
