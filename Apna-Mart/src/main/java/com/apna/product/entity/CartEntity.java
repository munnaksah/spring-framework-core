package com.apna.product.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_info")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String userId;
	private String status;

	@CreationTimestamp
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public CartEntity(Integer id, String userId, String status, LocalDateTime createdAt, LocalDateTime updatedAt,
			List<CartItemEntity> items) {
		super();
		this.id = id;
		this.userId = userId;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.items = items;
	}

	public CartEntity() {

	}

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItemEntity> items = new ArrayList<>();
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<CartItemEntity> getItems() {
		return items;
	}

	public void setItems(List<CartItemEntity> items) {
		this.items = items;
	}

}
