package com.btvn.SvController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btvn.model.SvEntity;
import com.btvn.service.SvService;

@RestController
public class svController {

	@Autowired
	SvService svService;
	
	@RequestMapping("/sv")
	public List<SvEntity> getAll(){
		return svService.getAll();
	}
	
	@GetMapping("sv/{id}")
	public SvEntity getByid(@PathVariable int id) {
		return svService.getById(id);
		
	}
	@GetMapping("/svname")
	public List<SvEntity> getAllByname(@RequestParam(name="name") String name){
		return svService.getByname(name);
	}
}
