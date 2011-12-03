package ee.itcollege.team11;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable, Creatable, Updatable {

	protected static  Date getDate() {
		return new Date();
		
	}
}
