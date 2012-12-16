package com.esprit.conge.domaine.management;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.esprit.conge.entities.*;

/**
 * Session Bean implementation class ManagementServices
 */
@Stateless
public class ManagementServices implements ManagementServicesRemote, ManagementServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public ManagementServices() {
        
    }

	@Override
	public Employe addEmploye(Employe employe) {
		entityManager.persist(employe);
		return employe;
	}

	@Override
	public boolean deleteEmploye(Employe employe) {
		entityManager.remove(employe);
		return entityManager.contains(employe);
	}

	@Override
	public Employe editEmploye(Employe employe) {
		entityManager.merge(employe);
		return null;
	}

	@Override
	public Conge addConge(Conge conge) {
		entityManager.persist(conge);
		return conge;
	}

	@Override
	public boolean deleteConge(Conge conge) {
		entityManager.remove(conge);
		return entityManager.contains(conge);
	}

	@Override
	public Conge editConge(Conge conge) {
		entityManager.merge(conge);
		return conge;
	}

	@Override
	public Object checkin(String login, String password, String type) {
		String jpql = "select u from "+type+" u where u.login=:param1 and u.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
