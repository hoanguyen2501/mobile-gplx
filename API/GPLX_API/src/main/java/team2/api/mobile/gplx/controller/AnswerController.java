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

import team2.api.mobile.gplx.models.Answer;
import team2.api.mobile.gplx.service.interfaces.AnswerService;

@RestController
public class AnswerController {
	@Autowired
	private AnswerService service;
	
	@GetMapping("api/answer")
	public ResponseEntity<Object> GetAll() {
		List<Answer> answers = service.findAll();
		return new ResponseEntity<>(answers, HttpStatus.OK);
	}
	
	@GetMapping("api/answer/{questionId}")
	public ResponseEntity<Object> GetByQuestionId(@PathVariable("questionId") String id) {
		Answer answers = service.findByQuestionId(id);
		return new ResponseEntity<>(answers, HttpStatus.OK);
	}

	@PostMapping("api/answer/add")
	public ResponseEntity<Object> Post(@RequestBody Answer answer) {
		Answer newAnswer = service.save(answer);
		if (newAnswer == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newAnswer, HttpStatus.OK);
	}

	@PutMapping("api/answer/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") String id,@RequestBody Answer answer) {
		Answer updatedAnswer = service.update(answer, id);
		if (updatedAnswer == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updatedAnswer, HttpStatus.OK);
	}

	@DeleteMapping("api/answer/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") String id){
		try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
