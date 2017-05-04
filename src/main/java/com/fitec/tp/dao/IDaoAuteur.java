package com.fitec.tp.dao;

import java.util.List;

import com.fitec.tp.entity.Auteur;

public interface IDaoAuteur {

	public Auteur selectById(int id);
	public List<Auteur> selectAll();
	
	public List<Auteur> searchLike(String str);
	
	
	public Auteur insert(Auteur a);
	
	public void updateAuteur(Auteur a);
	
	public void deleteAuteur(int id);
}
