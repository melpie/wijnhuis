package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "bestelbonnen")
public class BestelBon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long bonNr;
	@Temporal(TemporalType.TIMESTAMP)
	private Date bestelDatum;
	private String naam;
	private String straat;
	private String huisNr;
	private String postCode;
	private String gemeente;
	private int bestelwijze;
	@OneToMany(mappedBy="bestelBon")
	@OrderBy("wijnNr")
	private Set<BestelBonLijn> bestelBonLijnen;
	
	protected BestelBon() {}
	
	public BestelBon(Date bestelDatum, String naam, String straat, String huisNr, String postCode, String gemeente, int bestelwijze, Set<BestelBonLijn> bestelBonLijnen) {
		setBestelDatum(bestelDatum);
		setNaam(naam);
		setStraat(straat);
		setHuisNr(huisNr);
		setPostCode(postCode);
		setGemeente(gemeente);
		setBestelwijze(bestelwijze);
		for (BestelBonLijn b : bestelBonLijnen) { 
			addBestelBonLijn(b);
		}
	}
	
	public BestelBon(Date bestelDatum, String naam, String straat, String huisNr, String postCode, String gemeente, int bestelwijze) {
		setBestelDatum(bestelDatum);
		setNaam(naam);
		setStraat(straat);
		setHuisNr(huisNr);
		setPostCode(postCode);
		setGemeente(gemeente);
		setBestelwijze(bestelwijze);
		bestelBonLijnen = new LinkedHashSet<BestelBonLijn>();
	}
	
	
	public long getBonNr() {
		return bonNr;
	}
	
	public Date getBestelDatum() {
		return bestelDatum;
	}
	
	public void setBestelDatum(Date bestelDatum) {
		this.bestelDatum = bestelDatum;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public String getStraat() {
		return straat;
	}
	
	public void setStraat(String straat) {
		this.straat = straat;
	}
	
	public String getHuisNr() {
		return huisNr;
	}
	
	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public String getGemeente() {
		return gemeente;
	}
	
	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
	
	public int getBestelwijze() {
		return bestelwijze;
	}
	
	public void setBestelwijze(int bestelwijze) {
		this.bestelwijze = bestelwijze;
	}
	
	public Set<BestelBonLijn> getBestelBonLijnen() {
		return Collections.unmodifiableSet(bestelBonLijnen);
	}
	
	public void addBestelBonLijn(BestelBonLijn bestelBonLijn) {
		bestelBonLijnen.add(bestelBonLijn);
		if (bestelBonLijn.getBestelBon() != this) {
			bestelBonLijn.setBestelBon(this);
		}
	}
	
	public void removeBestelBonLijn(BestelBonLijn bestelBonLijn) {
		bestelBonLijnen.remove(bestelBonLijn);
		if (bestelBonLijn.getBestelBon() == this) {
			bestelBonLijn.setBestelBon(null);
		}
	}
	
	

}
