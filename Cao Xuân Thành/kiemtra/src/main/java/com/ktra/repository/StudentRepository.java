package com.ktra.repository;

import org.springframework.data.repository.CrudRepository;
import com.ktra.model.StudentEntity;


public interface StudentRepository extends CrudRepository<StudentEntity, Long>{
	
}

