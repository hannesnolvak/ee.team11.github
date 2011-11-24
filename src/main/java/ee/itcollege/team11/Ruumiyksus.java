package ee.itcollege.team11;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the RUUMIYKSUS database table.
 * 
 */
@Entity
@RooToString
@RooEntity
public class Ruumiyksus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RUUMIYKSUS_ID")
	private Long ruumiyksusId;

	private String aadress;

	private String avaja;

    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kommentaar;

	private String kood;

    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	private String nimetus;

    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to RiigiAdminYksus
    @ManyToOne
	@JoinColumn(name="RIIGI_ADMIN_YKSUS_ID")
	private RiigiAdminYksus riigiAdminYksus;

	//bi-directional many-to-one association to Ruumiyksus
    @ManyToOne
	@JoinColumn(name="YLEM_RUUMIYKSUS_ID")
	private Ruumiyksus ruumiyksus;

	//bi-directional many-to-one association to Ruumiyksus
	@OneToMany(mappedBy="ruumiyksus")
	private Set<Ruumiyksus> ruumiyksuses;

	//bi-directional many-to-one association to RuumiyksuseLiik
    @ManyToOne
	@JoinColumn(name="RUUMIYKSUSE_LIIK_ID")
	private RuumiyksuseLiik ruumiyksuseLiik;

	//bi-directional many-to-one association to Voodikoht
	@OneToMany(mappedBy="ruumiyksus")
	private Set<Voodikoht> voodikohts;

    public Ruumiyksus() {
    }

	public Long getRuumiyksusId() {
		return this.ruumiyksusId;
	}

	public void setRuumiyksusId(Long ruumiyksusId) {
		this.ruumiyksusId = ruumiyksusId;
	}

	public String getAadress() {
		return this.aadress;
	}

	public void setAadress(String aadress) {
		this.aadress = aadress;
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

	public String getKood() {
		return this.kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
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

	public RiigiAdminYksus getRiigiAdminYksus() {
		return this.riigiAdminYksus;
	}

	public void setRiigiAdminYksus(RiigiAdminYksus riigiAdminYksus) {
		this.riigiAdminYksus = riigiAdminYksus;
	}
	
	public Ruumiyksus getRuumiyksus() {
		return this.ruumiyksus;
	}

	public void setRuumiyksus(Ruumiyksus ruumiyksus) {
		this.ruumiyksus = ruumiyksus;
	}
	
	public Set<Ruumiyksus> getRuumiyksuses() {
		return this.ruumiyksuses;
	}

	public void setRuumiyksuses(Set<Ruumiyksus> ruumiyksuses) {
		this.ruumiyksuses = ruumiyksuses;
	}
	
	public RuumiyksuseLiik getRuumiyksuseLiik() {
		return this.ruumiyksuseLiik;
	}

	public void setRuumiyksuseLiik(RuumiyksuseLiik ruumiyksuseLiik) {
		this.ruumiyksuseLiik = ruumiyksuseLiik;
	}
	
	public Set<Voodikoht> getVoodikohts() {
		return this.voodikohts;
	}

	public void setVoodikohts(Set<Voodikoht> voodikohts) {
		this.voodikohts = voodikohts;
	}
	
}