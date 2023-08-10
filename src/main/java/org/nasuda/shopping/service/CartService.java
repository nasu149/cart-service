package org.nasuda.shopping.service;

import java.io.Serializable;

import org.nasuda.shopping.model.Cart;

public interface CartService extends Serializable{
    public Cart getCart(String cartId);

    public Cart addItem(Integer cartId, Integer itemId, int quantity);

    public Cart set(Integer cartId, Integer tempId);

    public Cart deleteItem(Integer cartId, Integer itemId, int quantity);

    public Cart checkout(Integer cartId);
}
