package com.geektext.user;

import com.geektext.exceptions.ResourceNotFoundException;

import java.util.List;

public class CreditCardService {

    private final CreditCardDAO creditCardDAO;


    public boolean existsCreditCard(CreditCard creditCard){
        List<CreditCard> creditCards = creditCardDAO.findAllCreditCards();
        List<CreditCard> list = creditCards.stream()
                .filter(target -> target.getCard_number().equals(creditCard.getCard_number()))
                .filter(target -> target.getExpiration_date().equals(creditCard.getExpiration_date()))
                .filter(target -> target.getCvv().equals(creditCard.getCvv()))
                .toList();
        return !list.isEmpty();
    }
}

public void createCreditCard(CreateCreditCardRequest request){
    if(!userService.existsUserWIthID(username)){

        CreditCard creditcard = CreditCard.builder()
                .card_number(request.card_number())
                .expiration_date(request.expiration_date())
                .cvv(request.cvv())
                .build();

        if (!existsUser(user)) creditCardDAO.createCreditCard(creditcard);
        else throw new ResourceNotFoundException("User [%s] was not found".formatted(user.getUsername()));

    }
}
}
