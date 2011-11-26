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
 * The persistent class for the AUASTME_MUUTUMINE database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@Table(name="AUASTME_MUUTUMINE")
public class AuastmeMuutumine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AUASTME_MUUTUMINE_ID")
	private Long auastmeMuutumineId;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date alates;

	private String avaja;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kommentaar;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date kuni;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to Auaste
    @ManyToOne
	@JoinColumn(name="AUASTE_ID")
	private Auaste auaste;

	//bi-directional many-to-one association to Piirivalvur
    @ManyToOne
	@JoinColumn(name="PIIRIVALVUR_ID")
	private Piirivalvur piirivalvur;

    public AuastmeMuutumine() {
    }

	public Long getAuastmeMuutumineId() {
		return this.auastmeMuutumineId;
	}

	public void setAuastmeMuutumineId(Long auastmeMuutumineId) {
		this.auastmeMuutumineId = auastmeMuutumineId;
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

	public Auaste getAuaste() {
		return this.auaste;
	}

	public void setAuaste(Auaste auaste) {
		this.auaste = auaste;
	}
	
	public Piirivalvur getPiirivalvur() {
		return this.piirivalvur;
	}

	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}
	
}