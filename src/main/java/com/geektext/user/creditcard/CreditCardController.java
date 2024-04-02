package com.geektext.user.creditcard;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping( "api/group4/users/credit_card")

public class CreditCardController {
   private final CreditCardService creditCardService;
    @PostMapping("/{username}")
    public void createCreditCard(@PathVariable("username") String username, @RequestBody CreateCreditCardRequest createCreditCardRequest){
        creditCardService.createCreditCard(username, createCreditCardRequest);
    };
}
