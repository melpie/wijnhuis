package be.vdab.services;

import be.vdab.dao.SoortDAO;
import be.vdab.entities.Land;
import be.vdab.entities.Soort;

public class SoortService {

	private final SoortDAO soortDAO = new SoortDAO();

	public Iterable<Soort> findAll() {
		return soortDAO.findAll();
	}

	public Soort read(long soortNr) {
		return soortDAO.read(soortNr);
	}
	
	public Iterable<Soort> findByLand(Land land) {
		return soortDAO.findByLand(land);
	}

}