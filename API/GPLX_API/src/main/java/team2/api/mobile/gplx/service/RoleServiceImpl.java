package team2.api.mobile.gplx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.api.mobile.gplx.commondata.GenericServiceImpl;
import team2.api.mobile.gplx.models.Role;
import team2.api.mobile.gplx.repository.RoleRepository;
import team2.api.mobile.gplx.service.interfaces.RoleService;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, String> implements RoleService {

	@Autowired
	private RoleRepository repo;
	
	@Override
	public Role update(Role role, String id) {
		try {
			Role updatedRole = repo.findById(id).get();
			updatedRole.setRoleName(role.getRoleName());
			updatedRole.setDescription(role.getDescription());
			return repo.save(updatedRole);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
