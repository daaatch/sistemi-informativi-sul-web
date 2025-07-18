package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(nullable = false)
	private LocalDateTime creationDate;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<OrderLine> orderLines;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;
	
	public Order() {
	}
	
	public Order(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	
	public Long getId() {
		return this.Id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, creationDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(creationDate, other.creationDate);
	}

	@Override
	public String toString() {
		return "Order [Id=" + Id + ", creationDate=" + creationDate + "]";
	}
	
}
