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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the KONTAKTI_LIIK database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@Table(name="KONTAKTI_LIIK")
public class KontaktiLiik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="KONTAKTI_LIIK_ID")
	private Long kontaktiLiikId;

	private String avaja;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kommentaar;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	private String nimetus;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	@Column(name="XML_KIRJELDUS")
	private String xmlKirjeldus;

	//bi-directional many-to-one association to PiirivalvuriKontakt
	@OneToMany(mappedBy="kontaktiLiik")
	private Set<PiirivalvuriKontakt> piirivalvuriKontakts;

    public KontaktiLiik() {
    }

	public Long getKontaktiLiikId() {
		return this.kontaktiLiikId;
	}

	public void setKontaktiLiikId(Long kontaktiLiikId) {
		this.kontaktiLiikId = kontaktiLiikId;
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

	public String getXmlKirjeldus() {
		return this.xmlKirjeldus;
	}

	public void setXmlKirjeldus(String xmlKirjeldus) {
		this.xmlKirjeldus = xmlKirjeldus;
	}

	public Set<PiirivalvuriKontakt> getPiirivalvuriKontakts() {
		return this.piirivalvuriKontakts;
	}

	public void setPiirivalvuriKontakts(Set<PiirivalvuriKontakt> piirivalvuriKontakts) {
		this.piirivalvuriKontakts = piirivalvuriKontakts;
	}
	
}