package ee.itcollege.team11;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the OBJEKT_INTSIDENDIS database table.
 * 
 */
@RooToString
@RooEntity
@Table(name="OBJEKT_INTSIDENDIS")
public class ObjektIntsidendi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OBJEKT_INTSIDENDIS_ID")
	private int objektIntsidendisId;

    @Temporal( TemporalType.DATE)
	private Date alates;

	private String avaja;

    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kirjeldus;

	private String kommentaar;

    @Temporal( TemporalType.DATE)
	private Date kuni;

    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to ObjektiSeadusIntsidendi
	@OneToMany(mappedBy="objektIntsidendi")
	private Set<ObjektiSeadusIntsidendi> objektiSeadusIntsidendis;

	//bi-directional many-to-one association to Intsident
    @ManyToOne
	@JoinColumn(name="INTSIDENT_ID")
	private Intsident intsident;

	//bi-directional many-to-one association to Objekt
    @ManyToOne
	@JoinColumn(name="OBJEKT_ID")
	private Objekt objekt;

    public ObjektIntsidendi() {
    }

	public int getObjektIntsidendisId() {
		return this.objektIntsidendisId;
	}

	public void setObjektIntsidendisId(int objektIntsidendisId) {
		this.objektIntsidendisId = objektIntsidendisId;
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

	public String getKirjeldus() {
		return this.kirjeldus;
	}

	public void setKirjeldus(String kirjeldus) {
		this.kirjeldus = kirjeldus;
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

	public Set<ObjektiSeadusIntsidendi> getObjektiSeadusIntsidendis() {
		return this.objektiSeadusIntsidendis;
	}

	public void setObjektiSeadusIntsidendis(Set<ObjektiSeadusIntsidendi> objektiSeadusIntsidendis) {
		this.objektiSeadusIntsidendis = objektiSeadusIntsidendis;
	}
	
	public Intsident getIntsident() {
		return this.intsident;
	}

	public void setIntsident(Intsident intsident) {
		this.intsident = intsident;
	}
	
	public Objekt getObjekt() {
		return this.objekt;
	}

	public void setObjekt(Objekt objekt) {
		this.objekt = objekt;
	}
	
}