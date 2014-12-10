package pl.mcam.web.dao;

import pl.mcam.web.domain.*;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public interface RoleDao extends IDao<Role> {
	
	public Role findByName(String name);
	public Role findByName(RoleName roleName);
}
