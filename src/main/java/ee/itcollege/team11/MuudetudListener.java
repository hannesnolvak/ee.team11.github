package ee.itcollege.team11;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class MuudetudListener {
	
	@PreUpdate
	public void setMuudetud(final Updatable entity) {
		entity.setMuudetud(new Date());	    
		entity.setMuutja(BaseEntity.getLoggedUserName());
	}
	
}
