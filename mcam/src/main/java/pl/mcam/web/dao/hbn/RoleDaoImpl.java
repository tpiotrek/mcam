package pl.mcam.web.dao.hbn;

import org.springframework.stereotype.Repository;

import pl.mcam.web.dao.RoleDao;
import pl.mcam.web.domain.Role;
import pl.mcam.web.domain.RoleName;

/**
 * 
 * @author Tokarz Piotr
 *
 */
@Repository("roleDaoImpl")
public class RoleDaoImpl extends AbstractDaoImpl<Role> implements RoleDao {

	@Override
	public Role findByName(String name) {
		return (Role)getSession()
			.createQuery("FROM Role r WHERE r.name = :name")
			.setString("name", name)
			.uniqueResult();
	}

	@Override
	public Role findByName(RoleName roleName) {
		return findByName(roleName.name());
	}	
}
