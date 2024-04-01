package com.geektext.shopping_cart;

import com.geektext.book_details.book.Book;
import com.geektext.shopping_cart.ShoppingCartService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/group4/shopping-cart")
public class ShoppingCartController {


    private ShoppingCartService shoppingCartService;

    @GetMapping("{userId}")
    public BigDecimal getShoppingCartSubtotal(@PathVariable("userId") Integer userId) {
        BigDecimal subtotal = shoppingCartService.subTotalPrice(userId);
        return subtotal;
    }

    @PostMapping("{bookId}/{userId}")
    public void addToCart(@PathVariable("bookId")BigInteger bookId, @PathVariable("userId") Integer userId){
        shoppingCartService.addToCart(bookId,userId);
    }
    @GetMapping("books/{userId}")
    public List<Book> getBooksInCart(@PathVariable("userId") Integer userId) {
        return  shoppingCartService.getBooksInCart(userId);
    }
    @DeleteMapping("{bookId}/{userId}")
    public void deleteBookFromCart(@PathVariable("bookId")BigInteger bookId, @PathVariable("userId") Integer userId){
        shoppingCartService.deleteBookFromCart(bookId,userId);
    }

}
