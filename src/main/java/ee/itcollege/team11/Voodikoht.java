package ee.itcollege.team11;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the VOODIKOHT database table.
 * 
 */
@Entity
@RooToString
@RooEntity
public class Voodikoht implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VOODIKOHT_ID")
	private Long voodikohtId;

	private String avaja;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kommentaar;

	private int laius;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	private String number;

	private int pikkus;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to PiirivalvurVodikohal
	@OneToMany(mappedBy="voodikoht")
	private Set<PiirivalvurVodikohal> piirivalvurVodikohals;

	//bi-directional many-to-one association to Ruumiyksus
    @ManyToOne
	@JoinColumn(name="RUUMIYKSUS_ID")
	private Ruumiyksus ruumiyksus;

    public Voodikoht() {
    }

	public Long getVoodikohtId() {
		return this.voodikohtId;
	}

	public void setVoodikohtId(Long voodikohtId) {
		this.voodikohtId = voodikohtId;
	}

	public String getAvaja() {
		return this.avaja;
	}

	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	public Date getAvatud() {
		return this.avatud;
	}

	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public int getLaius() {
		return this.laius;
	}

	public void setLaius(int laius) {
		this.laius = laius;
	}

	public Date getMuudetud() {
		return this.muudetud;
	}

	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	public String getMuutja() {
		return this.muutja;
	}

	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getPikkus() {
		return this.pikkus;
	}

	public void setPikkus(int pikkus) {
		this.pikkus = pikkus;
	}

	public Date getSuletud() {
		return this.suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}

	public String getSulgeja() {
		return this.sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	public Set<PiirivalvurVodikohal> getPiirivalvurVodikohals() {
		return this.piirivalvurVodikohals;
	}

	public void setPiirivalvurVodikohals(Set<PiirivalvurVodikohal> piirivalvurVodikohals) {
		this.piirivalvurVodikohals = piirivalvurVodikohals;
	}
	
	public Ruumiyksus getRuumiyksus() {
		return this.ruumiyksus;
	}

	public void setRuumiyksus(Ruumiyksus ruumiyksus) {
		this.ruumiyksus = ruumiyksus;
	}
	
}