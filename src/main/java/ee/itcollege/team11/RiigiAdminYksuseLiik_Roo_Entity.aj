// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team11;

import ee.itcollege.team11.RiigiAdminYksuseLiik;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect RiigiAdminYksuseLiik_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager RiigiAdminYksuseLiik.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer RiigiAdminYksuseLiik.version;
    
    public Integer RiigiAdminYksuseLiik.getVersion() {
        return this.version;
    }
    
    public void RiigiAdminYksuseLiik.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void RiigiAdminYksuseLiik.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void RiigiAdminYksuseLiik.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void RiigiAdminYksuseLiik.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public RiigiAdminYksuseLiik RiigiAdminYksuseLiik.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        RiigiAdminYksuseLiik merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager RiigiAdminYksuseLiik.entityManager() {
        EntityManager em = new RiigiAdminYksuseLiik().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static RiigiAdminYksuseLiik RiigiAdminYksuseLiik.findRiigiAdminYksuseLiik(Long riigiAdminYksuseLikId) {
        if (riigiAdminYksuseLikId == null) return null;
        return entityManager().find(RiigiAdminYksuseLiik.class, riigiAdminYksuseLikId);
    }
    
}
