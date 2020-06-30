/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.model;

import java.util.Date;

/**
 *
 * @author Viet
 */
public class KhoaHoc {
    private int maKhoaHoc;
    private String tenKhoaHoc;
    private String moTa;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private boolean tinhTrang;

    public KhoaHoc() {
        tinhTrang=true;
    }

    public KhoaHoc(int maKhoaHoc, String tenKhoaHoc, String moTa, Date ngayBatDau, Date ngayKetThuc, boolean tinhTrang) {
        this.maKhoaHoc = maKhoaHoc;
        this.tenKhoaHoc = tenKhoaHoc;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.tinhTrang = tinhTrang;
    }
    

    public int getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(int maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "KhoaHoc{" + "maKhoaHoc=" + maKhoaHoc + ", tenKhoaHoc=" + tenKhoaHoc + ", moTa=" + moTa + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", tinhTrang=" + tinhTrang + '}';
    }
    
    
}
