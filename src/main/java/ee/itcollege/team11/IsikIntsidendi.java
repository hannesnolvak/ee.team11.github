package ee.itcollege.team11;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the ISIK_INTSIDENDIS database table.
 * 
 */
@RooToString
@RooEntity
@Table(name="ISIK_INTSIDENDIS")
public class IsikIntsidendi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ISIK_INTSIDENDIS_ID")
	private int isikIntsidendisId;

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

	//bi-directional many-to-one association to IsikuSeadusIntsidendi
	@OneToMany(mappedBy="isikIntsidendi")
	private Set<IsikuSeadusIntsidendi> isikuSeadusIntsidendis;

	//bi-directional many-to-one association to Intsident
    @ManyToOne
	@JoinColumn(name="INTSIDENT_ID")
	private Intsident intsident;

	//bi-directional many-to-one association to Piiririkkuja
    @ManyToOne
	@JoinColumn(name="PIIRIRIKKUJA_ID")
	private Piiririkkuja piiririkkuja;

    public IsikIntsidendi() {
    }

	public int getIsikIntsidendisId() {
		return this.isikIntsidendisId;
	}

	public void setIsikIntsidendisId(int isikIntsidendisId) {
		this.isikIntsidendisId = isikIntsidendisId;
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

	public Set<IsikuSeadusIntsidendi> getIsikuSeadusIntsidendis() {
		return this.isikuSeadusIntsidendis;
	}

	public void setIsikuSeadusIntsidendis(Set<IsikuSeadusIntsidendi> isikuSeadusIntsidendis) {
		this.isikuSeadusIntsidendis = isikuSeadusIntsidendis;
	}
	
	public Intsident getIntsident() {
		return this.intsident;
	}

	public void setIntsident(Intsident intsident) {
		this.intsident = intsident;
	}
	
	public Piiririkkuja getPiiririkkuja() {
		return this.piiririkkuja;
	}

	public void setPiiririkkuja(Piiririkkuja piiririkkuja) {
		this.piiririkkuja = piiririkkuja;
	}
	
}