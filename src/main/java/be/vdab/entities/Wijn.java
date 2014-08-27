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
@Table(name = "wijnen")
public class Wijn implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long wijnNr;
	private int jaar;
	private int beoordeling;
	private double prijs;
	private int inBestelling;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SoortNr")
	private Soort soort;
	@OneToMany(mappedBy="wijn")
	@OrderBy("bonNr")
	private Set<BestelBonLijn> bestelBonLijnen;
	
	protected Wijn() {}
	
	public Wijn(int jaar, int beoordeling, double prijs, int inBestelling) {
		setJaar(jaar);
		setBeoordeling(beoordeling);
		setPrijs(prijs);
		setInBestelling(inBestelling);
		setSoort(soort);
		for (BestelBonLijn b : bestelBonLijnen) { 
			addBestelBonLijn(b);
		}
	}
	
	

	public long getWijnNr() {
		return wijnNr;
	}

	public int getJaar() {
		return jaar;
	}

	public int getBeoordeling() {
		return beoordeling;
	}

	public double getPrijs() {
		return prijs;
	}

	public int getInBestelling() {
		return inBestelling;
	}

	public Soort getSoort() {
		return soort;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public void setBeoordeling(int beoordeling) {
		this.beoordeling = beoordeling;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public void setInBestelling(int inBestelling) {
		this.inBestelling = inBestelling;
	}

	public void setSoort(Soort soort) {
		this.soort = soort;
		if (this.soort != null && this.soort.getWijnen().contains(this)) {
			this.soort.removeWijn(this);
		}
		this.soort = soort;
		if (soort != null && ! soort.getWijnen().contains(this)) {
			soort.addWijn(this);
		}
	}
	
	public Set<BestelBonLijn> getBestelBonLijnen() {
		return Collections.unmodifiableSet(bestelBonLijnen);
	}
	
	public void addBestelBonLijn(BestelBonLijn bestelBonLijn) {
		bestelBonLijnen.add(bestelBonLijn);
		if (bestelBonLijn.getWijn() != this) {
			bestelBonLijn.setWijn(this);
		}
	}
	
	public void removeBestelBonLijn(BestelBonLijn bestelBonLijn) {
		bestelBonLijnen.remove(bestelBonLijn);
		if (bestelBonLijn.getWijn() == this) {
			bestelBonLijn.setWijn(null);
		}
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + beoordeling;
//		result = prime * result + inBestelling;
//		result = prime * result + jaar;
//		long temp;
//		temp = Double.doubleToLongBits(prijs);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		result = prime * result + ((soort == null) ? 0 : soort.hashCode());
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
//		Wijn other = (Wijn) obj;
//		if (beoordeling != other.beoordeling)
//			return false;
//		if (inBestelling != other.inBestelling)
//			return false;
//		if (jaar != other.jaar)
//			return false;
//		if (Double.doubleToLongBits(prijs) != Double
//				.doubleToLongBits(other.prijs))
//			return false;
//		if (soort == null) {
//			if (other.soort != null)
//				return false;
//		} else if (!soort.equals(other.soort))
//			return false;
//		return true;
//	}	
	
}