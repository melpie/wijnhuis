package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "soorten")
public class Soort implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long soortNr;
	private String naam;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LandNr")
	private Land land;
	@OneToMany(mappedBy="soort")
	@OrderBy("naam")
	private Set<Wijn> wijnen;
	
	protected Soort() {}
	
	public Soort(String naam) {
		setNaam(naam);
	}

	public long getSoortNr() {
		return soortNr;
	}

	public String getNaam() {
		return naam;
	}

	public Land getLand() {
		return land;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setLand(Land land) {
		if (this.land != null && this.land.getSoorten().contains(this)) {
			this.land.removeSoort(this);
		}
		this.land = land;
		if (land != null && ! land.getSoorten().contains(this)) {
			land.addSoort(this);
		}
	}
	
	public Set<Wijn> getWijnen() {
		return Collections.unmodifiableSet(wijnen);
	}
	
	public void addWijn(Wijn wijn) {
		wijnen.add(wijn);
		if (wijn.getSoort() != this) {
			wijn.setSoort(this);
		}
	}
	
	public void removeWijn(Wijn wijn) {
		wijnen.remove(wijn);
		if (wijn.getSoort() == this) {
			wijn.setSoort(null);
		}
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
//		result = prime * result + (int) (soortNr ^ (soortNr >>> 32));
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Soort other = (Soort) obj;
//		if (naam == null) {
//			if (other.naam != null)
//				return false;
//		} else if (!naam.equals(other.naam))
//			return false;
//		if (soortNr != other.soortNr)
//			return false;
//		return true;
//	}
	
}