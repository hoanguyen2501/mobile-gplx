package team2.api.mobile.gplx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.api.mobile.gplx.models.LicenseType;
import team2.api.mobile.gplx.service.interfaces.LicenseTypeService;

@RestController
public class LicenseTypeController {
	
	@Autowired
	private LicenseTypeService service;
	
	@GetMapping("api/licensetype")
	public ResponseEntity<Object> GetAll() {
		List<LicenseType> licenseType = service.findAll();
		return new ResponseEntity<>(licenseType, HttpStatus.OK);
	}

	@PostMapping("api/licensetype/add")
	public ResponseEntity<Object> Post(@RequestBody LicenseType licenseType) {
		LicenseType newLicenseType = service.save(licenseType);
		if (newLicenseType == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newLicenseType, HttpStatus.OK);
	}

	@PutMapping("api/licensetype/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") String id,@RequestBody LicenseType licenseType) {
		LicenseType updatedLicenseType = service.update(licenseType, id);
		if (updatedLicenseType == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updatedLicenseType, HttpStatus.OK);
	}

	@DeleteMapping("api/licensetype/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") String id){
		try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
