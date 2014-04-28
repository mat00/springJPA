package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.DAOException;
import fr.treeptik.dao.GenericDAO;

@Repository
public abstract class GenericJPADAO<T, K> implements GenericDAO<T, K> {

	private Class<T> type;

	@PersistenceContext
	private EntityManager entityManager;

	public GenericJPADAO(Class<T> type) {
		this.type = type;
	}

	@Override
	public T save(T entity) throws DAOException {
		try {
			entityManager.persist(entity);
		} catch (PersistenceException e) {
			throw new DAOException("erreur save entity", e);
		}
		return entity;
	}

	@Override
	public T update(T entity) throws DAOException {
		try {
			entity = entityManager.merge(entity);
		} catch (PersistenceException e) {
			throw new DAOException("erreur update entity", e);
		}
		return entity;
	}

	@Override
	public void remove(T entity) throws DAOException {
		try {
			entityManager.remove(entity);
		} catch (PersistenceException e) {
			throw new DAOException("erreur remove entity", e);
		}
	}

	@Override
	public T findById(K id) throws DAOException {
		try {
			return entityManager.find(type, id);
		} catch (PersistenceException e) {
			throw new DAOException("erreur findById entity", e);
		}
	}

	@Override
	public List<T> findAll() throws DAOException {
		try {
			TypedQuery<T> query = entityManager.createQuery("Select t from "
					+ type.getName() + " t", type);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findAll entity", e);
		}
	}
}
