/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlhv.model.HocVien;

/**
 *
 * @author Viet
 */
public class HocVienDAOImpl implements HocVienDAO {

    @Override
    public List<HocVien> getList() {
        Connection conn;
        try {
            conn = DBConnect.getConnection();
            String sql;
            sql = "SELECT* FROM dbo.HOCVIEN";
            List<HocVien> list = new ArrayList<>();
            try (
                    PreparedStatement ps = conn.prepareCall(sql);
                    ResultSet rs = ps.executeQuery()) { //duy trì một con trỏ trỏ đến một hàng của một bảng. Ban đầu, con trỏ trỏ đến hàng đầu tiên
                while (rs.next()) {
                    HocVien hocVien = new HocVien();
                    hocVien.setMaHocVien(rs.getInt("MaHocVien"));
                    hocVien.setHoTen(rs.getString("HoTen"));
                    hocVien.setNgaySinh(rs.getDate("NgaySinh"));
                    hocVien.setGioiTinh(rs.getBoolean("GioiTinh"));
                    hocVien.setSoDienThoai(rs.getString("SoDienThoai"));
                    hocVien.setDiaChi(rs.getString("DiaChi"));
                    hocVien.setTinhTrang(rs.getBoolean("TinhTrang"));
                    list.add(hocVien);
                }
                ps.close();
                rs.close();
                conn.close();
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(HocVienDAOImpl.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    @Override
    public int insertHocVien(HocVien hocVien) {
        int n = 0;
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "INSERT dbo.HOCVIEN VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hocVien.getMaHocVien());
            ps.setString(2, hocVien.getHoTen());
            ps.setDate(3, new java.sql.Date(hocVien.getNgaySinh().getTime()));
            ps.setBoolean(4, hocVien.isGioiTinh());
            ps.setString(5, hocVien.getSoDienThoai());
            ps.setString(6, hocVien.getDiaChi());
            ps.setBoolean(7, hocVien.isTinhTrang());

            n = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HocVienDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    @Override
    public int updateHocVien(HocVien hocVien) {
        int n = 0;
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "UPDATE dbo.HOCVIEN SET HoTen=?, NgaySinh=?,GioiTinh=?, SoDienThoai=?, DiaChi= ?, TinhTrang=? WHERE MaHocVien =?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hocVien.getHoTen());
            ps.setDate(2, new java.sql.Date(hocVien.getNgaySinh().getTime()));
            ps.setBoolean(3, hocVien.isGioiTinh());
            ps.setString(4, hocVien.getSoDienThoai());
            ps.setString(5, hocVien.getDiaChi());
            ps.setBoolean(6, hocVien.isTinhTrang());
            ps.setInt(7, hocVien.getMaHocVien());

            n = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HocVienDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    @Override
    public int deleteHocVien(HocVien hocVien) {
        int n = 0;

        try {
            Connection conn = DBConnect.getConnection();
            String sql = "DELETE dbo.HOCVIEN WHERE MaHocVien=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hocVien.getMaHocVien());
            n = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HocVienDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

//    public static void main(String[] args) {
//        HocVienDAO hocVienDao = new HocVienDAOImpl();
//        System.out.println(hocVienDao.getList());
//    }
}
