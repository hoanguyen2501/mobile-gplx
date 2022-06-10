package team2.api.mobile.gplx.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import team2.api.mobile.gplx.dto.DtoTrafficSignCountByType;
import team2.api.mobile.gplx.models.TrafficSign;
import team2.api.mobile.gplx.models.TrafficSignType;
import team2.api.mobile.gplx.service.interfaces.TrafficSignService;
import team2.api.mobile.gplx.service.interfaces.TrafficSignTypeService;

@RestController
public class TrafficSignController {

	@Autowired
	private TrafficSignService trafficSignService;
	@Autowired
	private TrafficSignTypeService trafficSignTypeService;

	@GetMapping("api/trafficsign")
	public ResponseEntity<Object> GetAll() {
		List<TrafficSign> trafficSign = trafficSignService.findAll();
		return new ResponseEntity<>(trafficSign, HttpStatus.OK);
	}

	@GetMapping("api/trafficsign/type/{type}")
	public ResponseEntity<Object> GetByType(@PathVariable("type") String type) {
		try {
			TrafficSignType traffiSignType = trafficSignTypeService.findByCode(type.toUpperCase());

			List<TrafficSign> trafficSigns = trafficSignService
					.findByTrafficSignType(traffiSignType.getId().toString());
			return new ResponseEntity<>(trafficSigns, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("api/trafficsign/type/{type}/{id}")
	public ResponseEntity<Object> GetByType(@PathVariable("type") String type, @PathVariable("id") String id) {
		try {
			TrafficSign trafficSign = trafficSignService.findById(id).get();
			return new ResponseEntity<>(trafficSign, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("api/trafficsign/types")
	public ResponseEntity<Object> GetTrafficSignType() {
		try {
			List<DtoTrafficSignCountByType> list = new ArrayList<>();
			List<TrafficSignType> traffiSignTypes = trafficSignTypeService.findAll();

			for (TrafficSignType type : traffiSignTypes) {
				List<TrafficSign> trafficSigns = trafficSignService.findByTrafficSignType(type.getId().toString());

				DtoTrafficSignCountByType count = new DtoTrafficSignCountByType();
				count.setId(type.getId().toString());
				count.setCode(type.getCode().toString());
				count.setName(type.getName().toString());
				count.setQuantity(trafficSigns.size());
				list.add(count);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("api/trafficsign/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") String id) {
		TrafficSign trafficSign = trafficSignService.findByTrafficSignTypeId(id);
		return new ResponseEntity<>(trafficSign, HttpStatus.OK);
	}

	@PostMapping("api/trafficsign/add")
	public ResponseEntity<Object> Post(@RequestBody TrafficSign trafficSign) {
		TrafficSign newTrafficSign = trafficSignService.save(trafficSign);
		if (newTrafficSign == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newTrafficSign, HttpStatus.OK);
	}

	@PutMapping("api/trafficsign/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") String id, @RequestBody TrafficSign trafficSign) {
		TrafficSign updatedTrafficSign = trafficSignService.update(trafficSign, id);
		if (updatedTrafficSign == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updatedTrafficSign, HttpStatus.OK);
	}

	@DeleteMapping("api/trafficsign/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") String id) {
		try {
			trafficSignService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}


}

