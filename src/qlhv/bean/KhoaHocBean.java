/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.bean;

import java.util.Date;

/**
 *
 * @author Viet
 */
public class KhoaHocBean {
    private String tenKhoaHoc;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public KhoaHocBean() {
    }

    public KhoaHocBean(String tenKhoaHoc, Date ngayBatDau, Date ngayKetThuc) {
        this.tenKhoaHoc = tenKhoaHoc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
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

    @Override
    public String toString() {
        return "KhoaHocBean{" + "tenKhoaHoc=" + tenKhoaHoc + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + '}';
    }
    
}
