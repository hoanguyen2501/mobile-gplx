package team2.api.mobile.gplx.service.interfaces;


import team2.api.mobile.gplx.commondata.GenericService;
import team2.api.mobile.gplx.models.Role;

public interface RoleService extends GenericService<Role, String> {
	Role update(Role role, String id);
}
