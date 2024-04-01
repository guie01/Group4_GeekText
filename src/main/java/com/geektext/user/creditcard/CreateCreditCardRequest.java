package com.geektext.user;

import java.math.BigInteger;
import java.util.Date;

public record CreateCreditCardRequest(BigInteger card_number, Date expiration_date, Integer cvv) {
}
