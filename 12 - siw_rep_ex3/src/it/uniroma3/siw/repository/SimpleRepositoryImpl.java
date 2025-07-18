package it.uniroma3.siw.repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;

public class SimpleRepositoryImpl<T> implements SimpleRepository<T> {

	protected EntityManager em;
	private Class<T> domainClass;

	public SimpleRepositoryImpl(Class<T> domainClass) {
		this.domainClass = domainClass;
	}

	public T save(T entity) {
		Method getId = null;
		T persistentEntity = null;
		try {
			getId = this.domainClass.getMethod("getId");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		try {
			if (getId.invoke(entity) == null) {  // (entity.getId() == null)
				this.em.persist(entity);
				persistentEntity = entity;
			} else {
				persistentEntity = em.merge(entity);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return persistentEntity;
	}

	public List<T> findAll() { 
		return em.createQuery("select o from " + this.domainClass.getName() + " o", this.domainClass).getResultList();
	}	
	
	public T findById(Long id){
		return em.find(this.domainClass, id); 
	}

	public void delete(T t){
		this.em.remove(t);
	}

	public void deleteAll(){
		this.em.createQuery("DELETE FROM "+this.domainClass.getName()).executeUpdate();
	}

	public long count() {
		return (long)this.em.createQuery("SELECT COUNT(id) FROM "+this.domainClass.getName()).getSingleResult();
	}

	public boolean existsById(Long id) {
		return (this.findById(id)!=null);
	}

	public EntityManager getEntityManager() {
		return this.em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
}