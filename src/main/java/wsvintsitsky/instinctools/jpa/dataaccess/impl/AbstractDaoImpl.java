package wsvintsitsky.instinctools.jpa.dataaccess.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import wsvintsitsky.instinctools.jpa.dataaccess.AbstractDao;

public class AbstractDaoImpl<T, ID> implements AbstractDao<T, ID> {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("wsvintsitsky-instictools-training");

	private Class<T> entityClass;
	
	@Override
	public T insert(T entity) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		entity = entityManager.merge(entity);
		entityManager.flush();
		return entity;
	}

	@Override
	public void delete(ID id) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		entityManager.createQuery(String.format("delete from %s e where e.id = :id", entityClass.getSimpleName()))
				.setParameter("id", id).executeUpdate();
	}

}
