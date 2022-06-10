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

import team2.api.mobile.gplx.models.Role;
import team2.api.mobile.gplx.service.interfaces.RoleService;

@RestController
public class RoleController {
	@Autowired
	private RoleService service;
	
	@GetMapping("api/role")
	public ResponseEntity<Object> GetAll() {
		List<Role> roles = service.findAll();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

	@PostMapping("api/role/add")
	public ResponseEntity<Object> Post(@RequestBody Role role) {
		Role newRole = service.save(role);
		if (newRole == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newRole, HttpStatus.OK);
	}

	@PutMapping("api/role/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") String id,@RequestBody Role role) {
		Role udpatedRole = service.update(role, id);
		if (udpatedRole == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(udpatedRole, HttpStatus.OK);
	}

	@DeleteMapping("api/role/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") String id){
		try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
