package com.example.basketapp;

import java.util.ArrayList;

public class CartManager {
    private static CartManager instance;
    private ArrayList<CartItem> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void addItemToCart(Product product, int quantity) {
        boolean productExists = false;

        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId() == product.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            cartItems.add(new CartItem(product, quantity));
        }
    }
    public void addToCart(Product product) {
        boolean productExists = false;

        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId() == product.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            cartItems.add(new CartItem(product, 1));
        }
    }
}
