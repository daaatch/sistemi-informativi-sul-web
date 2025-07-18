package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.*;

import it.uniroma3.siw.model.*;

public class CustomerRepository extends SimpleRepositoryImpl<Customer> {

	public CustomerRepository() {
		super(Customer.class);
	}
	
	public List<Customer> findByName(String name) {
		TypedQuery<Customer> query = this.getEntityManager().createQuery("SELECT c FROM Customer c WHERE c.name = :name", Customer.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
}
