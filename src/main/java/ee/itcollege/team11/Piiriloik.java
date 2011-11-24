package ee.itcollege.team11;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the PIIRILOIK database table.
 * 
 */
@Entity
@RooToString
@RooEntity
public class Piiriloik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PIIRILOIK_ID")
	private Long piiriloikId;

	private String avaja;

    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kood;

    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	private String nimetus;

    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to Intsident
	@OneToMany(mappedBy="piiriloik")
	private Set<Intsident> intsidents;

	//bi-directional many-to-one association to PiiriloiguHaldaja
	@OneToMany(mappedBy="piiriloik")
	private Set<PiiriloiguHaldaja> piiriloiguHaldajas;

	//bi-directional many-to-one association to VahtkonndPiiriloigul
	@OneToMany(mappedBy="piiriloik")
	private Set<VahtkonndPiiriloigul> vahtkonndPiiriloiguls;

    public Piiriloik() {
    }

	public Long getPiiriloikId() {
		return this.piiriloikId;
	}

	public void setPiiriloikId(Long piiriloikId) {
		this.piiriloikId = piiriloikId;
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

	public String getKood() {
		return this.kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
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

	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
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

	public Set<Intsident> getIntsidents() {
		return this.intsidents;
	}

	public void setIntsidents(Set<Intsident> intsidents) {
		this.intsidents = intsidents;
	}
	
	public Set<PiiriloiguHaldaja> getPiiriloiguHaldajas() {
		return this.piiriloiguHaldajas;
	}

	public void setPiiriloiguHaldajas(Set<PiiriloiguHaldaja> piiriloiguHaldajas) {
		this.piiriloiguHaldajas = piiriloiguHaldajas;
	}
	
	public Set<VahtkonndPiiriloigul> getVahtkonndPiiriloiguls() {
		return this.vahtkonndPiiriloiguls;
	}

	public void setVahtkonndPiiriloiguls(Set<VahtkonndPiiriloigul> vahtkonndPiiriloiguls) {
		this.vahtkonndPiiriloiguls = vahtkonndPiiriloiguls;
	}
	
}