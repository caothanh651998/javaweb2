package com.ktra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktra.exception.RecordNotFoundException;
//import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.ktra.model.StudentEntity;
import com.ktra.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository; 
	
	public List<StudentEntity> getAll(){
		
		List<StudentEntity> list =  (List<StudentEntity>) studentRepository.findAll();
		
		return list;
	}
	
	public StudentEntity getStudentById(Long id) throws RecordNotFoundException 
	{
		Optional<StudentEntity> student = studentRepository.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
	
	
	
}