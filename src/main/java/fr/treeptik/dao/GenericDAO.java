package fr.treeptik.dao;

import java.util.List;

public interface GenericDAO<T,K> {

	T save(T entity) throws DAOException;

	T update(T entity) throws DAOException;

	void remove(T entity) throws DAOException;

	T findById(K id) throws DAOException;

	List<T> findAll() throws DAOException;

}
