/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.bean;

/**
 *
 * @author Viet
 */
public class LopHocBean {
    private String ngayDangKy;
    private int soLuongHocVien;

    public LopHocBean() {
    }

    public LopHocBean(String ngayDangKy, int soLuongHocVien) {
        this.ngayDangKy = ngayDangKy;
        this.soLuongHocVien = soLuongHocVien;
    }

    public String getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public int getSoLuongHocVien() {
        return soLuongHocVien;
    }

    public void setSoLuongHocVien(int soLuongHocVien) {
        this.soLuongHocVien = soLuongHocVien;
    }

    @Override
    public String toString() {
        return "LopHocBean{" + "ngayDangKy=" + ngayDangKy + ", soLuongHocVien=" + soLuongHocVien + '}';
    }
    
}
