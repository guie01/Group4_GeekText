package com.geektext.user;


import java.util.List;
public interface CreditCardDAO {

    void createCreditCard(CreditCard creditCard);
    List<CreditCard> findAllCreditCards();

}
