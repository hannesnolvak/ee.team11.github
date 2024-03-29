package ee.itcollege.team11;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;


/**
 * The persistent class for the RIIGI_ADMIN_YKSUS database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@EntityListeners({
	LisatudListener.class,
	MuudetudListener.class
})
@Table(name="RIIGI_ADMIN_YKSUS")
public class RiigiAdminYksus extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RIIGI_ADMIN_YKSUS_ID")
	private Long riigiAdminYksusId;
	
	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date alates;

	private String avaja;
	
	private String kommentaar;
	
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
	private Date muudetud;

	private String muutja;

	@NotNull
	@NotEmpty
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


//	http://docs.oracle.com/javaee/5/api/javax/persistence/JoinColumns.html
//	@ManyToOne
//	@JoinTable(name="ADMIN_ALLUVUS", joinColumns = {@JoinColumn(name="YLEMUS_YKSUS_ID")}, inverseJoinColumns = {@JoinColumn(name="RIIGI_ADMIN_YKSUS_ID")})
//	private RiigiAdminYksus allub;
	
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

	public void setAdminAlluvuses2(Set<RiigiAdminYksus> yksused) {
		
		Set <AdminAlluvus> alluvused = new HashSet<AdminAlluvus>();
		if(yksused != null) {
			for(RiigiAdminYksus yksus: yksused) {
				AdminAlluvus a = new AdminAlluvus();
				a.setRiigiAdminYksus2(yksus);
				alluvused.add(a);
			}
		}
		this.adminAlluvuses2 = alluvused;
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
		RiigiAdminYksus other = (RiigiAdminYksus) obj;
		if (riigiAdminYksusId == null) {
			if (other.riigiAdminYksusId != null)
				return false;
		} else if (!riigiAdminYksusId.equals(other.riigiAdminYksusId))
			return false;
		return true;
	}

	/**
     * Try to close adminAlluvus if it exists
     */
    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
        	this.removeAlluvus();
        } else {
        	RiigiAdminYksus attached = RiigiAdminYksus.findRiigiAdminYksus(this.riigiAdminYksusId);
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
    
    public static long countRiigiAdminYksuses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM RiigiAdminYksus o WHERE o.suletud > :date OR o.suletud IS NULL", Long.class).setParameter("date", getDate()).getSingleResult();
    }
    
    public static List<RiigiAdminYksus> findAllRiigiAdminYksuses() {
        return entityManager().createQuery("SELECT o FROM RiigiAdminYksus o WHERE o.suletud > :date OR o.suletud IS NULL", RiigiAdminYksus.class).setParameter("date", getDate()).getResultList();
    }
    
    public static List<RiigiAdminYksus> findRiigiAdminYksusEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM RiigiAdminYksus o WHERE o.suletud > :date OR o.suletud IS NULL", RiigiAdminYksus.class).setParameter("date", getDate()).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
	
}