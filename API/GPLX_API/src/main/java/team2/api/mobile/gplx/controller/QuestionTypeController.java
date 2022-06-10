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

import team2.api.mobile.gplx.models.QuestionType;
import team2.api.mobile.gplx.service.interfaces.QuestionTypeService;

@RestController
public class QuestionTypeController {
	
	@Autowired
	private QuestionTypeService service;
	
	@GetMapping("api/questiontype")
	public ResponseEntity<Object> GetAll() {
		List<QuestionType> questionType = service.findAll();
		return new ResponseEntity<>(questionType, HttpStatus.OK);
	}

	@PostMapping("api/questiontype/add")
	public ResponseEntity<Object> Post(@RequestBody QuestionType questionType) {
		QuestionType newQuestionType = service.save(questionType);
		if (newQuestionType == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newQuestionType, HttpStatus.OK);
	}

	@PutMapping("api/questiontype/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") String id,@RequestBody QuestionType questionType) {
		QuestionType updatedQuestionType = service.update(questionType, id);
		if (updatedQuestionType == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updatedQuestionType, HttpStatus.OK);
	}

	@DeleteMapping("api/questiontype/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") String id){
		try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
