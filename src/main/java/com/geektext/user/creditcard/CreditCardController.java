package com.geektext.user;

import com.geektext.user.creditcard.CreditCardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping( "api/group4/users/credit_card")

public class CreditCardController {
   private final CreditCardService creditCardService;
    @PostMapping
    public void createCreditCard(RequestBody CreateCreditCardRequest createCrediCardRequest){
        creditCardService.createCreditCard(createCreditCardRequest);
    };
}
