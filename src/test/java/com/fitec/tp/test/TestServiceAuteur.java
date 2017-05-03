package com.fitec.tp.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fitec.tp.entity.Auteur;
import com.fitec.tp.service.IServiceAuteur;


//nécessite spring-test.jar et junit4.8.1.jar dans le classpath
@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from "/applicationContex.xml" in the root of the classpath
//@ContextConfiguration(locations={"/applicationContext.xml"})
@ContextConfiguration(locations={"/jpaSpringConf.xml"})
public class TestServiceAuteur {

	@Before
	public void setUp() throws Exception {
	}

	@Autowired
	private IServiceAuteur serviceAuteur;  // à tester

	@Test
	public void testRercherAuteur() {
		Auteur auteur =serviceAuteur.rechercherAuteur(1);
		Assert.assertTrue( auteur.getId() == 1);
		System.out.println(auteur.toString());
		
	}
	
	@Test
	public void testLesAuteurParNom() {
		List<Auteur> auteurList =serviceAuteur.lesAuteurParNom("e");
		System.out.println(auteurList);
		
	}

}
