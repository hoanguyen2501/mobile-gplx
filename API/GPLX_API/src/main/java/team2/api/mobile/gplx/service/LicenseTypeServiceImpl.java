package team2.api.mobile.gplx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.api.mobile.gplx.commondata.GenericServiceImpl;
import team2.api.mobile.gplx.models.LicenseType;
import team2.api.mobile.gplx.repository.LicenseTypeRepository;
import team2.api.mobile.gplx.service.interfaces.LicenseTypeService;

@Service
public class LicenseTypeServiceImpl extends GenericServiceImpl<LicenseType, String> implements LicenseTypeService {
	@Autowired
	private LicenseTypeRepository repo;

	@Override
	public LicenseType findByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public LicenseType update(LicenseType licenseType, String id) {
		try {
			LicenseType updatedLicenseType = repo.findById(id).get();
			updatedLicenseType.setName(licenseType.getName());
			updatedLicenseType.setDescription(licenseType.getDescription());
			updatedLicenseType.setStatus(licenseType.getStatus());
			return repo.save(updatedLicenseType);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
}
