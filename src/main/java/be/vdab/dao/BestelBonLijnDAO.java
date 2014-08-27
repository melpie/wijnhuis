package be.vdab.dao;

import be.vdab.entities.BestelBonLijn;

public class BestelBonLijnDAO extends AbstractDAO {

	public void create(BestelBonLijn bestelBonLijn) {
		getEntityManager().persist(bestelBonLijn);
	}

}
