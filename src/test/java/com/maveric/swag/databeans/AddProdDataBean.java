package com.maveric.swag.databeans;

public class AddProdDataBean {
	public String product;
	 
	public String getProduct() {
		return product;
	}
 
	public void setProduct(String product) {
		this.product = product;
	}
 
	@Override
	public String toString() {
		return "ProductBean [product=" + product + "]";
	}
}
