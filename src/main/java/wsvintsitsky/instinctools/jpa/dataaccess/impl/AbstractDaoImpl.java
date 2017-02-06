package wsvintsitsky.instinctools.jpa.dataaccess.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import wsvintsitsky.instinctools.jpa.dataaccess.AbstractDao;

public class AbstractDaoImpl<T, ID> implements AbstractDao<T, ID> {

	private Class<T> entityClass;
	
	@Override
	public T insert(T entity) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("wsvintsitsky-instictools-training");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction( ).begin( );
		entityManager.persist(entity);
		entityManager.getTransaction( ).commit( );
		entityManager.close( );
		entityManagerFactory.close();
		return entity;
	}

	@Override
	public T update(T entity) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("wsvintsitsky-instictools-training");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction( ).begin( );
		entity = entityManager.merge(entity);
		entityManager.flush();
		entityManager.getTransaction( ).commit( );
		entityManager.close( );
		return entity;
	}

	@Override
	public void delete(ID id) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("wsvintsitsky-instictools-training");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction( ).begin( );
		entityManager.createQuery(String.format("delete from %s e where e.id = :id", entityClass.getSimpleName()))
				.setParameter("id", id).executeUpdate();
		entityManager.getTransaction( ).commit( );
		entityManager.close( );
	}

}
