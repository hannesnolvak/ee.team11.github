package ee.itcollege.team11;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the KODAKONDSUS database table.
 * 
 */
@Entity
@RooToString
@RooEntity
public class Kodakondsus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="KODAKONDSUS_ID")
	private Long kodakondsusId;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date alates;

	private String avaja;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String isikukood;

	private String kommentaar;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date kuni;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to Piiririkkuja
    @ManyToOne
	@JoinColumn(name="PIIRIRIKKUJA_ID")
	private Piiririkkuja piiririkkuja;

	//bi-directional many-to-one association to Riik
    @ManyToOne
	@JoinColumn(name="RIIK_ID")
	private Riik riik;

    public Kodakondsus() {
    }

	public Long getKodakondsusId() {
		return this.kodakondsusId;
	}

	public void setKodakondsusId(Long kodakondsusId) {
		this.kodakondsusId = kodakondsusId;
	}

	public Date getAlates() {
		return this.alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
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

	public String getIsikukood() {
		return this.isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public Date getKuni() {
		return this.kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
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

	public Piiririkkuja getPiiririkkuja() {
		return this.piiririkkuja;
	}

	public void setPiiririkkuja(Piiririkkuja piiririkkuja) {
		this.piiririkkuja = piiririkkuja;
	}
	
	public Riik getRiik() {
		return this.riik;
	}

	public void setRiik(Riik riik) {
		this.riik = riik;
	}
	
}