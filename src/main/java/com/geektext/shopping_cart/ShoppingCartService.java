package com.geektext.shopping_cart;

import com.geektext.book_details.book.Book;
import com.geektext.book_details.book.BookRepository;
import com.geektext.book_details.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ShoppingCartService {

    private final ShoppingDAO shoppingDAO;

    private final BookService bookService;

    public BigDecimal getBookPrice(BigInteger isbn){
        return bookService.getBookByIsbn(isbn).getPrice();

    }

    public BigDecimal subTotalPrice(Integer userId){
        List<ShoppingCart> shoppingCarts = shoppingDAO.getBookByUserId(userId);
        BigDecimal total = BigDecimal.ZERO;

        for (ShoppingCart shoppingCart : shoppingCarts){
            BigDecimal bookPrice = getBookPrice(shoppingCart.getBookId());
            total = total.add(bookPrice);
            //return  (getBookPrice(shoppingCart.getBook_id()));
        }
        return total ;
    }

    public  void addToCart(BigInteger bookId, Integer userId){
        ShoppingCart cart = ShoppingCart.builder()
                .userId(userId)
                .bookId(bookId)
                .build();
        shoppingDAO.saveOrUpdateCart(cart);
    }

    public List<Book> getBooksInCart(Integer userId){
        List<ShoppingCart> shoppingCarts = shoppingDAO.getBookByUserId(userId);
        List<Book> booksInCart = new ArrayList<>();

        for (ShoppingCart shoppingCart : shoppingCarts){
            Book book = bookService.getBookByIsbn(shoppingCart.getBookId());
            if (book != null){
                booksInCart.add(book);
            }
        }
        return booksInCart;
    }

    public void deleteBookFromCart(BigInteger book_id, Integer userId){
        shoppingDAO.deleteBookFromCart(book_id,userId);
    }
}
