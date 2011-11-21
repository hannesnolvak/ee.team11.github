package ee.itcollege.team11;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the VAEOSA_ALLUVUS database table.
 * 
 */
@Entity
@Table(name="VAEOSA_ALLUVUS")
public class VaeosaAlluvus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VAEOSA_ALLUVUS_ID")
	private int vaeosaAlluvusId;

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

	//bi-directional many-to-one association to Vaeosa
    @ManyToOne
	@JoinColumn(name="ALLUVA_VAEOSA_ID")
	private Vaeosa vaeosa1;

	//bi-directional many-to-one association to Vaeosa
    @ManyToOne
	@JoinColumn(name="YLEMUS_VAEOSA_ID")
	private Vaeosa vaeosa2;

    public VaeosaAlluvus() {
    }

	public int getVaeosaAlluvusId() {
		return this.vaeosaAlluvusId;
	}

	public void setVaeosaAlluvusId(int vaeosaAlluvusId) {
		this.vaeosaAlluvusId = vaeosaAlluvusId;
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

	public Vaeosa getVaeosa1() {
		return this.vaeosa1;
	}

	public void setVaeosa1(Vaeosa vaeosa1) {
		this.vaeosa1 = vaeosa1;
	}
	
	public Vaeosa getVaeosa2() {
		return this.vaeosa2;
	}

	public void setVaeosa2(Vaeosa vaeosa2) {
		this.vaeosa2 = vaeosa2;
	}
	
}