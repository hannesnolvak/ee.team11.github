package ee.itcollege.team11;

import java.io.Serializable;
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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the VAHTKONNA_LIIGE database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@Table(name="VAHTKONNA_LIIGE")
public class VahtkonnaLiige implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VAHTKONNA_LIIGE_ID")
	private Long vahtkonnaLiigeId;

	private String alates;

	private String avaja;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kommentaar;

	private String kuni;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to Piirivalvur
    @ManyToOne
	@JoinColumn(name="PIIRIVALVUR_ID")
	private Piirivalvur piirivalvur;

	//bi-directional many-to-one association to Vahtkond
    @ManyToOne
	@JoinColumn(name="VAHTKOND_ID")
	private Vahtkond vahtkond;

    public VahtkonnaLiige() {
    }

	public Long getVahtkonnaLiigeId() {
		return this.vahtkonnaLiigeId;
	}

	public void setVahtkonnaLiigeId(Long vahtkonnaLiigeId) {
		this.vahtkonnaLiigeId = vahtkonnaLiigeId;
	}

	public String getAlates() {
		return this.alates;
	}

	public void setAlates(String alates) {
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

	public String getKuni() {
		return this.kuni;
	}

	public void setKuni(String kuni) {
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
	
	public Vahtkond getVahtkond() {
		return this.vahtkond;
	}

	public void setVahtkond(Vahtkond vahtkond) {
		this.vahtkond = vahtkond;
	}
	
}