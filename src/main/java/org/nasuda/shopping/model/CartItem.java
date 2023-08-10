package org.nasuda.shopping.model;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class CartItem {
    private Integer quantity;
    private Product product; 

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("quantiry = " + quantity);
        str.append(", product" + product);
        return str.toString();
    }

	public CartItem () {
    }

    @ProtoFactory
    public CartItem(Integer quantity, Product product){
        this.quantity = quantity;
        this.product = product;
    }
    
    @ProtoField(number = 1)
    public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

    @ProtoField(number = 2)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}    
}