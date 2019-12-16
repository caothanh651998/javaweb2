package com.thuexe.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.thuexe.entity.ThuexeDto;
import com.thuexe.entity.ThuexeEntity;
import com.thuexe.reponsitory.ThuexeReponsitory;

@Service
public class ThuexeService {

	@Autowired
	ThuexeReponsitory thuexeReponsitory;

	@Cacheable("thuexe")
	public List<ThuexeDto>  getDS(){
		List<ThuexeDto> listTXDto = new ArrayList<>();
		List<ThuexeEntity> listTX = (List<ThuexeEntity>) thuexeReponsitory.findAll();
		for (ThuexeEntity thueXe : listTX) {
			ThuexeDto thueXeDto = new ThuexeDto();
			thueXeDto.setId(thueXe.getId());
			thueXeDto.setNoidi(thueXe.getNoidi());
			thueXeDto.setNoiden(thueXe.getNoiden());
			thueXeDto.setNgaydi(thueXe.getNgaydi());
			thueXeDto.setGiodi(thueXe.getGiodi());
			thueXeDto.setGioden(thueXe.getGioden());
			thueXeDto.setGiatien(thueXe.getGiatien());
			thueXeDto.setSoghe(thueXe.getSoghe());
			thueXeDto.setThoigiandi((Integer.parseInt(thueXe.getGioden()) - Integer.parseInt(thueXe.getGiodi())) + "");
			
			listTXDto.add(thueXeDto);
		}
		
		return listTXDto;
	}
	
	public List<ThuexeEntity> search(String noidi,String noiden,  Date ngaydi){
//		return thuexeReponsitory.findByNoidiOrNoiden(noidi,noiden);
		ThuexeEntity thuexe = new ThuexeEntity();
		thuexe.setNoidi(noidi);
		thuexe.setNoiden(noiden);
		thuexe.setNgaydi(ngaydi);
		
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnorePaths("noidi").withIgnorePaths("noiden")
				.withIgnorePaths("ngaydi").withIgnorePaths("giodi").withIgnorePaths("gioden").withIgnorePaths("giatien").withIgnorePaths("soghe");
		return thuexeReponsitory.findAll(Example.of(thuexe,exampleMatcher));
	}
	
	public void xoa(Integer id) {
//		Optional<ThuexeEntity> thuexe= thuexeReponsitory.findById(id);
		 thuexeReponsitory.deleteById(id);
	}
	
	public void delByDate(Date ngaydi) {
		ThuexeEntity tx = new ThuexeEntity();
		tx.setNgaydi(ngaydi);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnorePaths("noidi").withIgnorePaths("noiden")
				.withIgnorePaths("ngaydi").withIgnorePaths("giodi").withIgnorePaths("gioden").withIgnorePaths("giatien").withIgnorePaths("soghe");
		List<ThuexeEntity> thuexe = thuexeReponsitory.findAll(Example.of(tx,exampleMatcher));
		thuexeReponsitory.deleteAll(thuexe);
	}
	
	public ThuexeEntity update(ThuexeEntity entity) {
		Optional<ThuexeEntity> thuexe= thuexeReponsitory.findById(entity.getId());

		ThuexeEntity newEntity = thuexe.get();
		newEntity.setId(entity.getId());
		newEntity.setGiodi(entity.getGiodi());
		newEntity.setGioden(entity.getGioden());
		newEntity.setNgaydi(entity.getNgaydi());
		newEntity.setGiatien(entity.getGiatien());
		newEntity.setSoghe(entity.getSoghe());
		
		newEntity= thuexeReponsitory.save(newEntity);
		return newEntity;
	}
	
	public Optional<ThuexeEntity> edit(Integer id) {
		return thuexeReponsitory.findById(id);
	}
	
	public void save(ThuexeEntity entity) {
		thuexeReponsitory.save(entity);
	}
	
	public List<ThuexeEntity> getSortGia(){
		return thuexeReponsitory.findAll(Sort.by("giatien").descending());
	}
	
	public List<ThuexeEntity> getSortGiaT(){
		return thuexeReponsitory.findAll(Sort.by("giatien").ascending());
	}
	
	public List<ThuexeEntity> getSortDate(){
		return thuexeReponsitory.findAll(Sort.by("ngaydi").descending());
		
	}
	
	public List<ThuexeEntity> getSortDateT(){
		return thuexeReponsitory.findAll(Sort.by("ngaydi").ascending());
		
	}
}
