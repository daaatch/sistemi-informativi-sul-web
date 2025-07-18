package it.uniroma3.siw.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.*;
import it.uniroma3.siw.model.*;

public class ProductMain {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		
		float price1 = 10;
		Product product1 = new Product("Prodatto",  price1,"descrizione prodotto 1: Prodatto", "P1");
		
		float price2 = 2;
		Product product2 = new Product("Prodetto",  price2,"descrizione prodotto 2: Prodetto", "P2");
		
		float price3 = 7;
		Product product3 = new Product("Proditto",  price3,"descrizione prodotto 3: Proditto", "P3");
		
		float price4 = 5;
		Product product4 = new Product("Prodotto",  price4,"descrizione prodotto 4: Prodotto", "P4");
		
		float price5 = 7;
		Product product5 = new Product("Produtto",  price5,"descrizione prodotto 5: Produtto", "P5");
		
		float price6 = 13;
		Product product6 = new Product("Prodàtto",  price6,"descrizione prodotto 6: Prodàtto", "P6");
		
		float price7 = 10;
		Product product7 = new Product("Prodètto",  price7,"descrizione prodotto 7: Prodètto", "P7");
		
		float price8 = 5;
		Product product8 = new Product("Prodìtto",  price8,"descrizione prodotto 8: Prodìtto", "P8");
		
		float price9 = 11;
		Product product9 = new Product("Prodòtto",  price9,"descrizione prodotto 9: Prodòtto", "P9");
		
		float price0 = 10;
		Product product0= new Product("Prodùòtto",  price0,"descrizione prodotto 0: Prodùtto", "P0");
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(product1);
		em.persist(product2);
		em.persist(product3);
		em.persist(product4);
		em.persist(product5);
		em.persist(product6);
		em.persist(product7);
		em.persist(product8);
		em.persist(product9);
		em.persist(product0);
		tx.commit();
		
		System.out.println("\nProducts grouped by price:");
		
		Map<Float, Long> counterPrice = new HashMap<>();
		TypedQuery<Object[]> priceQuery = em.createQuery("SELECT p.price, count(p) FROM Product p GROUP BY p.price", Object[].class);
		for(Object[] obj : priceQuery.getResultList())
			counterPrice.put((Float)obj[0], (Long)obj[1]);
		if(priceQuery.getResultList().size() == 0) System.out.println("no products found!");
		for(Entry<Float, Long> entry : counterPrice.entrySet())
			System.out.println(entry.getKey()+" ("+entry.getValue()+" times)");
		
		/* query findallproducts ordered by price da cui prendo first e last */
		TypedQuery<Product> selectProducts = em.createQuery("SELECT p FROM Product p ORDER BY p.price ASC", Product.class);
		List<Product> selectResult = selectProducts.getResultList();
		System.out.println("\nProduct with lowest price: ");
		System.out.println(selectResult.get(0).toString());
		System.out.println("\nProduct with highest price: ");
		System.out.println(selectResult.get(selectResult.size()-1).toString());
		
		em.close();
		emf.close();	
	}
}
