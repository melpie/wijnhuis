package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "landen")
public class Land implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long landNr;
	private String naam;
	@OneToMany(mappedBy="land")
	@OrderBy("naam")
	private Set<Soort> soorten;
	
	protected Land() {}
	
	public Land(String naam) {
		setNaam(naam);
	}

	public long getLandNr() {
		return landNr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}	
	
	public Set<Soort> getSoorten() {
		return Collections.unmodifiableSet(soorten);
	}
	
	public void addSoort(Soort soort) {
		soorten.add(soort);
		if (soort.getLand() != this) {
			soort.setLand(this);
		}
	}
	
	public void removeSoort(Soort soort) {
		soorten.remove(soort);
		if (soort.getLand() == this) {
			soort.setLand(null);
		}
	}

}