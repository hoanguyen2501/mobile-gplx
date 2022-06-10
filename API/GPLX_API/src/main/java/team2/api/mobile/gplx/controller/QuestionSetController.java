package team2.api.mobile.gplx.controller;

import java.util.ArrayList;
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

import team2.api.mobile.gplx.dto.DtoQuestionSet;
import team2.api.mobile.gplx.models.Answer;
import team2.api.mobile.gplx.models.Question;
import team2.api.mobile.gplx.models.QuestionSet;
import team2.api.mobile.gplx.service.interfaces.AnswerService;
import team2.api.mobile.gplx.service.interfaces.QuestionService;
import team2.api.mobile.gplx.service.interfaces.QuestionSetService;

@RestController
public class QuestionSetController {
	@Autowired
	private QuestionSetService service;
	@Autowired
	private QuestionService questService;
	@Autowired
	private AnswerService ansService;
	
	@GetMapping("api/questionset")
	public ResponseEntity<Object> GetAll() {
		List<QuestionSet> sets = service.findAll();
		return new ResponseEntity<>(sets, HttpStatus.OK);
	}
	
	@GetMapping("api/questionset/{id}")
	public ResponseEntity<Object> GetSet(@PathVariable("id") String id) {
		DtoQuestionSet set = new DtoQuestionSet();
		Optional<QuestionSet> questionSet = service.findById(id);
		if(questionSet == null) {
			return new ResponseEntity<>(set, HttpStatus.BAD_REQUEST);
		}
		List<Question> questions = questService.findByQuestionSetId(id);
		List<Answer> answers = new ArrayList<>();
		for(Question item : questions) {
			Answer ans = ansService.findByQuestionId(item.getId());
			answers.add(ans);
		}
		System.out.println(questionSet.toString());
		System.out.println(questions.toString());
		System.out.println(answers.toString());
		set.setQuestionSet(questionSet);
		set.setQuestList(questions);
		set.setAnsList(answers);
		
		return new ResponseEntity<>(set, HttpStatus.OK);
	}
	
	@GetMapping("api/questionset/license/{id}")
	public ResponseEntity<Object> GetByLicenseId(@PathVariable("id") String id) {
		List<QuestionSet> set = service.findByLicenseId(id);
		return new ResponseEntity<>(set, HttpStatus.OK);
	}
	
	@PostMapping("api/questionset/add")
	public ResponseEntity<Object> Post(@RequestBody QuestionSet set) {
		QuestionSet newSet = service.save(set);
		if (newSet == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newSet, HttpStatus.OK);
	}

	@PutMapping("api/questionset/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") String id,@RequestBody QuestionSet set) {
		QuestionSet updatedSet = service.update(set, id);
		if (updatedSet == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updatedSet, HttpStatus.OK);
	}

	@DeleteMapping("api/questionset/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") String id){
		try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
