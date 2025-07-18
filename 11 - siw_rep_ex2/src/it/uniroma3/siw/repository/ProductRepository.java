package it.uniroma3.siw.repository;

import java.util.List;
import javax.persistence.EntityManager;
import it.uniroma3.siw.model.Product;

public class ProductRepository {
	
	private EntityManager em;

	public Product save(Product product) {	
		if (product.getId()!=null)
			em.merge(product);
		else em.persist(product);	
		return product;
	}

	public Product findById(Long id) {
		return em.find(Product.class, id);
	}
	
	public List<Product> findAll() {
		return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	}

	public void delete(Product product) {
		em.remove(product);
	}

	public void deleteAll(){
		this.em.createQuery("delete from Product").executeUpdate();
	}

	public long count() {
		return (Long)this.em.createQuery("select count(id) from Product").getSingleResult();
	}

	public boolean existsById(Long id) {
		return (this.findById(id)!=null);
	}

	public void setEntityManager(EntityManager em) {
		this.em = em; 
	}
}
