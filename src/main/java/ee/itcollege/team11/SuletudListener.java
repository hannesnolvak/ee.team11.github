package ee.itcollege.team11;

import java.util.Date;

import javax.persistence.PreRemove;

public class SuletudListener {
	
	@PreRemove
	public void setSuletud(final Deletable entity) {
		entity.setSuletud(new Date());
		entity.setSulgeja("Mina");
	}
	/*
	@PreRemove
	public void setSulgeja(final Deletable entity) {
		entity.setSulgeja("Mina");
	}/**/
}
