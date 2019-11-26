package com.d1;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class ValidateForm {
    @NotNull
    @Size(min = 1, max = 5, message="Số ký tự tối đa là 5 và không được để trống")
    String maSach;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @FutureOrPresent(message="Ngày trả phải là ngày hiện tại hoặc tương lại")
    Date ngayMuon;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Future(message="Ngày trả phải là ngày hiện tại hoặc tương lại")
    Date ngayTra;
    
    
    @NotNull 
    @Min(value=51,message="Số trang phải lớn hơn 50")
    int PositiveMax;
    
    @Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")
	String tacGia;

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public int getPositiveMax() {
		return PositiveMax;
	}

	public void setPositiveMax(int positiveMax) {
		PositiveMax = positiveMax;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public Date getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	@Override
	public String toString() {
		return "ValidateForm [maSach=" + maSach + ", ngayMuon=" + ngayMuon + ", ngayTra=" + ngayTra + ", PositiveMax="
				+ PositiveMax + ", tacGia=" + tacGia + "]";
	}
	
	
    
}
