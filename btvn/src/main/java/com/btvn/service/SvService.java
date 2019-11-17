package com.btvn.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btvn.model.SvEntity;
import com.btvn.reponsitory.SvReponsitory;

@Service
public class SvService {

	@Autowired 
	SvReponsitory svReponsitory;
	
//	@Autowired
//	SessionFactory sessionFactory;
	
	public List<SvEntity> getAll(){
		
		List<SvEntity> list =  (List<SvEntity>) svReponsitory.findAll();
		
		return list;
	}
	public SvEntity getById(Integer id){
		Optional<SvEntity> student = svReponsitory.findById(id);
		
		return student.get();
	}
	
	public List<SvEntity> getByname(String name){
//		Session sesion = sessionFactory.getCurrentSession();
//		String query = "from sinhvien where sv="+name;
//		SvEntity sv= (SvEntity) sesion.createQuery(query).getResultList();
//		SvEntity list =  (SvEntity) svReponsitory.findByName(name);
		SvEntity sv = new SvEntity();
		sv.setName(name);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnorePaths("name");
		
		return svReponsitory.findAll(Example.of(sv,exampleMatcher));
	}
}
