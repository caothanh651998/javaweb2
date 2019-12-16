package com.thuexe.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xe")
public class ThuexeEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	
	@Column(name= "noidi")
	String noidi;
	
	@Column(name= "noiden")
	String noiden;
	
	@Column(name= "ngaydi")
	Date ngaydi;
	
	@Column(name= "giodi")
	String giodi;
	
	@Column(name= "gioden")
	String gioden;
	
	@Column(name= "giatien")
	String giatien;
	
	@Column(name= "soghe")
	String soghe;
	
	public ThuexeEntity() {
		super();
	}

	public ThuexeEntity(String noidi, String noiden, Date ngaydi, String giodi, String gioden, String giatien,
			String soghe) {
		super();
		this.noidi = noidi;
		this.noiden = noiden;
		this.ngaydi = ngaydi;
		this.giodi = giodi;
		this.gioden = gioden;
		this.giatien = giatien;
		this.soghe = soghe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoidi() {
		return noidi;
	}

	public void setNoidi(String noidi) {
		this.noidi = noidi;
	}

	public String getNoiden() {
		return noiden;
	}

	public void setNoiden(String noiden) {
		this.noiden = noiden;
	}

	public Date getNgaydi() {
		return ngaydi;
	}

	public void setNgaydi(Date ngaydi) {
		this.ngaydi = ngaydi;
	}

	public String getGiodi() {
		return giodi;
	}

	public void setGiodi(String giodi) {
		this.giodi = giodi;
	}

	public String getGioden() {
		return gioden;
	}

	public void setGioden(String gioden) {
		this.gioden = gioden;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getSoghe() {
		return soghe;
	}

	public void setSoghe(String soghe) {
		this.soghe = soghe;
	}

	@Override
	public String toString() {
		return "ThuexeEntity [id=" + id + ", noidi=" + noidi + ", noiden=" + noiden + ", ngaydi=" + ngaydi + ", giodi="
				+ giodi + ", gioden=" + gioden + ", giatien=" + giatien + ", soghe=" + soghe + " ]";
	}
	
	
}
