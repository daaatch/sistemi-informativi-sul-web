package it.uniroma3.siw.main;

import javax.persistence.*;

public class TorneoMain {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("torneo-unit");
		EntityManager em = emf.createEntityManager();

		System.out.println("Hello World!");
		
		em.close();
		emf.close();

	}
	
}
