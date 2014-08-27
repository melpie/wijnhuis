package be.vdab.dao;

import javax.persistence.TypedQuery;

import be.vdab.entities.BestelBon;

public class BestelBonDAO extends AbstractDAO {

	public BestelBon read(long bonNr) {
		return getEntityManager().find(BestelBon.class, bonNr);
	}
	
	public Iterable<BestelBon> findAll() {
		TypedQuery<BestelBon> query = getEntityManager().createNamedQuery(
				"BestelBon.findAll", BestelBon.class);
		return query.getResultList();
	}
	
	public void create(BestelBon bestelBon) {
		getEntityManager().persist(bestelBon);
	}

}
