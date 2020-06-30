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
import qlhv.bean.KhoaHocBean;
import qlhv.bean.LopHocBean;

/**
 *
 * @author Viet
 */
public class ThongKeDaoImpl implements ThongKeDAO{

    @Override
    public List<LopHocBean> getListByLopHoc() {
        try {
            List<LopHocBean> list = new ArrayList<>();
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT CAST(MONTH(NgayDangKy) AS VARCHAR(2))+'-'+CAST(YEAR(NgayDangKy) AS VARCHAR(4)) 'NgayDangKy',"
                    + " COUNT(*) AS 'SoLuong' FROM dbo.LOPHOC GROUP BY YEAR(NgayDangKy), MONTH(NgayDangKy) ORDER BY MONTH(NgayDangKy)";
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LopHocBean lhb = new LopHocBean();
                lhb.setNgayDangKy(rs.getString("NgayDangKy"));
                lhb.setSoLuongHocVien(rs.getInt("SoLuong"));
                list.add(lhb);
            }
            rs.close();
            ps.close();
            conn.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT TenKhoaHoc, NgayBatDau, NgayKetThuc FROM dbo.KHOAHOC WHERE TinhTrang =1";
            List<KhoaHocBean> list = new ArrayList<>();
            PreparedStatement ps= conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                KhoaHocBean khb = new KhoaHocBean();
                khb.setTenKhoaHoc(rs.getString("TenKhoaHoc"));
                khb.setNgayBatDau(rs.getDate("NgayBatDau"));
                khb.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                list.add(khb);
            }
            rs.close();
            ps.close();
            conn.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        ThongKeDAO dao = new ThongKeDaoImpl();
//        List<KhoaHocBean> list = dao.getListByKhoaHoc();
//        System.out.println(list);
//    }
}
