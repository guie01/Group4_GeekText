package com.geektext.user.creditcard;
import com.geektext.exceptions.ResourceNotFoundException;
import com.geektext.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CreditCardService {

    private final CreditCardDAO creditCardDAO;
    private final UserService userService;


    public boolean existsCreditCard(CreditCard creditCard){
        List<CreditCard> creditCards = creditCardDAO.findAllCreditCards();
        List<CreditCard> list = creditCards.stream()
                .filter(target -> target.getCard_number().equals(creditCard.getCard_number()))
                .filter(target -> target.getExpiration_date().equals(creditCard.getExpiration_date()))
                .filter(target -> target.getCvv().equals(creditCard.getCvv()))
                .toList();
        return !list.isEmpty();
    }

    public void createCreditCard(String username, CreateCreditCardRequest request){
            int userId = userService.getUserIdByUsername(username);

            CreditCard creditCard = CreditCard.builder()
                    .user_id(userId)
                    .card_number(request.card_number())
                    .expiration_date(request.expiration_date())
                    .cvv(request.cvv())
                    .build();


        if(userService.existsUserWithID(userId)) {
            creditCardDAO.createCreditCard(creditCard);
        }
            else {
                throw new ResourceNotFoundException("User with user id [%d] was not found".formatted(userId));
        }

    }
}
