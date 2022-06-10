package team2.api.mobile.gplx.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.api.mobile.gplx.commondata.GenericServiceImpl;
import team2.api.mobile.gplx.models.License;
import team2.api.mobile.gplx.repository.LicenseRepository;
import team2.api.mobile.gplx.service.interfaces.LicenseService;

@Service
public class LicenseServiceImpl extends GenericServiceImpl<License, String> implements LicenseService {

	@Autowired
	private LicenseRepository repo;

	@Override
	public License update(License license, String id) {
		try {
			License updatedLicense = repo.findById(id).get();
			updatedLicense.setName(license.getName());
			updatedLicense.setDescription(license.getDescription());
			updatedLicense.setStatus(license.getStatus());
			updatedLicense.setLicenseTypeId(license.getLicenseTypeId());
			return repo.save(updatedLicense);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public License findByName(String name) {
		return repo.findByName(name);
	}

}
