package org.nasuda.shopping.model;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Product {
    
	private Integer itemId;
	private String name;
	private Integer price;

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("itemId = " + itemId.toString());
        str.append(", name = " + name);
        str.append(", price = " + price);
        return str.toString();
    }

	public Product() {
	} 

    @ProtoFactory
    public Product(Integer itemId, String name, Integer price){
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }
    
    @ProtoField(number = 1)
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

    @ProtoField(number = 2)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @ProtoField(number = 3)
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}


}

