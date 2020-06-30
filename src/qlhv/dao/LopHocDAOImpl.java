/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlhv.model.LopHoc;

/**
 *
 * @author Viet
 */
public class LopHocDAOImpl implements LopHocDAO{

    @Override
    public List<LopHoc> getList() {
        List<LopHoc> list = new ArrayList<>();  
        try {
            Connection cons= DBConnect.getConnection();
            String sql="SELECT dbo.LOPHOC.*, TenKhoaHoc,HoTen\n" +
"FROM dbo.LOPHOC JOIN dbo.HOCVIEN ON HOCVIEN.MaHocVien = LOPHOC.MaHocVien JOIN dbo.KHOAHOC ON KHOAHOC.MaKhoaHoc = LOPHOC.MaKhoaHoc\n" +
"ORDER BY MaLopHoc";
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                LopHoc lopHoc= new LopHoc();
                lopHoc.setMaLopHoc(rs.getInt("MaLopHoc"));
                lopHoc.getKhoaHoc().setMaKhoaHoc(rs.getInt("MaKhoaHoc"));
                lopHoc.getKhoaHoc().setTenKhoaHoc(rs.getString("TenKhoaHoc"));
                lopHoc.getHocVien().setMaHocVien(rs.getInt("MaHocVien"));
                lopHoc.getHocVien().setHoTen(rs.getString("HoTen"));
                lopHoc.setNgayDangKy(rs.getDate("NgayDangKy"));
                lopHoc.setTinhTrang(rs.getBoolean("TinhTrang"));
                list.add(lopHoc);
            }
            rs.close();
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
//    public static void main(String[] args) {
//        List<LopHoc> list = new LopHocDAOImpl().getList();
//        list.forEach((item) -> {
//            System.out.println(item);
//        });
//    }

    @Override
    public int insertLopHoc(LopHoc lopHoc) {
        int n=0;
        String sql = "INSERT dbo.LOPHOC VALUES(?,?,?,?,?)";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, lopHoc.getMaLopHoc());
            ps.setInt(2, lopHoc.getKhoaHoc().getMaKhoaHoc());
            ps.setInt(3, lopHoc.getHocVien().getMaHocVien());
            ps.setDate(4, new java.sql.Date(lopHoc.getNgayDangKy().getTime()));
            ps.setBoolean(5, lopHoc.isTinhTrang());
            
            n= ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LopHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
     @Override
    public int updateLopHoc(LopHoc lopHoc) {
        int n=0;
        String sql = "UPDATE dbo.LOPHOC SET NgayDangKy =?, TinhTrang =? WHERE MaLopHoc=? AND MaKhoaHoc =? AND MaHocVien =?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);;
            ps.setDate(1, new java.sql.Date(lopHoc.getNgayDangKy().getTime()));
            ps.setBoolean(2, lopHoc.isTinhTrang());
            ps.setInt(3, lopHoc.getMaLopHoc());
            ps.setInt(4, lopHoc.getKhoaHoc().getMaKhoaHoc());
            ps.setInt(5, lopHoc.getHocVien().getMaHocVien());
            
            n= ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LopHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    @Override
    public int deleteLopHoc(int maLopHoc, int maKhoaHoc) {
        int n = 0;
        String sql= "DELETE dbo.LOPHOC WHERE MaLopHoc =? AND MaKhoaHoc= ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maLopHoc);
            ps.setInt(2, maKhoaHoc);
            
            n= ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LopHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    @Override
    public int deleteLopHoc(int maLopHoc, int maKhoaHoc, int maHocVien) {
        int n = 0;
        Connection conn = DBConnect.getConnection();
        String sql= "DELETE dbo.LOPHOC WHERE MaLopHoc =? AND MaKhoaHoc= ? AND MaHocVien= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maLopHoc);
            ps.setInt(2, maKhoaHoc);
            ps.setInt(3, maHocVien);
            
            n= ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LopHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
