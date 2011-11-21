package ee.itcollege.team11;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the SEADUSE_PUNKT database table.
 * 
 */
@Entity
@Table(name="SEADUSE_PUNKT")
public class SeadusePunkt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEADUSE_PUNKT_ID")
	private int seadusePunktId;

	private String avaja;

    @Temporal( TemporalType.DATE)
	private Date avatud;

	@Column(name="KEHTIV_ALATES")
	private String kehtivAlates;

	@Column(name="KEHTIV_KUNI")
	private String kehtivKuni;

	private String kommentaar;

    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	private String pais;

	private String paragrahv;

    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	private String tekst;

	//bi-directional many-to-one association to Seadus
    @ManyToOne
	@JoinColumn(name="SEADUSE_ID")
	private Seadus seadus;

	//bi-directional many-to-one association to SeadusePunkt
    @ManyToOne
	@JoinColumn(name="YLEMUS_SEADUSE_PUNKT_ID")
	private SeadusePunkt seadusePunkt;

	//bi-directional many-to-one association to SeadusePunkt
	@OneToMany(mappedBy="seadusePunkt")
	private Set<SeadusePunkt> seadusePunkts;

	//bi-directional many-to-one association to IsikuSeadusIntsidendi
	@OneToMany(mappedBy="seadusePunkt")
	private Set<IsikuSeadusIntsidendi> isikuSeadusIntsidendis;

	//bi-directional many-to-one association to ObjektiSeadusIntsidendi
	@OneToMany(mappedBy="seadusePunkt")
	private Set<ObjektiSeadusIntsidendi> objektiSeadusIntsidendis;

	//bi-directional many-to-one association to PiirivalvuriSeadusIntsidendi
	@OneToMany(mappedBy="seadusePunkt")
	private Set<PiirivalvuriSeadusIntsidendi> piirivalvuriSeadusIntsidendis;

    public SeadusePunkt() {
    }

	public int getSeadusePunktId() {
		return this.seadusePunktId;
	}

	public void setSeadusePunktId(int seadusePunktId) {
		this.seadusePunktId = seadusePunktId;
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

	public String getKehtivAlates() {
		return this.kehtivAlates;
	}

	public void setKehtivAlates(String kehtivAlates) {
		this.kehtivAlates = kehtivAlates;
	}

	public String getKehtivKuni() {
		return this.kehtivKuni;
	}

	public void setKehtivKuni(String kehtivKuni) {
		this.kehtivKuni = kehtivKuni;
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

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getParagrahv() {
		return this.paragrahv;
	}

	public void setParagrahv(String paragrahv) {
		this.paragrahv = paragrahv;
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

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Seadus getSeadus() {
		return this.seadus;
	}

	public void setSeadus(Seadus seadus) {
		this.seadus = seadus;
	}
	
	public SeadusePunkt getSeadusePunkt() {
		return this.seadusePunkt;
	}

	public void setSeadusePunkt(SeadusePunkt seadusePunkt) {
		this.seadusePunkt = seadusePunkt;
	}
	
	public Set<SeadusePunkt> getSeadusePunkts() {
		return this.seadusePunkts;
	}

	public void setSeadusePunkts(Set<SeadusePunkt> seadusePunkts) {
		this.seadusePunkts = seadusePunkts;
	}
	
	public Set<IsikuSeadusIntsidendi> getIsikuSeadusIntsidendis() {
		return this.isikuSeadusIntsidendis;
	}

	public void setIsikuSeadusIntsidendis(Set<IsikuSeadusIntsidendi> isikuSeadusIntsidendis) {
		this.isikuSeadusIntsidendis = isikuSeadusIntsidendis;
	}
	
	public Set<ObjektiSeadusIntsidendi> getObjektiSeadusIntsidendis() {
		return this.objektiSeadusIntsidendis;
	}

	public void setObjektiSeadusIntsidendis(Set<ObjektiSeadusIntsidendi> objektiSeadusIntsidendis) {
		this.objektiSeadusIntsidendis = objektiSeadusIntsidendis;
	}
	
	public Set<PiirivalvuriSeadusIntsidendi> getPiirivalvuriSeadusIntsidendis() {
		return this.piirivalvuriSeadusIntsidendis;
	}

	public void setPiirivalvuriSeadusIntsidendis(Set<PiirivalvuriSeadusIntsidendi> piirivalvuriSeadusIntsidendis) {
		this.piirivalvuriSeadusIntsidendis = piirivalvuriSeadusIntsidendis;
	}
	
}