package com.btvn.service;

import java.util.List;
import java.util.Optional;

import org.h2.mvstore.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
//		SvEntity sv = new SvEntity();
//		sv.setName(name);
//		
//		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnorePaths("address");
//		
//		return svReponsitory.findAll(Example.of(sv,exampleMatcher));
		return svReponsitory.findByName(name);
	}
	public SvEntity insertOne(SvEntity name) {
		 
		 return svReponsitory.save(name);
	}
	
	public List<SvEntity> insertAll(List<SvEntity> Name) {
		return svReponsitory.saveAll(Name);
	}
	
	public SvEntity update(SvEntity entity) {
		Optional<SvEntity> student= svReponsitory.findById(entity.getId());

		SvEntity newEntity = student.get();
		newEntity.setId(entity.getId());
		newEntity.setName(entity.getName());
		newEntity.setAddress(entity.getAddress());
		
		newEntity= svReponsitory.save(newEntity);
		return newEntity;
	}
	
	public boolean check(Integer id) {
		return svReponsitory.existsById(id);
	}
	
	public void deleteById(Integer id) {
		Optional<SvEntity> student = svReponsitory.findById(id);
		svReponsitory.deleteById(id);
	} 
	
	public void deleteByname(String name) {
		SvEntity sv = new SvEntity();
		sv.setName(name);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnorePaths("address");
		
		List<SvEntity> sve = svReponsitory.findAll(Example.of(sv,exampleMatcher));
		svReponsitory.deleteAll(sve);
	}
	
	public List<SvEntity> getAllSortDescById(){
		return svReponsitory.findAll(Sort.by("id").descending());
	}
	
	
}
