package com.fitec.tp.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fitec.tp.entity.Auteur;
import com.fitec.tp.service.IServiceAuteur;

@Path("/auteurs")
@Produces("application/json")
@Consumes("application/json")
@CrossOriginResourceSharing(allowAllOrigins=true)
@Component // ou @Service (info :herite de component) : pour prise en charge
			// Spring
public class ServiceAuteurRest {

	@Autowired
	private IServiceAuteur serviceAuteur;
	// service interne ou private IDaoteur daoAuteur; // dao interne

	@GET
	@Path("/{id}")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/1
	// où service est configuré dans web.xml et rest dans restSpringConf.xml
	public Auteur rechercherAuteur(@PathParam("id") int id) {
		return serviceAuteur.rechercherAuteur(id);
	}

	@GET
	@Path("/all")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/all
	// où service est configuré dans web.xml et rest dans restSpringConf.xml
	public List<Auteur> tousLesAuteur() {
		return serviceAuteur.tousLesAuteur();
	}

	@GET
	@Path("/nomlike/{str}")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/nom/"vi"
	// où service est configuré dans web.xml et rest dans restSpringConf.xml
	public List<Auteur> tousLesAuteur(@PathParam("str") String str) {
		return serviceAuteur.lesAuteurParNom(str);
	}

	@POST
	@Path("/")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/nom/"vi"
	// où service est configuré dans web.xml et rest dans restSpringConf.xml
	public Response ajouterAuteur(Auteur auteur) {
		try {
			serviceAuteur.ajouterAuteur(auteur);
			return Response.status(Status.OK).entity(auteur) // partie "donnée"
																// de la réponse
																// renvoyée
					.build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
			// return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@DELETE
	@Path("/{id}")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/nom/"vi"
	// où service est configuré dans web.xml et rest dans restSpringConf.xml
	public Response ajouterAuteur(@PathParam("id") int id) {
		try {
			serviceAuteur.supprimerAutuer(id);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
			// return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@PUT
	@Path("/{id}")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/nom/"vi"
	// où service est configuré dans web.xml et rest dans restSpringConf.xml
	public Response majAuteur(@PathParam("id") int id, Auteur auteur) {
		try {
			serviceAuteur.majAuteur(auteur);;
			return Response.status(Status.OK).entity(auteur).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
			// return Response.status(Status.BAD_REQUEST).build();
		}
	}

}
