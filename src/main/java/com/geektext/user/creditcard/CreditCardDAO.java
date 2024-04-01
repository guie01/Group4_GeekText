package com.geektext.user.creditcard;


import java.util.List;
public interface CreditCardDAO {

    void createCreditCard(CreditCard creditCard);
    List<CreditCard> findAllCreditCards();

}
