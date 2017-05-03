package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.fitec.tp.entity.Auteur;

@WebService
public interface IServiceAuteur {
	
	
	public Auteur rechercherAuteur(@WebParam(name="id") int id);
	
	public List<Auteur> tousLesAuteur();
	
	public List<Auteur> lesAuteurParNom(String str);
	
	

}
