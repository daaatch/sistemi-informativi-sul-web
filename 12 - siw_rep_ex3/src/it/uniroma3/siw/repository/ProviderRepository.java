package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.*;

import it.uniroma3.siw.model.*;

public class ProviderRepository extends SimpleRepositoryImpl <Provider> {

	public ProviderRepository() {
		super(Provider.class);
	}
	
	public List<Provider> findByName(String name) {
		TypedQuery<Provider> query = this.getEntityManager().createQuery("SELECT p FROM Providers p WHERE p.name = :name", Provider.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
}
