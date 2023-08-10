package org.nasuda.shopping.model;

import java.util.ArrayList;
import java.util.List;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Cart {
 	private Integer cartItemTotal;
	
	private Integer cartTotal;

	private Integer cartId;
			
	private List<CartItem> cartItemList = new ArrayList<CartItem>();

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("cartId = " + cartId);
        str.append(", cartTotal = " + cartTotal);
        str.append(", cartItemTotal = "+ cartItemTotal);
        str.append(", cartItemList = " + cartItemList);
        return str.toString();

    }
	public Cart() {
	}

	public Cart(Integer cartId) {
		this.cartId = cartId;
	}

    @ProtoFactory
    public Cart(Integer cartItemTotal, Integer cartTotal, Integer cartId, List<CartItem> cartItemList){
        this.cartItemTotal = cartItemTotal;
        this.cartTotal = cartTotal;
        this.cartId = cartId;
        this.cartItemList = cartItemList;       
    }

    @ProtoField(number = 1)
	public Integer getCartItemTotal() {
		return cartItemTotal;
	}

	public void setCartItemTotal(Integer cartItemTotal) {
		this.cartItemTotal = cartItemTotal;
	}

    @ProtoField(number = 2)
	public Integer getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(Integer cartTotal) {
		this.cartTotal = cartTotal;
	}

    @ProtoField(number = 3)
	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

    @ProtoField(number = 4)
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

    public void resetCartItemList() {
		cartItemList = new ArrayList<CartItem>();
  }

	public void addCartItem(CartItem sci) {
		
		if ( sci != null ) {
			
			cartItemList.add(sci);
			
		}
		
	}
	
	public boolean removeCartItem(CartItem sci) {
		
		boolean removed = false;
		
		if ( sci != null ) {
			
			removed = cartItemList.remove(sci);
			
		}
		
		return removed;
		
	}
}
