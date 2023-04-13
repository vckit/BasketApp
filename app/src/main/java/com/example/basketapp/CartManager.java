package com.example.basketapp;

import java.util.ArrayList;

public class CartManager {
    private static CartManager instance;
    private ArrayList<Product.CartItem> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public ArrayList<Product.CartItem> getCartItems() {
        return cartItems;
    }

    public void addItemToCart(Product product, int quantity) {
        boolean productExists = false;

        for (Product.CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId() == product.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            cartItems.add(new Product.CartItem(product, quantity));
        }
    }
    // Метод добавления продукторв в корзину
    public void addToCart(Product product) {
        boolean productExists = false;

        // Если продуктов выбран, то есть уже в корзине, то мы прибавляем 1
        for (Product.CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId() == product.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                productExists = true;
                break;
            }
        }
        // Если продукт не выбран в корзине, мы добавляем
        if (!productExists) {
            cartItems.add(new Product.CartItem(product, 1));
        }
    }
}
