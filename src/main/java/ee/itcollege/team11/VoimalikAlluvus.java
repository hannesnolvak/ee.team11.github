package ee.itcollege.team11;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
 * The persistent class for the VOIMALIK_ALLUVUS database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@EntityListeners({
	LisatudListener.class,
	MuudetudListener.class
})
@Table(name="VOIMALIK_ALLUVUS")
public class VoimalikAlluvus extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VOIMALIK_ALLUVUS_ID")
	private Long voimalikAlluvusId;

	private String avaja;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kommentaar;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to RiigiAdminYksuseLiik
    @ManyToOne
	@JoinColumn(name="VOIMALIK_ALLUV_LIIK_ID")
	private RiigiAdminYksuseLiik riigiAdminYksuseLiik1;

	//bi-directional many-to-one association to RiigiAdminYksuseLiik
    @ManyToOne
	@JoinColumn(name="RIIGI_ADMIN_YKSUSE_LIK_ID")
	private RiigiAdminYksuseLiik riigiAdminYksuseLiik2;

    public VoimalikAlluvus() {
    }

	public Long getVoimalikAlluvusId() {
		return this.voimalikAlluvusId;
	}

	public void setVoimalikAlluvusId(Long voimalikAlluvusId) {
		this.voimalikAlluvusId = voimalikAlluvusId;
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

	public RiigiAdminYksuseLiik getRiigiAdminYksuseLiik1() {
		return this.riigiAdminYksuseLiik1;
	}

	public void setRiigiAdminYksuseLiik1(RiigiAdminYksuseLiik riigiAdminYksuseLiik1) {
		this.riigiAdminYksuseLiik1 = riigiAdminYksuseLiik1;
	}
	
	public RiigiAdminYksuseLiik getRiigiAdminYksuseLiik2() {
		return this.riigiAdminYksuseLiik2;
	}

	public void setRiigiAdminYksuseLiik2(RiigiAdminYksuseLiik riigiAdminYksuseLiik2) {
		this.riigiAdminYksuseLiik2 = riigiAdminYksuseLiik2;
	}
	
}