package com.fitec.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fitec.tp.entity.Auteur;

@Component // ou bien @repository
@Transactional // version spring
public class DaoAuteur implements IDaoAuteur {
	
	@PersistenceContext(unitName="myPersistenceUnit") //inection +initialisation connexion base
	private EntityManager entityManager; //JPA

	@Override
	public Auteur selectById(int id) {
		return entityManager.find(Auteur.class, id);
	}

	@Override
	public List<Auteur> selectAll() {
		/*return entityManager.createQuery("SELECT a FROM Auteur a", Auteur.class).getResultList();*/
		return entityManager.createNamedQuery("auteur.all",Auteur.class).getResultList();
	}

	@Override
	public List<Auteur> searchLike(String str) {
		return entityManager.createNamedQuery("auteur.search",Auteur.class).setParameter(1,  "%"+str+"%").getResultList();
	}

}
