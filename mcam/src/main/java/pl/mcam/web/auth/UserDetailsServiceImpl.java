package pl.mcam.web.auth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mcam.web.domain.User;

/**
 * 
 * @author Tokarz Piotr
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final Session session = sessionFactory.getCurrentSession();
		final User user = (User)session.createQuery("FROM User u JOIN FETCH u.role r WHERE u.email = :email")
									   .setString("email", email)
									   .uniqueResult();
		if (user == null) {
			throw new UsernameNotFoundException("User "+email+" doesn't exist !!!");
		}
		return new UserDetailsImpl(user);
	}
	
	@Autowired(required=true)
	private SessionFactory sessionFactory;
}
