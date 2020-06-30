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

/**
 *
 * @author Viet
 */
public class TrangChuDAOImpl implements TrangChuDAO{

    @Override
    public List<Integer> statistical() {
        List<Integer> list = null;
        Connection conn = null;
        String sql = "SELECT (SELECT COUNT(*) FROM dbo.KHOAHOC) 'SoKhoaHoc', (SELECT COUNT(*) FROM dbo.HOCVIEN) 'SoHocVien', COUNT(MaLopHoc+LOPHOC.MaKhoaHoc) 'SoLopHoc'\n"
                + "FROM dbo.LOPHOC";
        try {
            conn = DBConnect.getConnection();
            list = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list.add(rs.getInt("SoKhoaHoc"));
                list.add(rs.getInt("SoHocVien"));
                list.add(rs.getInt("SoLopHoc"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrangChuDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
//    
//    public static void main(String[] args) {
//        TrangChuDAO dao = new TrangChuDAOImpl();
//        List<Integer> list = dao.statistical();
//        System.out.println(list);
//    }
}
