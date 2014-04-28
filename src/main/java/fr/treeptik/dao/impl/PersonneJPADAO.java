package fr.treeptik.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.PersonneDAO;
import fr.treeptik.model.Personne;

@Repository
public class PersonneJPADAO extends GenericJPADAO<Personne, Integer> implements PersonneDAO{

	public PersonneJPADAO() {
		super(Personne.class);
	}

	@PersistenceContext
	private EntityManager entityManager;
	
	
}
