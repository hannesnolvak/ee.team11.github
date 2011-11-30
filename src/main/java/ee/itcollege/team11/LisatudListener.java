package ee.itcollege.team11;

import java.util.Date;

import javax.persistence.PrePersist;



public class LisatudListener {
	
	@PrePersist
	public void setMuudetud(final Updatable entity) {
		entity.setMuudetud(new Date());
		entity.setMuutja("Mina");
	}
}
