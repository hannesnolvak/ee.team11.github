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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import projekt.web.AdminAlluvusController;


/**
 * The persistent class for the ADMIN_ALLUVUS database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@EntityListeners({
	LisatudListener.class,
	MuudetudListener.class
})
@Table(name="ADMIN_ALLUVUS")
public class AdminAlluvus extends BaseEntity {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADMIN_ALLUVUS_ID")
	private Long adminAlluvusId;

	private String alates;

	private String avaja;
	
	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kommentaar;

	private String kuni;
	
	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;
	
	@DateTimeFormat(style="M-")
    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to RiigiAdminYksus
    @ManyToOne
	@JoinColumn(name="ALLUV_YKSUS_ID")
	private RiigiAdminYksus riigiAdminYksus1;

	//bi-directional many-to-one association to RiigiAdminYksus
    @ManyToOne
	@JoinColumn(name="YLEMUS_YKSUS_ID")
	private RiigiAdminYksus riigiAdminYksus2;

    public AdminAlluvus() {
    }

	public Long getAdminAlluvusId() {
		return this.adminAlluvusId;
	}

	public void setAdminAlluvusId(Long adminAlluvusId) {
		this.adminAlluvusId = adminAlluvusId;
	}

	public String getAlates() {
		return this.alates;
	}

	public void setAlates(String alates) {
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

	public String getKuni() {
		return this.kuni;
	}

	public void setKuni(String kuni) {
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

	public RiigiAdminYksus getRiigiAdminYksus1() {
		return this.riigiAdminYksus1;
	}

	public void setRiigiAdminYksus1(RiigiAdminYksus riigiAdminYksus1) {
		this.riigiAdminYksus1 = riigiAdminYksus1;
	}
	
	public RiigiAdminYksus getRiigiAdminYksus2() {
		return this.riigiAdminYksus2;
	}

	public void setRiigiAdminYksus2(RiigiAdminYksus riigiAdminYksus2) {
		this.riigiAdminYksus2 = riigiAdminYksus2;
	}

	/**
	 * Find all opened adminAlluvuses
	 * @return List<AdminAlluvus>
	 */
    public static List<AdminAlluvus> findAllAdminAlluvuses() {
        return entityManager().createQuery("SELECT o FROM AdminAlluvus o WHERE o.suletud > :date OR o.suletud IS NULL", AdminAlluvus.class).setParameter("date", getDate()).getResultList();
    }
    
    public static List<AdminAlluvus> findAdminAlluvusEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM AdminAlluvus o WHERE o.suletud > :date OR o.suletud IS NULL", AdminAlluvus.class).setParameter("date", getDate()).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static long countAdminAlluvuses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM AdminAlluvus o WHERE o.suletud > :date OR o.suletud IS NULL", Long.class).setParameter("date", getDate()).getSingleResult();
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
        AdminAlluvus a = findAdminAlluvusByYksuses(this);
        if(a == null) {
        	
        	AdminAlluvus alluvus = findAdminAlluvusByYksus(this);
        	if(alluvus != null) {
            	// close old alluvus
        		alluvus.remove();
        	}
        	
            // create new alluvus
        	this.entityManager.persist(this);
        }
        
        this.setAdminAlluvusId(a.getAdminAlluvusId());
    }
    
    @Transactional
    public AdminAlluvus merge() {
        if (this.entityManager == null) this.entityManager = entityManager();

        Long alluvusId = this.getAdminAlluvusId();
        
        AdminAlluvus alluvus = AdminAlluvus.findAdminAlluvus(alluvusId);
        if(alluvus.getRiigiAdminYksus1().equals(this.getRiigiAdminYksus1()) && alluvus.getRiigiAdminYksus2().equals(this.getRiigiAdminYksus2())) {
	        AdminAlluvus merged = this.entityManager.merge(this);
	        this.entityManager.flush();
	        return merged;
        }
        return null;
        /*
        this.setAdminAlluvusId(null);
        this.persist();
//        return this.merge();
        
//        this.entityManager.flush();
        AdminAlluvus a = AdminAlluvus.findAdminAlluvus(alluvusId);
        return a.merge();
        
        /*
        this.entityManager.flush();
        return AdminAlluvus.findAdminAlluvus(this.getAdminAlluvusId());
        /**/
    }

	/**
     * Try to close adminAlluvus if it exists
     */
    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
//            this.entityManager.remove(this);
        	this.removeAlluvus();
        } else {
            AdminAlluvus attached = AdminAlluvus.findAdminAlluvus(this.adminAlluvusId);
            attached.removeAlluvus();
//            this.entityManager.remove(attached);
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

    /**
     * Find adminAlluvus by riigiAdminYksus1 and riigiAdminYksus2
     * @param adminAlluvus
     * @return AdminAlluvus
     */
	private static AdminAlluvus findAdminAlluvusByYksuses(AdminAlluvus adminAlluvus) {
		try {
			String query = "SELECT o" +
						" FROM AdminAlluvus o" +
						" JOIN o.riigiAdminYksus1 y1" +
						" JOIN o.riigiAdminYksus2 y2" +
						" WHERE (o.suletud > :date OR o.suletud IS NULL)" +
							" AND y1.riigiAdminYksusId = :yksusId1" +
							" AND y2.riigiAdminYksusId = :yksusId2" +
						" ORDER BY o.suletud DESC NULLS FIRST";
			return entityManager().createQuery(query, AdminAlluvus.class)
					.setParameter("date", getDate())
					.setParameter("yksusId1", adminAlluvus.getRiigiAdminYksus1().getRiigiAdminYksusId())
					.setParameter("yksusId2", adminAlluvus.getRiigiAdminYksus2().getRiigiAdminYksusId())
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
    
    private AdminAlluvus findAdminAlluvusByYksus(AdminAlluvus adminAlluvus) {
		try {
			String query = "SELECT o" +
						" FROM AdminAlluvus o" +
						" JOIN o.riigiAdminYksus1 y1" +
						" JOIN o.riigiAdminYksus2 y2" +
						" WHERE (o.suletud > :date OR o.suletud IS NULL)" +
							" AND y1.riigiAdminYksusId = :yksusId1" +
							" AND y2.riigiAdminYksusId != :yksusId2" +
						" ORDER BY o.suletud DESC NULLS FIRST";
			return entityManager().createQuery(query, AdminAlluvus.class)
					.setParameter("date", getDate())
					.setParameter("yksusId1", adminAlluvus.getRiigiAdminYksus1().getRiigiAdminYksusId())
					.setParameter("yksusId2", adminAlluvus.getRiigiAdminYksus2().getRiigiAdminYksusId())
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
}