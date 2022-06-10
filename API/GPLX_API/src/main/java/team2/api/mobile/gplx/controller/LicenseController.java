package team2.api.mobile.gplx.controller;

import java.util.List;
import java.util.Optional;

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


import team2.api.mobile.gplx.dto.AddLicenseDto;
import team2.api.mobile.gplx.models.License;
import team2.api.mobile.gplx.service.interfaces.LicenseService;

@RestController
public class LicenseController {

	@Autowired
	private LicenseService service;

	@GetMapping("api/license")
	public ResponseEntity<Object> GetAll() {
		List<License> licenses = service.findAll();
		return new ResponseEntity<>(licenses, HttpStatus.OK);
	}
	
	@GetMapping("api/license/name/{name}")
	public ResponseEntity<Object> GetByName(@PathVariable("name") String name) {
		License licenses = service.findByName(name);
		return new ResponseEntity<>(licenses, HttpStatus.OK);
	}
	@GetMapping("api/license/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") String id) {
		Optional<License> licenses = service.findById(id);
		return new ResponseEntity<>(licenses, HttpStatus.OK);
	}

	@PostMapping("api/license/add")
	public ResponseEntity<Object> Post(@RequestBody License license) {
		License newLicense = service.save(license);
		if (newLicense == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newLicense, HttpStatus.OK);
	}

	@PutMapping("api/license/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") String id, License license) {
		License updatedLicense = service.update(license, id);
		if (updatedLicense == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updatedLicense, HttpStatus.OK);
	}

	@DeleteMapping("api/license/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") String id){
		try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
