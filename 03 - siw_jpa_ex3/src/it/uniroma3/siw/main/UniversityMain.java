package it.uniroma3.siw.main;

import javax.persistence.*;

public class UniversityMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("university-unit");
		EntityManager em = emf.createEntityManager();
		em.close();
		emf.close();
	}

}
