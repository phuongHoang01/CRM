package com.CRM_Entity;

import java.sql.Date;

public class Job {
	private int id;
	private String tenCongViec;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenCongViec() {
		return tenCongViec;
	}
	public void setTenCongViec(String tenCongViec) {
		this.tenCongViec = tenCongViec;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	
	public Job(int id,String tenCongViec, Date ngayBatDau, Date ngayKetThuc) {
		this.id = id;
		this.tenCongViec = tenCongViec;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	
	public Job(String tenCongViec, Date ngayBatDau, Date ngayKetThuc) {
		
		this.tenCongViec = tenCongViec;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	
	public Job () {}
//	public Job(String tenCongViec2, java.util.Date ngayBatDau2, java.util.Date ngayKetThuc2) {
//		this.tenCongViec = tenCongViec2;
//		this.ngayBatDau =  ngayBatDau2;
//		this.ngayKetThuc = ngayKetThuc2;
//	}
	
	
	
}
