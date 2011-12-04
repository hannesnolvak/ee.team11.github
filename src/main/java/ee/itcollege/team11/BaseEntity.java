package ee.itcollege.team11;

import java.io.Serializable;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseEntity implements Serializable, Creatable, Updatable {

	protected static  Date getDate() {
		return new Date();
		
	}
	
	
	public static String getLoggedUserName(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			return auth.getName(); 
		} 
		
	    return "anonymus";		
	}
	
}
