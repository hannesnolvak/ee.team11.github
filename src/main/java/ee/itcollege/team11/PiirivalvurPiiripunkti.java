package ee.itcollege.team11;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the PIIRIVALVUR_PIIRIPUNKTIS database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@Table(name="PIIRIVALVUR_PIIRIPUNKTIS")
public class PiirivalvurPiiripunkti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PIIRIVALVUR_PIIRIPUNKTIS_ID")
	private Long piirivalvurPiiripunktisId;

    @Temporal( TemporalType.DATE)
	private Date alates;

	private String avaja;

    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kommentaar;

	private BigDecimal koormus;

    @Temporal( TemporalType.DATE)
	private Date kuni;

    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to AmetPiiripunkti
    @ManyToOne
	@JoinColumn(name="AMET_PIIRIPUNKTIS_ID")
	private AmetPiiripunkti ametPiiripunkti;

	//bi-directional many-to-one association to Piirivalvur
    @ManyToOne
	@JoinColumn(name="PIIRIVALVUR_ID")
	private Piirivalvur piirivalvur;

    public PiirivalvurPiiripunkti() {
    }

	public Long getPiirivalvurPiiripunktisId() {
		return this.piirivalvurPiiripunktisId;
	}

	public void setPiirivalvurPiiripunktisId(Long piirivalvurPiiripunktisId) {
		this.piirivalvurPiiripunktisId = piirivalvurPiiripunktisId;
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

	public BigDecimal getKoormus() {
		return this.koormus;
	}

	public void setKoormus(BigDecimal koormus) {
		this.koormus = koormus;
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

	public AmetPiiripunkti getAmetPiiripunkti() {
		return this.ametPiiripunkti;
	}

	public void setAmetPiiripunkti(AmetPiiripunkti ametPiiripunkti) {
		this.ametPiiripunkti = ametPiiripunkti;
	}
	
	public Piirivalvur getPiirivalvur() {
		return this.piirivalvur;
	}

	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}
	
}