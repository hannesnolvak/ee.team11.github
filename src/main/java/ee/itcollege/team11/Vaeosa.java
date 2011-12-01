package ee.itcollege.team11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the VAEOSA database table.
 * 
 */
@Entity
@RooToString
@RooEntity
public class Vaeosa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VAEOSA_ID_ID")
	private Long vaeosaIdId;

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
    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	private String nimetus;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	private String kommentaar;

	
	//bi-directional many-to-one association to RiigiAdminYksus
    @ManyToOne
	@JoinColumn(name="RIIGI_ADMIN_YKSUS_ID")
	private RiigiAdminYksus riigiAdminYksus;

	//bi-directional many-to-one association to AmetVaeosa
	@OneToMany(mappedBy="vaeosa")
	private Set<AmetVaeosa> ametVaeosas;

	//bi-directional many-to-one association to OrgYksus
	@OneToMany(mappedBy="vaeosa")
	private Set<OrgYksus> orgYksuses;

	//bi-directional many-to-one association to PiiriloiguHaldaja
	@OneToMany(mappedBy="vaeosa")
	private Set<PiiriloiguHaldaja> piiriloiguHaldajas;

	//bi-directional many-to-one association to PiiripunktiAlluvus
	@OneToMany(mappedBy="vaeosa")
	private Set<PiiripunktiAlluvus> piiripunktiAlluvuses;

	//bi-directional many-to-one association to VaeosaAlluvus
	@OneToMany(mappedBy="vaeosa1")
	private Set<VaeosaAlluvus> vaeosaAlluvuses1;

	//bi-directional many-to-one association to VaeosaAlluvus
	@OneToMany(mappedBy="vaeosa2")
	private Set<VaeosaAlluvus> vaeosaAlluvuses2;

	//bi-directional many-to-one association to Vahtkond
	@OneToMany(mappedBy="vaeosa")
	private Set<Vahtkond> vahtkonds;

	
	
	
	
    public Vaeosa() {
    }

	

	
	public static List<Vaeosa> findAlluvadVaeosadByVaeosa(Long vaeosaIdId) {
		Vaeosa vaeosa = Vaeosa.findVaeosa(vaeosaIdId);
		List<Vaeosa> alluvadVaeosad = new ArrayList<Vaeosa>(); 
		
		for (VaeosaAlluvus va : VaeosaAlluvus.findAllVaeosaAlluvuses())
		{
			if (va.getVaeosa1() == vaeosa)
			{
				alluvadVaeosad.add(va.getVaeosa2());
			}
			
		}
		return alluvadVaeosad;
    }
	
	
    
    public Long getVaeosaIdId() {
		return this.vaeosaIdId;
	}

	public void setVaeosaIdId(Long vaeosaIdId) {
		this.vaeosaIdId = vaeosaIdId;
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

	public RiigiAdminYksus getRiigiAdminYksus() {
		return this.riigiAdminYksus;
	}

	public void setRiigiAdminYksus(RiigiAdminYksus riigiAdminYksus) {
		this.riigiAdminYksus = riigiAdminYksus;
	}
	
	public Set<AmetVaeosa> getAmetVaeosas() {
		return this.ametVaeosas;
	}

	public void setAmetVaeosas(Set<AmetVaeosa> ametVaeosas) {
		this.ametVaeosas = ametVaeosas;
	}
	
	public Set<OrgYksus> getOrgYksuses() {
		return this.orgYksuses;
	}

	public void setOrgYksuses(Set<OrgYksus> orgYksuses) {
		this.orgYksuses = orgYksuses;
	}
	
	public Set<PiiriloiguHaldaja> getPiiriloiguHaldajas() {
		return this.piiriloiguHaldajas;
	}

	public void setPiiriloiguHaldajas(Set<PiiriloiguHaldaja> piiriloiguHaldajas) {
		this.piiriloiguHaldajas = piiriloiguHaldajas;
	}
	
	public Set<PiiripunktiAlluvus> getPiiripunktiAlluvuses() {
		return this.piiripunktiAlluvuses;
	}

	public void setPiiripunktiAlluvuses(Set<PiiripunktiAlluvus> piiripunktiAlluvuses) {
		this.piiripunktiAlluvuses = piiripunktiAlluvuses;
	}
	
	public Set<VaeosaAlluvus> getVaeosaAlluvuses1() {
		return this.vaeosaAlluvuses1;
	}

	public void setVaeosaAlluvuses1(Set<VaeosaAlluvus> vaeosaAlluvuses1) {
		
		if (vaeosaAlluvuses1 == null)
		{
			this.vaeosaAlluvuses1 = new HashSet<VaeosaAlluvus>();
		} else
		{
			this.vaeosaAlluvuses1 = vaeosaAlluvuses1;
		}

		System.out.println("Salvestatakse v2eosa: " + this.getNimetus());
		
		for (VaeosaAlluvus va : this.vaeosaAlluvuses1) {
	
			va.getVaeosa1();
			System.out.println("this.alluvses1 l2bi k2imine v2eosa1: " + va.getVaeosa1().getNimetus());
			System.out.println("this.alluvses1 l2bi k2imine v2eosa2: " + va.getVaeosa2().getNimetus());
			
			if (va.getVaeosa1() != this)
			{
				System.out.println("v2eosa2 ei olnud this - ta seatakse selleks");

				va.setVaeosa1(this);
			}
		}	
	}
	
	public Set<VaeosaAlluvus> getVaeosaAlluvuses2() {
		return this.vaeosaAlluvuses2;
	}

	public void setVaeosaAlluvuses2(Set<VaeosaAlluvus> vaeosaAlluvuses2) {
		if (vaeosaAlluvuses2 == null)
		{
			this.vaeosaAlluvuses2 = new HashSet<VaeosaAlluvus>();
		} else
		{
			this.vaeosaAlluvuses2 = vaeosaAlluvuses2;
		}
/*
		for (VaeosaAlluvus v : this.vaeosaAlluvuses2) {
			if (v.getVaeosa2() != this)
			{
				v.setVaeosa2(this);
			}
		}	
*/		
	}
	
	public Set<Vahtkond> getVahtkonds() {
		return this.vahtkonds;
	}

	public void setVahtkonds(Set<Vahtkond> vahtkonds) {
		this.vahtkonds = vahtkonds;
	}




	public String getKommentaar() {
		return kommentaar;
	}




	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}
	
}