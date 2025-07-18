package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.*;

public class CustomerRepository {

	private EntityManager em;
	
	public Customer save(Customer c) {
		if (c.getId()!=null)
			em.merge(c);
		else em.persist(c);
		return c;
	}
	
	public Customer findById(Long id) {
		return em.find(Customer.class, id);
	}
	
	public List<Customer> findAll() {
		return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
	}
	
	public void delete(Customer c) {
		em.remove(c);
	}
	
	public void deleteAll() {
		em.createQuery("DELETE FROM Customer").executeUpdate();
	}
	
	public Long count() {
		return (Long)em.createQuery("SELECT count(id) FROM Customer").getSingleResult();
	}
	
	public boolean existsById(Long id) {
		return (this.findById(id)!=null);
	}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
}
