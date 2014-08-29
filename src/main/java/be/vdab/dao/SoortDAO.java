package be.vdab.dao;

import javax.persistence.TypedQuery;

import be.vdab.entities.Land;
import be.vdab.entities.Soort;
import be.vdab.exceptions.SoortNietGevondenException;

public class SoortDAO extends AbstractDAO {

	public Soort read(long soortNr) {
		Soort soort = getEntityManager().find(Soort.class, soortNr);
		if (soort==null) {
			throw new SoortNietGevondenException();
		}
		return soort;
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