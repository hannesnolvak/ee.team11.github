// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team11;

import ee.itcollege.team11.PiirivalvuriKontakt;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PiirivalvuriKontakt_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager PiirivalvuriKontakt.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer PiirivalvuriKontakt.version;
    
    public Integer PiirivalvuriKontakt.getVersion() {
        return this.version;
    }
    
    public void PiirivalvuriKontakt.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void PiirivalvuriKontakt.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void PiirivalvuriKontakt.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            PiirivalvuriKontakt attached = PiirivalvuriKontakt.findPiirivalvuriKontakt(this.piirivalvuriKontaktId);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void PiirivalvuriKontakt.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void PiirivalvuriKontakt.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public PiirivalvuriKontakt PiirivalvuriKontakt.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PiirivalvuriKontakt merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager PiirivalvuriKontakt.entityManager() {
        EntityManager em = new PiirivalvuriKontakt().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long PiirivalvuriKontakt.countPiirivalvuriKontakts() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PiirivalvuriKontakt o", Long.class).getSingleResult();
    }
    
    public static List<PiirivalvuriKontakt> PiirivalvuriKontakt.findAllPiirivalvuriKontakts() {
        return entityManager().createQuery("SELECT o FROM PiirivalvuriKontakt o", PiirivalvuriKontakt.class).getResultList();
    }
    
    public static PiirivalvuriKontakt PiirivalvuriKontakt.findPiirivalvuriKontakt(Long piirivalvuriKontaktId) {
        if (piirivalvuriKontaktId == null) return null;
        return entityManager().find(PiirivalvuriKontakt.class, piirivalvuriKontaktId);
    }
    
    public static List<PiirivalvuriKontakt> PiirivalvuriKontakt.findPiirivalvuriKontaktEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PiirivalvuriKontakt o", PiirivalvuriKontakt.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
