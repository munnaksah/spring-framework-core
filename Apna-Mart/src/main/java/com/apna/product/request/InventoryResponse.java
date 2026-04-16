package com.apna.product.request;

public class InventoryResponse {
	
	private Integer productId;
    private Integer availableQty;
    private String status;
    
    public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(Integer availableQty) {
		this.availableQty = availableQty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
