package com.Function.APIdata;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class sinhVienApiController {
	@Autowired
	sinhVienService service;
	
	@RequestMapping(value = "/getAllDataSinhVien")
	public List<sinhVien> getAllDataSinhVien(){
		return service.getAllDataSinhVien();
	}
	@RequestMapping(value = "/getOneSinhVienById")
	public Optional<sinhVien> getOneSinhVienById(@RequestParam(value = "id") Integer id){
		return service.getOneSinhVienById(id);
	}
	@RequestMapping(value = "/getAllSinhVienByName")
	public List<sinhVien> getAllSinhVienByName(@RequestParam(value="name") String name){
		return service.getAllSinhVienByName(name);
	}
	@RequestMapping(value = "/insertOneSinhVien")
	public boolean insertOneSinhVien(@RequestBody sinhVien sinhvien) {
		service.insertOneSinhVien(sinhvien);
		return true;
	}
	@RequestMapping(value = "/insertManySinhVine")
	public boolean insertManySinhVien(@RequestBody List<sinhVien> sinhviens) {
		service.insertManySinhVine(sinhviens);
		return true;
	}
	@RequestMapping(value="/updateOneSinhVien")
	public boolean updateOneSinhVien(@RequestBody sinhVien sinhvien) {
		service.updateOneSinhVine(sinhvien);
		return true;
	}
	@RequestMapping(value="/checkSinhVienExists")
	public boolean checkSinhVienExists(@RequestBody sinhVien sinhvien) {
		return service.checkSinhVienExists(sinhvien.getId());
	}
	@RequestMapping(value="/deleteOneSinhVien")
	public boolean deleteOneSinhVien(@RequestBody sinhVien sinhvien) {
		service.deleteOneSinhVien(sinhvien.getId());
		return true;
	}
	@RequestMapping(value="/deleteSinhVienByName")
	public boolean deleteSinhVienByName(@RequestBody sinhVien sinhvien) {
		service.deleteSinhVienByName(sinhvien.getName());
		return true;
	}
	@RequestMapping(value= "/getAllSinhVienSortDescById")
	public List<sinhVien> getAllSinhVienSortDescById(){
		return service.getAllSinhVienSortDescById();
	}
	
	@RequestMapping(value = "/get10SinhVienByPage")
	public Page<sinhVien> get10SinhVienByPage(@RequestParam(name = "page") Integer page){
		return service.get10SinhVienByPage(page);
		
	}
	@RequestMapping(value = "/getAllSinhVienLastName")
	public List<sinhVien> getAllSinhVienLastName(@RequestBody sinhVien sinhvien){
		return service.getAllSinhVienLastName(sinhvien.getName());
	}
	@RequestMapping(value="/deleteAllSinhVienByNameAndAddress")
	public boolean deleteAllSinhVienByNameAndAddress(@RequestBody sinhVien sinhvien) {
		service.deleteAllSinhVienByNameAndAddress(sinhvien);
		return true;
	}
	@RequestMapping(value = "/updateManySinhVien")
	public boolean updateManySinhVien(@RequestBody List<sinhVien> sinhviens) {
		service.updateManySinhVien(sinhviens);
		return true;
	}
	@RequestMapping(value = "/getAllSinhVienByAddressAndSortAscByName")
	public List<sinhVien> getAllSinhVienByAddressAndSortAscByName(@RequestParam(name="address") String address){
		return service.getAllSinhVienByAddressAndSortAscByName(address);
	}
	
	
}
