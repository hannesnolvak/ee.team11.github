package ee.itcollege.team11;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.Date;


/**
 * The persistent class for the PIIRIVALVUR_VODIKOHAL database table.
 * 
 */
@RooToString
@RooEntity
@Table(name="PIIRIVALVUR_VODIKOHAL")
public class PiirivalvurVodikohal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"_ID\"")
	private int id;

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

	//bi-directional many-to-one association to Piirivalvur
    @ManyToOne
	@JoinColumn(name="PIIRIVALVUR_ID")
	private Piirivalvur piirivalvur;

	//bi-directional many-to-one association to Voodikoht
    @ManyToOne
	@JoinColumn(name="VOODIKOHT_ID")
	private Voodikoht voodikoht;

    public PiirivalvurVodikohal() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Piirivalvur getPiirivalvur() {
		return this.piirivalvur;
	}

	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}
	
	public Voodikoht getVoodikoht() {
		return this.voodikoht;
	}

	public void setVoodikoht(Voodikoht voodikoht) {
		this.voodikoht = voodikoht;
	}
	
}