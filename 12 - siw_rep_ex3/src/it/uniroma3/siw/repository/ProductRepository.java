package it.uniroma3.siw.repository;

import java.util.List;
import javax.persistence.*;

import it.uniroma3.siw.model.Product;

public class ProductRepository extends SimpleRepositoryImpl<Product> {
	
	public ProductRepository() {
		super(Product.class);
	}
	
	public List<Product> findByName(String name) {
		TypedQuery<Product> query = this.getEntityManager().createQuery("SELECT p FROM Products p WHERE p.name = :name", Product.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
}
