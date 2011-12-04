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
 * The persistent class for the RIIGI_ADMIN_YKSUSE_LIIK database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@EntityListeners({
	LisatudListener.class,
	MuudetudListener.class,
//	SuletudListener.class
})
@Table(name="RIIGI_ADMIN_YKSUSE_LIIK")
public class RiigiAdminYksuseLiik extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RIIGI_ADMIN_YKSUSE_LIK_ID")
	private Long riigiAdminYksuseLikId;

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

	//bi-directional many-to-one association to RiigiAdminYksus
	@OneToMany(mappedBy="riigiAdminYksuseLiik")
	private Set<RiigiAdminYksus> riigiAdminYksuses;

	//bi-directional many-to-one association to VoimalikAlluvus
	@OneToMany(mappedBy="riigiAdminYksuseLiik1")
	private Set<VoimalikAlluvus> voimalikAlluvuses1;

	//bi-directional many-to-one association to VoimalikAlluvus
	@OneToMany(mappedBy="riigiAdminYksuseLiik2")
	private Set<VoimalikAlluvus> voimalikAlluvuses2;

    public RiigiAdminYksuseLiik() {
    }

	public Long getRiigiAdminYksuseLikId() {
		return this.riigiAdminYksuseLikId;
	}

	public void setRiigiAdminYksuseLikId(Long riigiAdminYksuseLikId) {
		this.riigiAdminYksuseLikId = riigiAdminYksuseLikId;
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

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
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

	public Set<RiigiAdminYksus> getRiigiAdminYksuses() {
		return this.riigiAdminYksuses;
	}

	public void setRiigiAdminYksuses(Set<RiigiAdminYksus> riigiAdminYksuses) {
		this.riigiAdminYksuses = riigiAdminYksuses;
	}
	
	public Set<VoimalikAlluvus> getVoimalikAlluvuses1() {
		return this.voimalikAlluvuses1;
	}

	public void setVoimalikAlluvuses1(Set<VoimalikAlluvus> voimalikAlluvuses1) {
		this.voimalikAlluvuses1 = voimalikAlluvuses1;
	}
	
	public Set<VoimalikAlluvus> getVoimalikAlluvuses2() {
		return this.voimalikAlluvuses2;
	}

	public void setVoimalikAlluvuses2(Set<RiigiAdminYksuseLiik> liigid) {
		
		Set <VoimalikAlluvus> alluvused = new HashSet<VoimalikAlluvus>();
		if(liigid != null) {
			for(RiigiAdminYksuseLiik liik: liigid) {
				VoimalikAlluvus a = new VoimalikAlluvus();
				a.setRiigiAdminYksuseLiik2(liik);
				alluvused.add(a);
			}
		}
		this.voimalikAlluvuses2 = alluvused;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RiigiAdminYksuseLiik other = (RiigiAdminYksuseLiik) obj;
		if (riigiAdminYksuseLikId == null) {
			if (other.riigiAdminYksuseLikId != null)
				return false;
		} else if (!riigiAdminYksuseLikId.equals(other.riigiAdminYksuseLikId))
			return false;
		return true;
	}
    
    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
        	this.removeAlluvus();
        } else {
            RiigiAdminYksuseLiik attached = RiigiAdminYksuseLiik.findRiigiAdminYksuseLiik(this.riigiAdminYksuseLikId);
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
    
    public static long countRiigiAdminYksuseLiiks() {
        return entityManager().createQuery("SELECT COUNT(o) FROM RiigiAdminYksuseLiik o WHERE o.suletud > :date OR o.suletud IS NULL", Long.class).setParameter("date", getDate()).getSingleResult();
    }
    
    public static List<RiigiAdminYksuseLiik> findAllRiigiAdminYksuseLiiks() {
        return entityManager().createQuery("SELECT o FROM RiigiAdminYksuseLiik o WHERE o.suletud > :date OR o.suletud IS NULL", RiigiAdminYksuseLiik.class).setParameter("date", getDate()).getResultList();
    }
    
    public static List<RiigiAdminYksuseLiik> findRiigiAdminYksuseLiikEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM RiigiAdminYksuseLiik o WHERE o.suletud > :date OR o.suletud IS NULL", RiigiAdminYksuseLiik.class).setParameter("date", getDate()).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
	
}