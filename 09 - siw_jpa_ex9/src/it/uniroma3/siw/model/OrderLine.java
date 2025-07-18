package it.uniroma3.siw.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findAllOrderLines", query = "SELECT ol FROM OrderLine ol")
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Float unitPrice;
	
	@Column(nullable = false)
	private int quantity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Order order;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;
	
	public OrderLine() {
	}
	
	public OrderLine(Float unitPrice, int quantity) {
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, quantity, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLine other = (OrderLine) obj;
		return Objects.equals(id, other.id) && quantity == other.quantity && Objects.equals(unitPrice, other.unitPrice);
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", unitPrice=" + unitPrice + ", quantity=" + quantity + "]";
	}

}
