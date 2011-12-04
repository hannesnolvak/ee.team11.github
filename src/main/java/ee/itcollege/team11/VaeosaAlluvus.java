package ee.itcollege.team11;

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
 * The persistent class for the VAEOSA_ALLUVUS database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@Table(name="VAEOSA_ALLUVUS")
@EntityListeners({
	LisatudListener.class,
	MuudetudListener.class
})
public class VaeosaAlluvus extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VAEOSA_ALLUVUS_ID")
	private Long vaeosaAlluvusId;

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

	//bi-directional many-to-one association to Vaeosa
    @ManyToOne
	@JoinColumn(name="ALLUVA_VAEOSA_ID")
	private Vaeosa vaeosa1;

	//bi-directional many-to-one association to Vaeosa
    @ManyToOne
	@JoinColumn(name="YLEMUS_VAEOSA_ID")
	private Vaeosa vaeosa2;

    public VaeosaAlluvus() {
    }

	public Long getVaeosaAlluvusId() {
		return this.vaeosaAlluvusId;
	}

	public void setVaeosaAlluvusId(Long vaeosaAlluvusId) {
		this.vaeosaAlluvusId = vaeosaAlluvusId;
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

	public Vaeosa getVaeosa1() {
		return this.vaeosa1;
	}

	public void setVaeosa1(Vaeosa vaeosa1) {
		this.vaeosa1 = vaeosa1;
	}
	
	public Vaeosa getVaeosa2() {
		return this.vaeosa2;
	}

	public void setVaeosa2(Vaeosa vaeosa2) {
		this.vaeosa2 = vaeosa2;
	}

	public static VaeosaAlluvus getVaeosaAlluvusYlemusSuheByVaeosa(Vaeosa vaeosa) {
		for (VaeosaAlluvus va : VaeosaAlluvus.findAllVaeosaAlluvuses())
		{
			if (va.getVaeosa1().getKood().equals(vaeosa.getKood()))
			{
				return va;
			}
		}
		 
		return null;
	}
	
	
	
	
	
	
	
	
    /**
     * Create adminAlluvus
     * if adminAlluvus allready exists, then we do nothing
     * @param riigiAdminYksusId
     */
    @Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        
        // try to find existing alluvus
        VaeosaAlluvus a = findVaeosaAlluvusByVaeosaAlluvuses(this);
        
        if(a == null) {
        	VaeosaAlluvus alluvus = findVaeosaAlluvusByVaeosaAlluvus(this);
        	
        	if(alluvus != null) {
            	// close old alluvus
        		alluvus.remove();
        	}
        	
            // create new alluvus
        	this.entityManager.persist(this);
        } else {
        	this.setVaeosaAlluvusId(a.getVaeosaAlluvusId());
        }
    }
    

    
    @Transactional
    public VaeosaAlluvus merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        
        VaeosaAlluvus alluvus =  VaeosaAlluvus.findVaeosaAlluvus(this.vaeosaAlluvusId);

        if(alluvus.getVaeosa1().equals(this.getVaeosa1()) && 
           alluvus.getVaeosa2().equals(this.getVaeosa2())) {
        	VaeosaAlluvus merged = this.entityManager.merge(this);
            this.entityManager.flush();
            return merged;
        }
        
        this.setVaeosaAlluvusId(null);
        this.persist();
        
        return this;
    }
    
    
       
    
    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
        	this.removeAlluvus();

        } else {
            VaeosaAlluvus attached = VaeosaAlluvus.findVaeosaAlluvus(this.vaeosaAlluvusId);
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
    
    
    
    
	private VaeosaAlluvus findVaeosaAlluvusByVaeosaAlluvuses(
			VaeosaAlluvus vaeosaAlluvus) {
		try {
			String query = "SELECT o" +
						" FROM VaeosaAlluvus o" +
						" JOIN o.vaeosa1 y1" +
						" JOIN o.vaeosa2 y2" +
						" WHERE (o.suletud > :date OR o.suletud IS NULL)" +
							" AND y1.vaeosaIdId = :yksusId1" +
							" AND y2.vaeosaIdId = :yksusId2" +
						" ORDER BY o.suletud DESC NULLS FIRST";
			return entityManager().createQuery(query, VaeosaAlluvus.class)
					.setParameter("date", getDate())
					.setParameter("yksusId1", vaeosaAlluvus.getVaeosa1().getVaeosaIdId())
					.setParameter("yksusId2", vaeosaAlluvus.getVaeosa2().getVaeosaIdId())
					.getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
    

	

    
    private VaeosaAlluvus findVaeosaAlluvusByVaeosaAlluvus(
			VaeosaAlluvus vaeosaAlluvus) {
    	
    	
    	
		try {
			String query = "SELECT o" +
						" FROM VaeosaAlluvus o" +
						" JOIN o.vaeosa1 y1" +
						" JOIN o.vaeosa2 y2" +
						" WHERE (o.suletud > :date OR o.suletud IS NULL)" +
							" AND y1.vaeosaIdId = :yksusId1" +
							" AND y2.vaeosaIdId != :yksusId2" +
						" ORDER BY o.suletud DESC NULLS FIRST";
			return entityManager().createQuery(query, VaeosaAlluvus.class)
					.setParameter("date", getDate())
					.setParameter("yksusId1", vaeosaAlluvus.getVaeosa1().getVaeosaIdId())
					.setParameter("yksusId2", vaeosaAlluvus.getVaeosa2().getVaeosaIdId())
					.getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
    
    
    
    
    public static long countVaeosaAlluvuses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM VaeosaAlluvus o WHERE o.suletud > :date OR o.suletud IS NULL", Long.class).setParameter("date", getDate()).getSingleResult();
    }
    
    public static List<VaeosaAlluvus> findAllVaeosaAlluvuses() {
        return entityManager().createQuery("SELECT o FROM VaeosaAlluvus o WHERE o.suletud > :date OR o.suletud IS NULL", VaeosaAlluvus.class).setParameter("date", getDate()).getResultList();
    }
    
    public static VaeosaAlluvus findVaeosaAlluvus(Long vaeosaAlluvusId) {
        if (vaeosaAlluvusId == null) return null;
        return entityManager().find(VaeosaAlluvus.class, vaeosaAlluvusId);
    }
    
    public static List<VaeosaAlluvus> findVaeosaAlluvusEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM VaeosaAlluvus o WHERE o.suletud > :date OR o.suletud IS NULL", VaeosaAlluvus.class).setParameter("date", getDate()).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}