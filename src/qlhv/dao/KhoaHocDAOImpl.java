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
import qlhv.model.KhoaHoc;

/**
 *
 * @author Viet
 */
public class KhoaHocDAOImpl implements KhoaHocDAO {

    @Override
    public List<KhoaHoc> getList() {
        List<KhoaHoc> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT* FROM dbo.KHOAHOC";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHoc khoaHoc = new KhoaHoc();
                khoaHoc.setMaKhoaHoc(rs.getInt("MaKhoaHoc"));
                khoaHoc.setTenKhoaHoc(rs.getString("TenKhoaHoc"));
                khoaHoc.setMoTa(rs.getString("MoTa"));
                khoaHoc.setNgayBatDau(rs.getDate("NgayBatDau"));
                khoaHoc.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                khoaHoc.setTinhTrang(rs.getBoolean("TinhTrang"));
                list.add(khoaHoc);
            }
            rs.close();
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insertKhoaHoc(KhoaHoc khoaHoc) {
        int n = 0;
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO KHOAHOC VALUES(?,?,?,?,?,?)";
        try {
            CallableStatement ps = conn.prepareCall(sql);
            ps.setInt(1, khoaHoc.getMaKhoaHoc());
            ps.setString(2, khoaHoc.getTenKhoaHoc());
            ps.setString(3, khoaHoc.getMoTa());
            ps.setDate(4, new java.sql.Date(khoaHoc.getNgayBatDau().getTime()));
            ps.setDate(5, new java.sql.Date(khoaHoc.getNgayKetThuc().getTime()));
            ps.setBoolean(6, khoaHoc.isTinhTrang());

            n = ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    @Override
    public int updateKhoaHoc(KhoaHoc khoaHoc) {
        int n = 0;
        String sql = "UPDATE dbo.KHOAHOC SET TenKhoaHoc=?, MoTa=?, NgayBatDau=?, NgayKetThuc=?, TinhTrang=? WHERE MaKhoaHoc=?";
        Connection conn = DBConnect.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, khoaHoc.getTenKhoaHoc());
            ps.setString(2, khoaHoc.getMoTa());
            ps.setDate(3, new java.sql.Date(khoaHoc.getNgayBatDau().getTime()));
            ps.setDate(4, new java.sql.Date(khoaHoc.getNgayKetThuc().getTime()));
            ps.setBoolean(5, khoaHoc.isTinhTrang());
            ps.setInt(6, khoaHoc.getMaKhoaHoc());
            n = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

//    public static void main(String[] args) {
//        List<KhoaHoc> list= new KhoaHocDAOImpl().getList();
//        list.forEach((t) -> {
//            System.out.println(t+"\n");
//        });
//    }
    @Override
    public int deleteKhoaHoc(KhoaHoc khoaHoc) {
        int n = 0;
        Connection conn = DBConnect.getConnection();
        String sql = "DELETE dbo.KHOAHOC WHERE MaKhoaHoc = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, khoaHoc.getMaKhoaHoc());
            n = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    
}
