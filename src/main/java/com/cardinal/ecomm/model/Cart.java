package com.cardinal.ecomm.model;

public class Cart {
    private String user_id;
    private String cart_id;
    private int product_id;
    private int quantity;
    private float price;
    private int status_cart;
    private int status_wishlist;

    public Cart() {
    }

    public Cart(String user_id, String cart_id, int product_id, int quantity, float price) {
        this.user_id = user_id;
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public Cart(String user_id, String cart_id, int product_id, int quantity, float price, int status_cart, int status_wishlist) {
        this.user_id = user_id;
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.status_cart = status_cart;
        this.status_wishlist = status_wishlist;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus_cart() {
        return status_cart;
    }

    public void setStatus_cart(int status_cart) {
        this.status_cart = status_cart;
    }

    public int getStatus_wishlist() {
        return status_wishlist;
    }

    public void setStatus_wishlist(int status_wishlist) {
        this.status_wishlist = status_wishlist;
    }
}

