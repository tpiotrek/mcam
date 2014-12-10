package pl.mcam.web.dao.services;

import java.util.List;

import pl.mcam.web.domain.RoleName;
import pl.mcam.web.domain.User;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public interface UserService {
	
	public List<User> getAll();
	public User findById(Long id);
	public void delete(User user);
	public ResultCodes create(User user) throws Exception;
	public ResultCodes create(User user, RoleName role) throws Exception;
}
