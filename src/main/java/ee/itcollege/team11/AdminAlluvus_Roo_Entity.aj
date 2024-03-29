// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team11;

import ee.itcollege.team11.AdminAlluvus;
import java.lang.Integer;
import java.lang.Long;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect AdminAlluvus_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager AdminAlluvus.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer AdminAlluvus.version;
    
    public Integer AdminAlluvus.getVersion() {
        return this.version;
    }
    
    public void AdminAlluvus.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void AdminAlluvus.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void AdminAlluvus.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    public static final EntityManager AdminAlluvus.entityManager() {
        EntityManager em = new AdminAlluvus().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static AdminAlluvus AdminAlluvus.findAdminAlluvus(Long adminAlluvusId) {
        if (adminAlluvusId == null) return null;
        return entityManager().find(AdminAlluvus.class, adminAlluvusId);
    }
    
}
