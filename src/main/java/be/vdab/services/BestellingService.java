package be.vdab.services;

import java.util.Set;

import be.vdab.dao.BestelBonDAO;
import be.vdab.dao.BestelBonLijnDAO;
import be.vdab.entities.BestelBon;
import be.vdab.entities.BestelBonLijn;
import be.vdab.entities.Wijn;

public class BestellingService {

	private final BestelBonDAO bestelBonDAO = new BestelBonDAO();
	private final BestelBonLijnDAO bestelBonLijnDAO = new BestelBonLijnDAO();

	public void doeBestelling(Set<BestelBonLijn> bestelBonLijnen, BestelBon bestelBon) {
		
		bestelBonDAO.beginTransaction();
		
		bestelBonDAO.create(bestelBon);
		
		for (BestelBonLijn bbl : bestelBonLijnen) {
			bestelBonLijnDAO.create(bbl);
			Wijn wijn = bbl.getWijn();
			wijn.setInBestelling(bbl.getAantal());
		}
		
		bestelBonDAO.commit();
		
	}

}