package com.apna.product.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_item_info")
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    // ✅ Many Items → One Cart
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    // ✅ Many Items → One Product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

    // getters & setters
}