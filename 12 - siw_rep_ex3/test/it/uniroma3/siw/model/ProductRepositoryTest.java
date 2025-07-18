package it.uniroma3.siw.model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.persistence.*;

import org.junit.jupiter.api.*;

import it.uniroma3.siw.repository.ProductRepository;

class ProductRepositoryTest {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	private static ProductRepository rep;
	private static Product p;
	
	@BeforeAll
	public static void initEntityManager() throws Exception {
		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		rep = new ProductRepository();
		rep.setEntityManager(em);
		p = new Product("Product", (float)1, "product description", "ABC123");
	}
	
	@AfterAll
	public static void closeEntityManager() throws SQLException {
		if (em != null) em.close();
		if (emf != null) emf.close();
	}
	
	@Test
	public void testSaveAndFindProduct() {
		tx.begin();
		rep.save(p);
		tx.commit();
		assertNotNull(rep.findById(p.getId()));
		assertEquals(p,rep.findById(p.getId()));
	}
	
	@Test
	public void testExistsById() {
		assertNotNull(rep.existsById(p.getId()));
	}
	
	@Test
	public void testFindAll() {
		tx.begin();
		rep.save(p);
		tx.commit();
		assertEquals(1,rep.findAll().size());
	}
	
	@Test
	public void testDelete() {
		tx.begin();
		rep.delete(p);
		tx.commit();
		assertEquals(0,rep.findAll().size());	
	}

}
