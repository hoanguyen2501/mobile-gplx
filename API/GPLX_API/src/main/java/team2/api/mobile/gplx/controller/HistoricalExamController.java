package team2.api.mobile.gplx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import team2.api.mobile.gplx.models.HistoricalExam;
import team2.api.mobile.gplx.service.interfaces.HistoricalExcemService;


@RestController
public class HistoricalExamController {
	@Autowired
	private HistoricalExcemService historicalExamService;

	@GetMapping("api/histories/{id}")
	public ResponseEntity<Object> GetAllByUserId(@PathVariable("id") String id) {
		try {
			List<HistoricalExam> list = historicalExamService.findByUserId(id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}