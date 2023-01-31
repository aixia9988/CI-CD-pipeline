package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;

@Service
public class CartService
{
    @Autowired
    private CartRepository cartRepository;
    public void addToCart(CartItem cartItem, int amount) {

        cartRepository.insertOrIncrementItem(cartItem);
    }


    public void removeFromCart(CartItem cartItem) {
        cartRepository.deleteOrDecrementItem(cartItem);
    }

    public List<CartItem> getAllCartItems() {
        return cartRepository.selectAllItems();
    }

    public void clearCarts() {
        cartRepository.deleteAllItems(false);
    }

    public void clearAndRestoreCarts() {
        cartRepository.deleteAllItems(true);
    }
}
