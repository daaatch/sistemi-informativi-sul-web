package it.uniroma3.siw.main;

import javax.persistence.*;

public class MuseumMain {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("museum-unit");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Hello world!");

		em.close();
		emf.close();
		
	}
}
