package be.vdab.dao;

import javax.persistence.TypedQuery;

import be.vdab.entities.Soort;
import be.vdab.entities.Wijn;
import be.vdab.exceptions.WijnNietGevondenException;


public class WijnDAO extends AbstractDAO {

	public Wijn read(long wijnNr) {
		Wijn wijn = getEntityManager().find(Wijn.class, wijnNr);
		if (wijn==null) {
			throw new WijnNietGevondenException();
		}
		return wijn;
	}
	
	public Iterable<Wijn> findAll() {
		TypedQuery<Wijn> query = getEntityManager().createNamedQuery(
				"Wijn.findAll", Wijn.class);
		return query.getResultList();
	}
	
	public Iterable<Wijn> findBySoort(Soort soort) {
		TypedQuery<Wijn> query = getEntityManager().createNamedQuery(
				"Wijn.findBySoort", Wijn.class);
		query.setParameter("soort", soort);
		return query.getResultList();
	}

}