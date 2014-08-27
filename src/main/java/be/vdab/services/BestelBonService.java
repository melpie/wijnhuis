package be.vdab.services;

import be.vdab.dao.BestelBonDAO;
import be.vdab.entities.BestelBon;

public class BestelBonService {

	private final BestelBonDAO bestelBonDAO = new BestelBonDAO();

	public Iterable<BestelBon> findAll() {
		return bestelBonDAO.findAll();
	}

	public BestelBon read(long bestelbonNr) {
		return bestelBonDAO.read(bestelbonNr);
	}

}