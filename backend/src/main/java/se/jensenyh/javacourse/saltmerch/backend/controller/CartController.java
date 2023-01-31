package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3010"})
@RequestMapping("/")
public class CartController {
    @Autowired
    private CartService cartService;

    @PatchMapping(path = "/api/v1/carts/{id}")
    public void updateCart(@PathVariable("id") int id, @RequestParam(value="action", required = true) String action, @RequestBody CartItem cartItem) {

        if ("add".equalsIgnoreCase(action)) {
            cartService.addToCart(cartItem, 1);
        } else {
            // suppose it will be "remove"
            cartService.removeFromCart(cartItem);
        }

    }


    @GetMapping("/api/v1/carts/{id}")
    public List<CartItem> selectAllCartItems(@PathVariable("id") int id) {

       return cartService.getAllCartItems();

    }

    @DeleteMapping(path = "/api/v1/carts/{id}")
    public void deleteAllCartItems(@PathVariable("id") int id, @RequestParam(value="buyout", required = false) boolean buyout ) {

        if (true == buyout){
            cartService.clearCarts();
        } else {
            cartService.clearAndRestoreCarts();
        }


    }






}


