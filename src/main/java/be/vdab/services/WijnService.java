package be.vdab.services;

import be.vdab.dao.WijnDAO;
import be.vdab.entities.Soort;
import be.vdab.entities.Wijn;


public class WijnService {

	private final WijnDAO wijnDAO = new WijnDAO();

	public Iterable<Wijn> findAll() {
		return wijnDAO.findAll();
	}

	public Wijn read(long wijnNr) {
		return wijnDAO.read(wijnNr);
	}
	
	public Iterable<Wijn> findBySoort(Soort soort) {
		return wijnDAO.findBySoort(soort);
	}

}