package it.uniroma3.siw.main;

import java.util.List;
import java.util.Scanner;
import javax.persistence.*;
import it.uniroma3.siw.model.*;

public class ProductMain {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		
		float price1 = 10;
		Product product1 = new Product("Prodatto",  price1,"descrizione prodotto 1: Prodatto", "P1");
		
		float price2 = 12;
		Product product2 = new Product("Prodetto",  price2,"descrizione prodotto 2: Prodetto", "P2");
		
		float price3 = 3;
		Product product3 = new Product("Proditto",  price3,"descrizione prodotto 3: Proditto", "P3");
		
		float price4 = 5;
		Product product4 = new Product("Prodotto",  price4,"descrizione prodotto 4: Prodotto", "P4");
		
		float price5 = 7;
		Product product5 = new Product("Produtto",  price5,"descrizione prodotto 5: Produtto", "P5");
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(product1);
		em.persist(product2);
		em.persist(product3);
		em.persist(product4);
		em.persist(product5);
		tx.commit();
		
		System.out.print("Insert price threshold: ");
		
		Scanner scanner = new Scanner(System.in);
		float priceThreshold = scanner.nextFloat();
		scanner.close();
		
		TypedQuery<Product> priceQuery = em.createQuery("SELECT p FROM Product p WHERE p.price < :price", Product.class);
		priceQuery.setParameter("price", priceThreshold);
		
		List<Product> priceQueryResults = priceQuery.getResultList();
		
		System.out.println("\nProducts with price lower than "+priceThreshold+": ");
		if(priceQueryResults.size()==0) System.out.println("no products found!");
		for(Product p : priceQueryResults)
			System.out.print(p.toString());
		
		em.close();
		emf.close();
		
	}
	
}
