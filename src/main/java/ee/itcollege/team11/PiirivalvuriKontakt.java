package ee.itcollege.team11;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.Date;


/**
 * The persistent class for the PIIRIVALVURI_KONTAKT database table.
 * 
 */
@RooToString
@RooEntity
@Table(name="PIIRIVALVURI_KONTAKT")
public class PiirivalvuriKontakt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PIIRIVALVURI_KONTAKT_ID")
	private int piirivalvuriKontaktId;

    @Temporal( TemporalType.DATE)
	private Date alates;

	private String avaja;

    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kommentaar;

	private String kontakt;

    @Temporal( TemporalType.DATE)
	private Date kuni;

    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	@Column(name="PEAMINE_KONTAKT")
	private String peamineKontakt;

    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to KontaktiLiik
    @ManyToOne
	@JoinColumn(name="KONTAKTI_LIIK_ID")
	private KontaktiLiik kontaktiLiik;

	//bi-directional many-to-one association to Piirivalvur
    @ManyToOne
	@JoinColumn(name="PIIRIVALVUR_ID")
	private Piirivalvur piirivalvur;

    public PiirivalvuriKontakt() {
    }

	public int getPiirivalvuriKontaktId() {
		return this.piirivalvuriKontaktId;
	}

	public void setPiirivalvuriKontaktId(int piirivalvuriKontaktId) {
		this.piirivalvuriKontaktId = piirivalvuriKontaktId;
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

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public String getKontakt() {
		return this.kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
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

	public String getPeamineKontakt() {
		return this.peamineKontakt;
	}

	public void setPeamineKontakt(String peamineKontakt) {
		this.peamineKontakt = peamineKontakt;
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

	public KontaktiLiik getKontaktiLiik() {
		return this.kontaktiLiik;
	}

	public void setKontaktiLiik(KontaktiLiik kontaktiLiik) {
		this.kontaktiLiik = kontaktiLiik;
	}
	
	public Piirivalvur getPiirivalvur() {
		return this.piirivalvur;
	}

	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}
	
}