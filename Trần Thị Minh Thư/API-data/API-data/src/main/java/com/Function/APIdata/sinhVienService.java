package com.Function.APIdata;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class sinhVienService {
	@Autowired
	sinhVienDAO service ;
	
	//1. Get All data
	
	public List<sinhVien> getAllDataSinhVien(){
		return service.findAll();
	}
	//2. Get one by ID
	public Optional<sinhVien> getOneSinhVienById(Integer id) {
		return service.findById(id);
	}
	//3. Get All By Name
	public List<sinhVien> getAllSinhVienByName(String name){
		sinhVien sinhvien = new sinhVien();
		sinhvien.setName(name);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
			.withIgnorePaths("id")
			.withIgnorePaths("address");
		
		return service.findAll(Example.of(sinhvien, exampleMatcher));
	}
	//4. insert one
	public void insertOneSinhVien(sinhVien sinhvien) {
		service.save(sinhvien);
	}
	
	//5. insert Many Sinh Vien
	public void insertManySinhVine(List<sinhVien> sinhviens) {
		service.saveAll(sinhviens);
	}
	//6. update one Sinh vien
	public void updateOneSinhVine(sinhVien sinhvien) {
		service.save(sinhvien);
	}
	//7. Check exists
	public boolean checkSinhVienExists(Integer id) {
		return service.existsById(id);
	}
	//8.Delete one sinhvien
	public void deleteOneSinhVien(Integer id) {
		service.deleteById(id);
	}
	//9.delete by name
	public void deleteSinhVienByName(String name) {
		sinhVien sinhvien = new sinhVien();
		sinhvien.setName(name);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnorePaths("address");
		List<sinhVien> sinhviens = service.findAll(Example.of(sinhvien, exampleMatcher));
		service.deleteAll(sinhviens);
	}
	//10.get all sort desc by id 
	public List<sinhVien> getAllSinhVienSortDescById(){
		return service.findAll(Sort.by("id").descending());
	}
	//11. get 10 record on request
	public Page<sinhVien> get10SinhVienByPage(Integer page){
		return service.findAll(PageRequest.of(page, 10));
	}
	//12. get all data by last name
	public List<sinhVien> getAllSinhVienLastName(String lastname){
		sinhVien sinhvien = new sinhVien();
		sinhvien.setName(lastname);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnorePaths("address")
				.withMatcher("name", Math->Math.endsWith());
		return service.findAll(Example.of(sinhvien, exampleMatcher));
	}
	//13. Delete all sinh vien by name and address
	public void deleteAllSinhVienByNameAndAddress(sinhVien sinhvien) {
			ExampleMatcher exampleMatcher = ExampleMatcher.matching()
					.withIgnorePaths("id");
			List<sinhVien> sinhviens = service.findAll(Example.of(sinhvien, exampleMatcher));
			service.deleteAll(sinhviens);
	}
	
	//	14. Update many sinh vien
	public void updateManySinhVien(List<sinhVien> sinhviens) {
		service.saveAll(sinhviens);
	}
	//15. Get all sinh vien by address condition and sort asc by name
	public List<sinhVien> getAllSinhVienByAddressAndSortAscByName(String address){
		sinhVien sinhvien = new sinhVien();
		sinhvien.setAddress(address);
		ExampleMatcher exampleMatCher = ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnorePaths("name");
		return service.findAll(Example.of(sinhvien, exampleMatCher), Sort.by("name").ascending());
	}
	
	
	
	
	
	
	
	
	
}
