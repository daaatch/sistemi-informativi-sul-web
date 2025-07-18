package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.*;

public class OrderRepository {

	private EntityManager em;
	
	public Order save(Order order) {
		if(order.getId()!=null)
			em.merge(order);
		else em.persist(order);
		return order;
	}
	
	public Order findById(Long id) {
		return em.find(Order.class, id);
	}
	
	public List<Order> findAll() {
		return em.createQuery("SELECT o FROM Orders o", Order.class).getResultList();
	}
	
	public void delete(Order o) {
		em.remove(o);
	}
	
	public void deleteAll() {
		em.createQuery("DELETE FROM Orders").executeUpdate();
	}
	
	public Long count() {
		return (Long)em.createQuery("SELECT count(id) FROM Orders").getSingleResult();
	}
	
	public boolean existsById(Long id) {
		return (this.findById(id)!=null);
	}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
}
