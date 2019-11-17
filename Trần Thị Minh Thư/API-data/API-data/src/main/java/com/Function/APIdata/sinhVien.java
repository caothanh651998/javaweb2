package com.Function.APIdata;

import javax.persistence.*;

@Entity
@Table(name="sinhVien")
public class sinhVien {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public Integer id;
	public String name;
	public String address;
	
	
	
	public sinhVien() {
		super();
	}
	public sinhVien(Integer id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
