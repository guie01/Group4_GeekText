package com.geektext.user;


import com.geektext.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
@AllArgsConstructor
public class CreditCardDataJPA implements CreditCardDAO{

    private final CreditCardRepository creditCardRepository;
    @Override
    public List<CreditCard> findAllCreditCards(){
        return creditCardRepository.findAll();
    }

    @Override
    public void createCreditCard(CreditCard creditCard){ creditCardRepository.save(creditCard);}

}
