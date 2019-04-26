package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.beans.TDSMaster;
import com.capg.exceptions.IdNotFoundException;
import com.capg.service.TDSService;


@RestController//to convert json objects
public class TDSController {

	@Autowired//to autowire service class
	TDSService tdsService;
	
	@GetMapping("/")
	public String msg() {
		return "Hello";
	}
	
	//method for getting particular id details
	@GetMapping("/getByTDSId")
	public ResponseEntity getByTDSId(@RequestBody int id) throws IdNotFoundException {
		TDSMaster tdsBean = tdsService.getByTDSId(id);
		if(tdsBean==null)
			throw new IdNotFoundException("Id not found:"+id);
		else
		return new ResponseEntity(tdsBean,HttpStatus.OK);
	}
}





