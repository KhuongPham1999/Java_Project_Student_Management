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
public class LopHoc {
    private int maLopHoc;
    private KhoaHoc khoaHoc;
    private HocVien hocVien;
    private Date ngayDangKy;
    private boolean tinhTrang;

    public LopHoc() {
        tinhTrang=true;
        khoaHoc = new KhoaHoc();
        hocVien = new HocVien();
    }

    public LopHoc(int maLopHoc, KhoaHoc khoaHoc, HocVien hocVien, Date ngayDangKy, boolean tinhTrang) {
        this.maLopHoc = maLopHoc;
        this.khoaHoc = khoaHoc;
        this.hocVien = hocVien;
        this.ngayDangKy = ngayDangKy;
        this.tinhTrang = tinhTrang;
    }

    
    public int getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(int maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
    @Override
    public String toString() {
        return "LopHoc{" + "maLopHoc=" + maLopHoc + ", khoaHoc=" + khoaHoc.getMaKhoaHoc() + ", hocVien=" + hocVien.getMaHocVien()
                + ", ngayDangKy=" + ngayDangKy + ", tinhTrang=" + tinhTrang + '}';
    }
    
}
