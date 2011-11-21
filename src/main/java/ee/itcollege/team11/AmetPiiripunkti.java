package ee.itcollege.team11;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the AMET_PIIRIPUNKTIS database table.
 * 
 */
@Entity
@Table(name="AMET_PIIRIPUNKTIS")
public class AmetPiiripunkti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AMET_PIIRIPUNKTIS_ID")
	private int ametPiiripunktisId;

    @Temporal( TemporalType.DATE)
	private Date alates;

	private String avaja;

    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kommentaar;

    @Temporal( TemporalType.DATE)
	private Date kuni;

    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to Amet
    @ManyToOne
	@JoinColumn(name="AMET_ID")
	private Amet amet;

	//bi-directional many-to-one association to Piiripunkt
    @ManyToOne
	@JoinColumn(name="PIIRIPUNKT_ID")
	private Piiripunkt piiripunkt;

	//bi-directional many-to-one association to PiirivalvurPiiripunkti
	@OneToMany(mappedBy="ametPiiripunkti")
	private Set<PiirivalvurPiiripunkti> piirivalvurPiiripunktis;

    public AmetPiiripunkti() {
    }

	public int getAmetPiiripunktisId() {
		return this.ametPiiripunktisId;
	}

	public void setAmetPiiripunktisId(int ametPiiripunktisId) {
		this.ametPiiripunktisId = ametPiiripunktisId;
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

	public Amet getAmet() {
		return this.amet;
	}

	public void setAmet(Amet amet) {
		this.amet = amet;
	}
	
	public Piiripunkt getPiiripunkt() {
		return this.piiripunkt;
	}

	public void setPiiripunkt(Piiripunkt piiripunkt) {
		this.piiripunkt = piiripunkt;
	}
	
	public Set<PiirivalvurPiiripunkti> getPiirivalvurPiiripunktis() {
		return this.piirivalvurPiiripunktis;
	}

	public void setPiirivalvurPiiripunktis(Set<PiirivalvurPiiripunkti> piirivalvurPiiripunktis) {
		this.piirivalvurPiiripunktis = piirivalvurPiiripunktis;
	}
	
}