package be.vdab.services;

import be.vdab.dao.LandDAO;
import be.vdab.entities.Land;

public class LandService {

	private final LandDAO landDAO = new LandDAO();

	public Iterable<Land> findAll() {
		return landDAO.findAll();
	}

	public Land read(long landNr) {
		return landDAO.read(landNr);
	}

}
