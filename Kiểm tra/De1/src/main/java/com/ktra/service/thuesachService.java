package com.ktra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ktra.model.thuesachEntity;
import com.ktra.reponsitory.thuesachReponsitory;

@Service
public class thuesachService {

	@Autowired
	thuesachReponsitory thuesachReponsitory;
	
	public List<thuesachEntity> getAll(){
		return thuesachReponsitory.findAll();
	}
	
	public thuesachEntity insert(thuesachEntity entity) {
		return thuesachReponsitory.save(entity);
	}
	public List<thuesachEntity> getByname(String tacGia){
		thuesachEntity thuesach = new thuesachEntity();
		thuesach.setTacGia(tacGia);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("maSach").withIgnorePaths("tenSach")
				.withIgnorePaths("soTrang").withIgnorePaths("ngayMuon").withIgnorePaths("ngayTra");
		return thuesachReponsitory.findAll(Example.of(thuesach,exampleMatcher));
	}
	public thuesachEntity update(thuesachEntity entity) {
		Optional<thuesachEntity> thuesach= thuesachReponsitory.findById(entity.getMaSach());

		thuesachEntity newEntity = thuesach.get();
		newEntity.setMaSach(entity.getMaSach());
		newEntity.setTenSach(entity.getTenSach());
		newEntity.setTacGia(entity.getTacGia());
		newEntity.setNgayMuon(entity.getNgayMuon());
		newEntity.setNgayTra(entity.getNgayTra());
		
		newEntity= thuesachReponsitory.save(newEntity);
		return newEntity;
	}
	
//	public Page<thuesachEntity> sapxe(Integer ngayTra) {
//		return thuesachReponsitory.findAll(PageRequest.of(ngayTra, 4));
//	}
	
//	public Pageable sapxe(int ngayTra) {
////		return thuesachReponsitory.findAll(PageRequest.of(page, 4));
//		Sort sort = Sort.by("ngayTra").ascending();
//		
//		Pageable pageable = PageRequest.of(ngayTra, 4, sort);
//		
//		return pageable;
//	}
}
