package com.fitec.tp.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service  // par defaut id =  calculateurImpl (le nom de la classe avec miniscule au debut)
@WebService(endpointInterface="com.fitec.tp.service.ICalculateur")
public class CalculateurImpl implements ICalculateur {

	@Override
	public double tva(double ht, double tauxPct) {
		return ht * tauxPct / 100;
	}

	@Override
	public String getAuteur() {
		return "Vlado";
	}

}
