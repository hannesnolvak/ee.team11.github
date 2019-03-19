package ee.itcollege.team11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import projekt.web.VaeosaAlluvusController;


/**
 * The persistent class for the VAEOSA database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@EntityListeners({
	LisatudListener.class,
	MuudetudListener.class
})
public class Vaeosa extends BaseEntity {
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

	@NotNull
	@NotEmpty
	private String kood;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date kuni;

	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	@NotNull
	@NotEmpty
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
		return this.vaeosaAlluvuses2;
	}

	//kes on minu alluvad
	public void setVaeosaAlluvuses1(Set<VaeosaAlluvus> vaAlluvad) {
		this.vaeosaAlluvuses2 = vaAlluvad;
	}
	
	public Set<VaeosaAlluvus> getVaeosaAlluvuses2() {
		return this.vaeosaAlluvuses2;
	}

		
	
	//kes on minu ylemused
	public void setVaeosaAlluvuses2(Set<Vaeosa> ylemused) {
		Set <VaeosaAlluvus> alluvused = new HashSet<VaeosaAlluvus>();
		if(ylemused != null) {
			for(Vaeosa vaeosa: ylemused) {
				VaeosaAlluvus va = new VaeosaAlluvus();
				va.setVaeosa2(vaeosa);				
				alluvused.add(va);
			}
		}
		this.vaeosaAlluvuses2 = alluvused;
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaeosa other = (Vaeosa) obj;
		if (vaeosaIdId == null) {
			if (other.vaeosaIdId != null)
				return false;
		} else if (!vaeosaIdId.equals(other.vaeosaIdId))
			return false;
		return true;
	}
    
    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
        	this.removeAlluvus();
        } else {
            Vaeosa attached = Vaeosa.findVaeosa(this.vaeosaIdId);
            attached.removeAlluvus();
        }
    }
    
    /**
     * Close adminAlluvus
     */
    private void removeAlluvus() {
    	this.setSuletud(getDate());
    	this.setSulgeja(getLoggedUserName());
    	this.entityManager.merge(this);
    }
    
    public static List<Vaeosa> findVaeosaEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Vaeosa o WHERE suletud > CURDATE()", Vaeosa.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    

}