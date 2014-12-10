package pl.mcam.web.auth;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public class Md5Encoder implements PasswordEncoder {

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return this.md5Encoder.isPasswordValid(encodedPassword, rawPassword.toString(), null);
	}
	
	@Override
	public String encode(CharSequence rawPassword) {
		return this.md5Encoder.encodePassword(rawPassword.toString(), null);
	}
	
	private Md5PasswordEncoder md5Encoder = new Md5PasswordEncoder();
}
