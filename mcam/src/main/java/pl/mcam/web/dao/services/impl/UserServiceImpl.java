package pl.mcam.web.dao.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mcam.web.dao.RoleDao;
import pl.mcam.web.dao.UserDao;
import pl.mcam.web.dao.services.ResultCodes;
import pl.mcam.web.dao.services.UserService;
import pl.mcam.web.domain.Role;
import pl.mcam.web.domain.RoleName;
import pl.mcam.web.domain.User;

/**
 * 
 * @author Tokarz Piotr
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
	
	@Override
	public ResultCodes create(User user) throws Exception {
		return createUser(user, null);
	}
	
	@Override
	public ResultCodes create(User user, RoleName roleName) throws Exception {
		return createUser(user, roleName);
	}
	
	@Override 
	public void delete(User user) {
		userDao.delete(user);
	}
	
	@Override
	public User findById(Long id) {
		return userDao.get(id);
	}
	
	private ResultCodes createUser(User user, RoleName roleName) throws Exception {
		if (userDao.exists(user.getEmail())) {
			return ResultCodes.EXISTS;
		}
		
		if (roleName != null) {
			final Role role = roleDao.findByName(roleName);
			if (role == null) {
				throw new Exception("Role "+roleName+" do not exist !!!");
			} else {
				user.setRole(role);
			}
		}
		
		//TODO how to catch exceptions throws by hibernate ?
		userDao.create(user);
		
		return ResultCodes.OK;
	}
	
	@Autowired(required=true)
	@Qualifier("userDaoImpl")
	private UserDao userDao;
	
	@Autowired(required=true)
	@Qualifier("roleDaoImpl")
	private RoleDao roleDao;
}
