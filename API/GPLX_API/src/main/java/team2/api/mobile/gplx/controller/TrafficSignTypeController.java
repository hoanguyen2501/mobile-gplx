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

import team2.api.mobile.gplx.models.TrafficSign;
import team2.api.mobile.gplx.models.TrafficSignType;
import team2.api.mobile.gplx.service.interfaces.TrafficSignTypeService;

@RestController
public class TrafficSignTypeController {

	@Autowired
	private TrafficSignTypeService service;
	
	@GetMapping("api/trafficsigntype")
	public ResponseEntity<Object> GetAll() {
		List<TrafficSignType> trafficSignType = service.findAll();
		return new ResponseEntity<>(trafficSignType, HttpStatus.OK);
	}
	
	@GetMapping("api/trafficsigntype/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") String id) {
		TrafficSignType trafficSignType = service.findTrafficSignTypeById(id);
		return new ResponseEntity<>(trafficSignType, HttpStatus.OK);
	}

	@PostMapping("api/trafficsigntype/add")
	public ResponseEntity<Object> Post(@RequestBody TrafficSignType trafficSignType) {
		TrafficSignType newTrafficSignType = service.save(trafficSignType);
		if (newTrafficSignType == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newTrafficSignType, HttpStatus.OK);
	}

	@PutMapping("api/trafficsigntype/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") String id,@RequestBody TrafficSignType trafficSignType) {
		TrafficSignType updatedTrafficSignType = service.update(trafficSignType, id);
		if (updatedTrafficSignType == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updatedTrafficSignType, HttpStatus.OK);
	}

	@DeleteMapping("api/trafficsigntype/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") String id){
		try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
