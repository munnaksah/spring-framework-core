package com.apna.product.request;

public class ProductResponse {
	
	
	private String productName;
	private String description;
	private String price;
	private String qty;

	private int id;

	private String confirmationMSG;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getConfirmationMSG() {
		return confirmationMSG;
	}

	public void setConfirmationMSG(String confirmationMSG) {
		this.confirmationMSG = confirmationMSG;
	}

	public void setProductName(String productName) {
		this.setProductName(productName);
		
	}

	public void setDescription(String description) {
		this.setDescription(description);
		// TODO Auto-generated method stub
		
	}

	public void setPrice(String valueOf) {
		this.setPrice(valueOf);
		
	}

	public void setQty(String valueOf) {
	this.setQty(valueOf);
		
	}

}
