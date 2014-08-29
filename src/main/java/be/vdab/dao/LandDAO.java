package be.vdab.dao;

import javax.persistence.TypedQuery;

import be.vdab.entities.Land;
import be.vdab.exceptions.LandNietGevondenException;

public class LandDAO extends AbstractDAO {

	public Land read(long landNr) {
		Land land = getEntityManager().find(Land.class, landNr);
		if (land==null) {
			throw new LandNietGevondenException();
		}
		return land;
	}
	
	public Iterable<Land> findAll() {
		TypedQuery<Land> query = getEntityManager().createNamedQuery(
				"Land.findAll", Land.class);
		return query.getResultList();
	}

}
