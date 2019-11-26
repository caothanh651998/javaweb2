package com.ktra.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ktra.model.thuesachEntity;
import com.ktra.service.thuesachService;

@RestController
public class ThueSachController {
	
	@Autowired
	thuesachService thuesachService;

	@RequestMapping("/record")
	public List<thuesachEntity> getAll(){
		return thuesachService.getAll();
		
	}
	
	@RequestMapping("/insert")
	public thuesachEntity insert(@RequestBody thuesachEntity entity) {
		return thuesachService.insert(entity);
	}
	
	@RequestMapping("/getByName")
	public List<thuesachEntity> getByName(@RequestParam(name="tacGia") String tacGia){
		return thuesachService.getByname(tacGia);
		
	}
	
	@RequestMapping("/update/{maSach}")
	public thuesachEntity update(@PathVariable int maSach, @RequestBody thuesachEntity entity) {
		return thuesachService.update(entity);
	}
	
	@RequestMapping("/date")
	public Page<thuesachEntity> getByDate(@RequestParam Integer ngayTra){
		
		return thuesachService.sapxe(ngayTra);
	}
	
}
