package pl.mcam.web.domain;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public enum UserStatus {
	
	NEW(1), ACTIVE(2), LOCKED(3);
	
	private UserStatus(int value) {
		this.value = value;
	}
	
	@SuppressWarnings("unused")
	private int value;
}
