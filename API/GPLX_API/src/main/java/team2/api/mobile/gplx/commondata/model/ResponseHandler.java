package team2.api.mobile.gplx.commondata.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import team2.api.mobile.gplx.utils.ErrorUtils;
import team2.api.mobile.gplx.utils.ListUtils;

public class ResponseHandler {
	public static ResponseEntity<Object> getResponse(Object content, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		
		map.put("content", content);
		map.put("message", ListUtils.emtyStringList);
		map.put("status", status.value());
		
		return new ResponseEntity<>(map,status);
	}
	
	public static ResponseEntity<Object> getResponse(BindingResult bindingResult, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		
		map.put("content", ListUtils.emtyStringList);
		map.put("message", ErrorUtils.getErrorMessage(bindingResult));
		map.put("status", status.value());
		
		return new ResponseEntity<>(map,status);
	}
	
	public static ResponseEntity<Object> getResponse(String error, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		
		map.put("content", ListUtils.emtyStringList);
		map.put("message", ErrorUtils.errorOf(error));
		map.put("status", status.value());
		
		return new ResponseEntity<>(map,status);
	}
	
	public static ResponseEntity<Object> getResponse(HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		
		map.put("content", ListUtils.emtyStringList);
		map.put("message", ListUtils.emtyStringList);
		map.put("status", status.value());
		
		return new ResponseEntity<>(map,status);
	}
}
