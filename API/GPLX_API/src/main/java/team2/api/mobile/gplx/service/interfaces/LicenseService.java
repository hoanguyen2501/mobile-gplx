package team2.api.mobile.gplx.service.interfaces;

import team2.api.mobile.gplx.commondata.GenericService;
import team2.api.mobile.gplx.models.License;

public interface LicenseService extends GenericService<License, String> {
	License update(License license, String id);
	License findByName(String name);
}
