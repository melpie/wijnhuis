package be.vdab.dao;

import javax.persistence.TypedQuery;

import be.vdab.entities.Land;
import be.vdab.entities.Soort;

public class SoortDAO extends AbstractDAO {

	public Soort read(long soortNr) {
		return getEntityManager().find(Soort.class, soortNr);
	}
	
	public Iterable<Soort> findAll() {
		TypedQuery<Soort> query = getEntityManager().createNamedQuery(
				"Soort.findAll", Soort.class);
		return query.getResultList();
	}
	
	public Iterable<Soort> findByLand(Land land) {
		TypedQuery<Soort> query = getEntityManager().createNamedQuery(
				"Soort.findByLand", Soort.class);
		query.setParameter("land", land);
		return query.getResultList();
	}

}