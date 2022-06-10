package team2.api.mobile.gplx.controller;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
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

import javassist.compiler.ast.Pair;
import team2.api.mobile.gplx.dto.DtoQuestionCountByType;
import team2.api.mobile.gplx.dto.DtoQuestionDetail;
import team2.api.mobile.gplx.models.Answer;
import team2.api.mobile.gplx.models.Question;
import team2.api.mobile.gplx.models.QuestionSet;
import team2.api.mobile.gplx.models.QuestionType;
import team2.api.mobile.gplx.service.interfaces.AnswerService;
import team2.api.mobile.gplx.service.interfaces.QuestionService;
import team2.api.mobile.gplx.service.interfaces.QuestionTypeService;

@RestController
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuestionTypeService questionTypeService;
	@Autowired
	private AnswerService answerService;

	@GetMapping("api/question")
	public ResponseEntity<Object> GetAll() {
		List<Question> questions = questionService.findAll();
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	@PostMapping("api/question/add")
	public ResponseEntity<Object> Post(@RequestBody Question question) {
		Question newQuestion = questionService.save(question);
		if (newQuestion == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newQuestion, HttpStatus.OK);
	}

	@PutMapping("api/question/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") String id, @RequestBody Question question) {
		Question updatedQuestion = questionService.update(question, id);
		if (updatedQuestion == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
	}

	@DeleteMapping("api/question/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") String id) {
		try {
			questionService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("api/question/{license}/all")
	public ResponseEntity<Object> GetQuestionByLicense(@PathVariable("license") String license) {
		List<DtoQuestionDetail> questionDetailList = new ArrayList<DtoQuestionDetail>();
		List<Question> questions = questionService.findQuestionByLicense(license);
		for (Question question : questions) {
			Answer answer = answerService.findByQuestionId(question.getId());
			questionDetailList.add(new DtoQuestionDetail(question, answer));
		}
		return new ResponseEntity<>(questionDetailList, HttpStatus.OK);
	}

	@GetMapping("api/question/license/{id}")
	public ResponseEntity<Object> GetQuestionByLicenseId(@PathVariable("id") String id) {
		List<Question> questions = questionService.findQuestionByLicenseId(id);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	@GetMapping("api/question/details/{id}")
	public ResponseEntity<Object> GetQuestionDetails(@PathVariable("id") String id) {
		try {
			Question question = questionService.findById(id).get();
			Answer answer = answerService.findByQuestionId(id);
			DtoQuestionDetail questionDetail = new DtoQuestionDetail(question, answer);
			return new ResponseEntity<>(questionDetail, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("api/question/{license}/{type}")
	public ResponseEntity<Object> GetQuestionByLicenseByType(@PathVariable("license") String license,
			@PathVariable("type") String type) {
		try {
			List<DtoQuestionDetail> questionDetailList = new ArrayList<DtoQuestionDetail>();
			List<Question> questions = questionService.findQuestionByLicense(license);
			String typeCode = questionTypeService.findByCode(type).getId();

			for (Question question : questions) {
				if (question.getQuestionTypeId().toString().equals(typeCode)) {
					Answer answer = answerService.findByQuestionId(question.getId());
					questionDetailList.add(new DtoQuestionDetail(question, answer));
				}
			}
			return new ResponseEntity<Object>(questionDetailList, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("api/question/num/{license}")
	public ResponseEntity<Object> GetNumQuestion(@PathVariable("license") String license) {
		try {
			List<QuestionType> questionTypes = questionTypeService.findAll();
			List<Question> questions = questionService.findQuestionByLicense(license);
			List<DtoQuestionCountByType> dtoQuestionCountByTypes = new ArrayList<DtoQuestionCountByType>();
		    for (QuestionType  questionType: questionTypes) {
		    	int num=0;
		    	for (Question question : questions) {
					if (question.getQuestionTypeId().toString().equals(questionType.getId())) {
						num++;
					}
				}
		    	DtoQuestionCountByType dtoQuestionCountByType = new DtoQuestionCountByType();
		    	dtoQuestionCountByType.setName(questionType.getName());
		    	dtoQuestionCountByType.setNum(num);
		    	dtoQuestionCountByType.setType(questionType.getCode());
		    	dtoQuestionCountByTypes.add(dtoQuestionCountByType);
			}
	     		    
			

		return new ResponseEntity<Object>(dtoQuestionCountByTypes, HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
