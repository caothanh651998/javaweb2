package com.ktra.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktra.exception.RecordNotFoundException;
import com.ktra.model.StudentEntity;
import com.ktra.service.StudentService;


@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping
	public String getAll(Model model) {
		
		List<StudentEntity> list = studentService.getAll();
		model.addAttribute("list", list);
		
		return "list-employees";
	}
	
	@RequestMapping("/{id}")
	public String getStudent(Model model,@PathVariable() Long id) throws RecordNotFoundException {
		
		StudentEntity list = studentService.getStudentById(id);
		model.addAttribute("list", list);
		
		return "list-employees";
	}
	
}
