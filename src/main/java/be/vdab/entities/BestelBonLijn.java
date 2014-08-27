package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bestelbonlijnen")
public class BestelBonLijn implements Serializable {
	private static final long serialVersionUID = 1L;
	int aantal;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BonNr")
	private BestelBon bestelBon;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WijnNr")
	private Wijn wijn;
	
	protected BestelBonLijn() {}
	
	public BestelBonLijn(int aantal, Wijn wijn, BestelBon bestelBon) {
		setAantal(aantal);
		setWijn(wijn);
		setBestelBon(bestelBon);
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public BestelBon getBestelBon() {
		return bestelBon;
	}

	public void setBestelBon(BestelBon bestelBon) {
		if (this.bestelBon != null && this.bestelBon.getBestelBonLijnen().contains(this)) {
			this.bestelBon.removeBestelBonLijn(this);
		}
		this.bestelBon = bestelBon;
		if (bestelBon != null && ! bestelBon.getBestelBonLijnen().contains(this)) {
			bestelBon.addBestelBonLijn(this);
		}
	}

	public Wijn getWijn() {
		return wijn;
	}

	public void setWijn(Wijn wijn) {
		if (this.wijn != null && this.wijn.getBestelBonLijnen().contains(this)) {
			this.wijn.removeBestelBonLijn(this);
		}
		this.wijn = wijn;
		if (wijn != null && ! wijn.getBestelBonLijnen().contains(this)) {
			wijn.addBestelBonLijn(this);
		}
	}
	
}
