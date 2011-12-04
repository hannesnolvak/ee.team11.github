package ee.itcollege.team11;

import java.util.Date;

import javax.persistence.PrePersist;

public class LisatudListener {
	
	@PrePersist
	public void setMuudetud(final Creatable entity) {
		entity.setAvaja("Mina");
		entity.setAvatud(new Date());
		entity.setMuudetud(new Date());
		entity.setMuutja("Mina");
		entity.setSuletud(new Date(253402207200000L)); //9999-12-31
	}
	
}
