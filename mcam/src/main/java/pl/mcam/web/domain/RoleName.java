package pl.mcam.web.domain;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public enum RoleName {
	
	ROLE_ADMIN(1), ROLE_USER(2);
	
	private RoleName(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "RoleName[value="+value+", name="+name()+"]";
	}
	
	private int value;
}
