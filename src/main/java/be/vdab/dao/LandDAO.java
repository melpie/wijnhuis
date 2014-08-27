package be.vdab.dao;

import javax.persistence.TypedQuery;

import be.vdab.entities.Land;

public class LandDAO extends AbstractDAO {

	public Land read(long landNr) {
		return getEntityManager().find(Land.class, landNr);
	}
	
	public Iterable<Land> findAll() {
		TypedQuery<Land> query = getEntityManager().createNamedQuery(
				"Land.findAll", Land.class);
		return query.getResultList();
	}

}
