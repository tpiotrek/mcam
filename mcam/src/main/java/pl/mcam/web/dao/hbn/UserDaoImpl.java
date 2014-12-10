package pl.mcam.web.dao.hbn;

import java.util.List;

import org.springframework.stereotype.Repository;

import pl.mcam.web.dao.UserDao;
import pl.mcam.web.domain.User;

/**
 * 
 * @author Tokarz Piotr
 *
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

	@Override
	public User findByEmail(String email) {
		return (User)getSession()
				.createQuery("FROM User u WHERE u.email = :userEmail")
				.setString("userEmail", email)
				.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findByRole(String roleName) {
		return (List<User>)getSession()
				.createQuery("FROM User u JOIN FETCH u.role r WHERE r.NAME = :roleName")
				.setString("roleName", roleName)
				.list();
	}

	@Override
	public boolean exists(String email) {
		return findByEmail(email) != null;
	}
}
