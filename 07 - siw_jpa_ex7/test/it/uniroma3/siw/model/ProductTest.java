package it.uniroma3.siw.model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.*;
import org.junit.jupiter.api.*;

class ProductTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	
	@BeforeAll
	public static void initEntityManager() throws Exception {
		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();
	}
	
	@AfterAll
	public static void closeEntityManager() throws SQLException {
		if (em != null) em.close();
		if (emf != null) emf.close();
	}
	
	@BeforeEach
	public void populateDB() throws Exception {
		Product product1 = new Product();
		product1.setName("SLANGAN");
		product1.setCode("4321423131-AA");
		Product product2 = new Product();
		product2.setName("SLANGAM");
		product2.setCode("4321423131-AB");
		
		tx = em.getTransaction();
		tx.begin();
		em.persist(product1);
		em.persist(product2);
		tx.commit();
	}
	
	@AfterEach
	public void emptyDB() throws Exception {
		Query deleteProducts = em.createNativeQuery("DELETE FROM Product");
		tx.begin();
		deleteProducts.executeUpdate();
		tx.commit();
	}

	@Test
	public void shouldCreateAproduct() throws Exception {
		List<Product> products = em.createNamedQuery("findAllProducts", Product.class).getResultList();
		assertEquals(2, products.size());
	}
	
	@Test
	public void testDynamicQuery() throws Exception {
		
		/* creazione query dinamica */
		TypedQuery<Product> selectDynamicQuery = em.createQuery("SELECT p FROM Product p", Product.class);
	
		/* lista dei risultati della query */
		List<Product> selectDynamicQueryResults = selectDynamicQuery.getResultList();
		
		assertEquals(2, selectDynamicQueryResults.size());
		
		TypedQuery<Product> selectByCode = em.createQuery("SELECT p FROM Product p WHERE p.code = '4321423131-AA'", Product.class);
		List<Product> selectByCodeResults = selectByCode.getResultList();
		assertEquals(1, selectByCodeResults.size());
		
		Query deleteDynamicQuery = em.createQuery("DELETE FROM Product p");
		tx.begin();
		int deleteDynamicRows = deleteDynamicQuery.executeUpdate();
		tx.commit();
		assertEquals(2, deleteDynamicRows);
	}
	
	@Test
	public void testNamedQuery() throws Exception {
		TypedQuery<Product> selectNamedQuery = em.createNamedQuery("findAllProducts", Product.class);
		List<Product> selectNamedQueryResults = selectNamedQuery.getResultList();
		assertEquals(2, selectNamedQueryResults.size());
		
		Query deleteNamedQuery = em.createNamedQuery("deleteAllProducts");
		tx.begin();
		int deleteNamedRows = deleteNamedQuery.executeUpdate();
		tx.commit();
		assertEquals(2, deleteNamedRows);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testNativeQuery() throws SQLException {
		Query selectNativeQuery = em.createNativeQuery("SELECT * FROM Product p", Product.class);
		List<Product> selectNativeQueryResults = selectNativeQuery.getResultList();
		assertEquals(2, selectNativeQueryResults.size());
		
		Query deleteNativeQuery = em.createNativeQuery("DELETE FROM Product");
		tx.begin();
		int deleteNativeRows = deleteNativeQuery.executeUpdate();
		tx.commit();
		assertEquals(2, deleteNativeRows);
	}
}
