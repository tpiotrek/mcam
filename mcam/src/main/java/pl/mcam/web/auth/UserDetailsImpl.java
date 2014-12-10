package pl.mcam.web.auth;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pl.mcam.web.domain.User;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public class UserDetailsImpl implements UserDetails {
	
	public UserDetailsImpl(final User user) {
		this.password = user.getPassword();
		this.username = user.getEmail();
		this.authorities = new LinkedList<SimpleGrantedAuthority>();
		this.authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	private String password;
	private String username;
	private List<SimpleGrantedAuthority> authorities;
	
	private static final long serialVersionUID = 1L;
}
