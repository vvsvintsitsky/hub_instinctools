package wsvintsitsky.instinctools.jpa.dataaccess.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import wsvintsitsky.instinctools.jpa.dataaccess.AbstractDao;

public class AbstractDaoImpl<T, ID> implements AbstractDao<T, ID> {

	private Class<T> entityClass;

	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;

	@Override
	public T find(ID id) {
		return getEntityManager().find(getEntityClass(), id);
	}

	@Override
	public T insert(T entity) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}

	@Override
	public T update(T entity) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entity = entityManager.merge(entity);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}

	@Override
	public void delete(ID id) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.createQuery(String.format("delete from %s e where e.id = :id", entityClass.getSimpleName()))
				.setParameter("id", id).executeUpdate();

		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
				entityManagerFactory = Persistence.createEntityManagerFactory("wsvintsitsky-instictools-training");
			}
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
}
