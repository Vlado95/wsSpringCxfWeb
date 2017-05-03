package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitec.tp.dao.IDaoAuteur;
import com.fitec.tp.entity.Auteur;


@WebService(endpointInterface="com.fitec.tp.service.IServiceAuteur")
@Service
public class ServiceAuteurImpl implements IServiceAuteur {

	@Autowired
	private IDaoAuteur daoAuteur;
	
	@Override
	public Auteur rechercherAuteur(int id) {
		return daoAuteur.selectById(id);
	}

	@Override
	public List<Auteur> tousLesAuteur() {
		return daoAuteur.selectAll();
	}
	
	@Override
	public List<Auteur> lesAuteurParNom(String str) {
		return daoAuteur.searchLike(str);
	}

}
