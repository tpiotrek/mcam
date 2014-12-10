package pl.mcam.web.dao;

import pl.mcam.web.domain.User;
import java.util.*;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public interface UserDao extends IDao<User> {
	
	public boolean exists(String email);
	public User findByEmail(String email);
	public List<User> findByRole(String role);
}
