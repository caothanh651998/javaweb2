package com.btvn.SvController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping("sv/{id}")
	public SvEntity getByid(@PathVariable int id) {
		return svService.getById(id);
		
	}
	@RequestMapping("/svname")
	public List<SvEntity> getAllByname(@RequestParam(name="name") String name){
		return svService.getByname(name);
	}
	
	@RequestMapping("/insert")
	public SvEntity insert(@RequestBody SvEntity name) {
		return svService.insertOne(name);
	}
	
	@RequestMapping("/insertAll")
	public List<SvEntity> insertAll(@RequestBody List<SvEntity> Name) {
		return svService.insertAll(Name);
	}
	
	@RequestMapping("/update/{id}")
	public SvEntity update(@PathVariable int id,@RequestBody SvEntity entity) {
		
		return svService.update(entity);
		
	}
	
	@RequestMapping("/check")
	public boolean checkExits(@RequestBody SvEntity svEntity) {
		return svService.check(svEntity.getId());
	}
	
	@RequestMapping("/delete/{id}")
	public void deleteByid(@PathVariable int id) {
		svService.deleteById(id);;
	}
	
	@RequestMapping("/deleteByname")
	public boolean delbyname(@RequestBody SvEntity SvEntity) {
		svService.deleteByname(SvEntity.getName());
		return true;
		
	}
	
	@RequestMapping("/getAllSort")
	public List<SvEntity> getAllSortDescById(){
		return svService.getAllSortDescById();
	}
	
	
}
