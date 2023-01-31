package se.jensenyh.javacourse.saltmerch.backend.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartItemTest {

    @Test
    public void testCartItemCreation() {

        CartItem test = new CartItem(1000, "title", "blue", "14", "none");
        assertEquals(test.productId, 1000);
        assertEquals(test.title, "title");
        assertEquals(test.color, "blue");

    }

    @Test
    public void testCartItemQuantity() {
        CartItem item = new CartItem(1000, "title", "blue", "14", "none");
        assertEquals(item.quantity, 0);
        item = new CartItem(1000, "title", "blue", "14", "none",28);
        assertEquals(item.quantity, 28);

    }
}