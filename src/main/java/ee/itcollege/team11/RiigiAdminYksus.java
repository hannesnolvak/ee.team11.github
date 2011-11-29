package ee.itcollege.team11;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the RIIGI_ADMIN_YKSUS database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@EntityListeners({
	LisatudListener.class,
	MuudetudListener.class,
	SuletudListener.class
})
@Table(name="RIIGI_ADMIN_YKSUS")
public class RiigiAdminYksus implements Serializable, Creatable, Updatable, Deletable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RIIGI_ADMIN_YKSUS_ID")
	private Long riigiAdminYksusId;
	
	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date alates;

	private String avaja;
	
	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kood;
	
	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date kuni;

	@DateTimeFormat(style="M-")
	private Date muudetud;

	private String muutja;

	private String nimetus;
	
	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to AdminAlluvus
	@OneToMany(mappedBy="riigiAdminYksus1")
	private Set<AdminAlluvus> adminAlluvuses1;

	//bi-directional many-to-one association to AdminAlluvus
	@OneToMany(mappedBy="riigiAdminYksus2")
	private Set<AdminAlluvus> adminAlluvuses2;

	//bi-directional many-to-one association to RiigiAdminYksuseLiik
    @ManyToOne
	@JoinColumn(name="RIIGI_ADMIN_YKSUSE_LIK_ID")
	private RiigiAdminYksuseLiik riigiAdminYksuseLiik;

	//bi-directional many-to-one association to Vaeosa
	@OneToMany(mappedBy="riigiAdminYksus")
	private Set<Vaeosa> vaeosas;

	//bi-directional many-to-one association to Ruumiyksus
	@OneToMany(mappedBy="riigiAdminYksus")
	private Set<Ruumiyksus> ruumiyksuses;

    public RiigiAdminYksus() {
    }

	public Long getRiigiAdminYksusId() {
		return this.riigiAdminYksusId;
	}

	public void setRiigiAdminYksusId(Long riigiAdminYksusId) {
		this.riigiAdminYksusId = riigiAdminYksusId;
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

	public String getKood() {
		return this.kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
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

	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
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

	public Set<AdminAlluvus> getAdminAlluvuses1() {
		return this.adminAlluvuses1;
	}

	public void setAdminAlluvuses1(Set<AdminAlluvus> adminAlluvuses1) {
		this.adminAlluvuses1 = adminAlluvuses1;
	}
	
	public Set<AdminAlluvus> getAdminAlluvuses2() {
		return this.adminAlluvuses2;
	}

	public void setAdminAlluvuses2(Set<AdminAlluvus> adminAlluvuses2) {
		this.adminAlluvuses2 = adminAlluvuses2;
	}
	
	public RiigiAdminYksuseLiik getRiigiAdminYksuseLiik() {
		return this.riigiAdminYksuseLiik;
	}

	public void setRiigiAdminYksuseLiik(RiigiAdminYksuseLiik riigiAdminYksuseLiik) {
		this.riigiAdminYksuseLiik = riigiAdminYksuseLiik;
	}
	
	public Set<Vaeosa> getVaeosas() {
		return this.vaeosas;
	}

	public void setVaeosas(Set<Vaeosa> vaeosas) {
		this.vaeosas = vaeosas;
	}
	
	public Set<Ruumiyksus> getRuumiyksuses() {
		return this.ruumiyksuses;
	}

	public void setRuumiyksuses(Set<Ruumiyksus> ruumiyksuses) {
		this.ruumiyksuses = ruumiyksuses;
	}
	
}