package ee.itcollege.team11;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ISIKU_SEADUS_INTSIDENDIS database table.
 * 
 */
@Entity
@Table(name="ISIKU_SEADUS_INTSIDENDIS")
public class IsikuSeadusIntsidendi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ISIKU_SEADUS_INTSIDENDIS_ID")
	private int isikuSeadusIntsidendisId;

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

	//bi-directional many-to-one association to IsikIntsidendi
    @ManyToOne
	@JoinColumn(name="ISIK_INTSIDENDIS_ID")
	private IsikIntsidendi isikIntsidendi;

	//bi-directional many-to-one association to SeadusePunkt
    @ManyToOne
	@JoinColumn(name="SEADUSE_PUNKT_ID")
	private SeadusePunkt seadusePunkt;

    public IsikuSeadusIntsidendi() {
    }

	public int getIsikuSeadusIntsidendisId() {
		return this.isikuSeadusIntsidendisId;
	}

	public void setIsikuSeadusIntsidendisId(int isikuSeadusIntsidendisId) {
		this.isikuSeadusIntsidendisId = isikuSeadusIntsidendisId;
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

	public IsikIntsidendi getIsikIntsidendi() {
		return this.isikIntsidendi;
	}

	public void setIsikIntsidendi(IsikIntsidendi isikIntsidendi) {
		this.isikIntsidendi = isikIntsidendi;
	}
	
	public SeadusePunkt getSeadusePunkt() {
		return this.seadusePunkt;
	}

	public void setSeadusePunkt(SeadusePunkt seadusePunkt) {
		this.seadusePunkt = seadusePunkt;
	}
	
}