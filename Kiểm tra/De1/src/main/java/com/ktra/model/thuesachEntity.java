package com.ktra.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sach")
public class thuesachEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="maSach")
	private int maSach;
	
	@Column(name="tenSach")
	private String tenSach;
	@Column(name="soTrang")
	private String soTrang;
	@Column(name="tacGia")
	private String tacGia;
	@Column(name="ngayMuon")
	private Date ngayMuon;
	@Column(name="ngayTra")
	private Date ngayTra;
	
	public int getMaSach() {
		return maSach;
	}
	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(String soTrang) {
		this.soTrang = soTrang;
	}
	public Date getNgayMuon() {
		return ngayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	@Override
	public String toString() {
		return "thuesachEntity [maSach=" + maSach + ", tenSach=" + tenSach + ", soTrang=" + soTrang + ", tacGia="
				+ tacGia + ", ngayMuon=" + ngayMuon + ", ngayTra=" + ngayTra + "]";
	}
	
}
