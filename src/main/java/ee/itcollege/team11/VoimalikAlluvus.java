package ee.itcollege.team11;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;


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
    
    @Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        
        // try to find existing alluvus
        VoimalikAlluvus a = findVoimalikAlluvusByLiiks(this);
        
        if(a == null) {
        	
        	VoimalikAlluvus alluvus = findVoimalikAlluvusByLiik(this);
        	if(alluvus != null) {
            	// close old alluvus
        		alluvus.remove();
        	}
        	
            // create new alluvus
        	this.entityManager.persist(this);
        } else {
        	this.setVoimalikAlluvusId(a.getVoimalikAlluvusId());
        }
    }
    
    @Transactional
    public void persistFlush() {
    	this.persist();
//    	this.entityManager.flush();
    }
    
    @Transactional
    public VoimalikAlluvus merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
    	
    	VoimalikAlluvus alluvus = VoimalikAlluvus.findVoimalikAlluvus(this.getVoimalikAlluvusId());
    	if(alluvus.getRiigiAdminYksuseLiik1().equals(this.getRiigiAdminYksuseLiik1()) && alluvus.getRiigiAdminYksuseLiik2().equals(this.getRiigiAdminYksuseLiik2())) {
	        VoimalikAlluvus merged = this.entityManager.merge(this);
	        this.entityManager.flush();
	        return merged;
    	}
        this.setVoimalikAlluvusId(null);
        this.persist();
        
        return this;
    }
    
    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
        	this.removeAlluvus();
        } else {
            VoimalikAlluvus attached = VoimalikAlluvus.findVoimalikAlluvus(this.voimalikAlluvusId);
            attached.removeAlluvus();
        }
    }
    
    /**
     * Close adminAlluvus
     */
    private void removeAlluvus() {
    	this.setSuletud(getDate());
    	this.setSulgeja("Mina");
    	this.entityManager.merge(this);
    }
    
    public static long countVoimalikAlluvuses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM VoimalikAlluvus o WHERE o.suletud > :date OR o.suletud IS NULL", Long.class).setParameter("date", getDate()).getSingleResult();
    }
    
    public static List<VoimalikAlluvus> findAllVoimalikAlluvuses() {
        return entityManager().createQuery("SELECT o FROM VoimalikAlluvus o WHERE o.suletud > :date OR o.suletud IS NULL", VoimalikAlluvus.class).setParameter("date", getDate()).getResultList();
    }
    
    public static List<VoimalikAlluvus> findVoimalikAlluvusEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM VoimalikAlluvus o WHERE o.suletud > :date OR o.suletud IS NULL", VoimalikAlluvus.class).setParameter("date", getDate()).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    /**
     * Find adminAlluvus by riigiAdminYksus1 and riigiAdminYksus2
     * @param adminAlluvus
     * @return AdminAlluvus
     */
	private static VoimalikAlluvus findVoimalikAlluvusByLiiks(VoimalikAlluvus voimalikAlluvus) {
		try {
			String query = "SELECT o" +
						" FROM VoimalikAlluvus o" +
						" JOIN o.riigiAdminYksuseLiik1 y1" +
						" JOIN o.riigiAdminYksuseLiik2 y2" +
						" WHERE (o.suletud > :date OR o.suletud IS NULL)" +
							" AND y1.riigiAdminYksuseLikId = :yksusId1" +
							" AND y2.riigiAdminYksuseLikId = :yksusId2" +
						" ORDER BY o.suletud DESC NULLS FIRST";
			return entityManager().createQuery(query, VoimalikAlluvus.class)
					.setParameter("date", getDate())
					.setParameter("yksusId1", voimalikAlluvus.getRiigiAdminYksuseLiik1().getRiigiAdminYksuseLikId())
					.setParameter("yksusId2", voimalikAlluvus.getRiigiAdminYksuseLiik2().getRiigiAdminYksuseLikId())
					.getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
    
    private VoimalikAlluvus findVoimalikAlluvusByLiik(VoimalikAlluvus voimalikAlluvus) {
		try {
			String query = "SELECT o" +
					" FROM VoimalikAlluvus o" +
					" JOIN o.riigiAdminYksuseLiik1 y1" +
					" JOIN o.riigiAdminYksuseLiik2 y2" +
					" WHERE (o.suletud > :date OR o.suletud IS NULL)" +
						" AND y1.riigiAdminYksuseLikId = :yksusId1" +
						" AND y2.riigiAdminYksuseLikId != :yksusId2" +
					" ORDER BY o.suletud DESC NULLS FIRST";
		return entityManager().createQuery(query, VoimalikAlluvus.class)
				.setParameter("date", getDate())
				.setParameter("yksusId1", voimalikAlluvus.getRiigiAdminYksuseLiik1().getRiigiAdminYksuseLikId())
				.setParameter("yksusId2", voimalikAlluvus.getRiigiAdminYksuseLiik2().getRiigiAdminYksuseLikId())
				.getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
}