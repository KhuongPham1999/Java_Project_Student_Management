/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.model;

/**
 *
 * @author Viet
 */
public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    private boolean tinhTrang;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDangNhap, String matKhau, boolean tinhTrang) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.tinhTrang = tinhTrang;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    
}
