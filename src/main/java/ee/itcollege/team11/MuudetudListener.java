package ee.itcollege.team11;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class MuudetudListener {
	
	@PrePersist
	@PreUpdate
	public void setMuudetud(final Updatable entity) {
		entity.setMuudetud(new Date());
		entity.setMuutja("Mina");
	}
	/*
	@PrePersist
	@PreUpdate
	public void setMuutja(final Updatable entity) {
		entity.setMuutja("Mina");
	}/**/
}
