package team2.api.mobile.gplx.service.interfaces;

import team2.api.mobile.gplx.commondata.GenericService;
import team2.api.mobile.gplx.models.LicenseType;

public interface LicenseTypeService extends GenericService<LicenseType, String> {
	LicenseType findByName(String name);
	LicenseType update(LicenseType licenseType, String id);
}
