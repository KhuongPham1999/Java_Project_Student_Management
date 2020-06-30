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
import java.util.logging.Level;
import java.util.logging.Logger;
import qlhv.model.TaiKhoan;

/**
 *
 * @author Viet
 */
public class TaiKhoanDAOImpl implements TaiKhoanDAO{

    @Override
    public TaiKhoan login(String tdn, String mk) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT* FROM dbo.TAIKHOAN WHERE TenDangNhap LIKE ? AND MatKhau LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tdn);
            ps.setString(2, mk);
            
            ResultSet rs = ps.executeQuery();
            TaiKhoan taiKhoan = null;
            if(rs.next()) {
                taiKhoan = new TaiKhoan();
                taiKhoan.setTenDangNhap(rs.getString("TenDangNhap"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                taiKhoan.setTinhTrang(rs.getBoolean("TinhTrang"));  
            }
            rs.close();
            ps.close();
            conn.close();
            return taiKhoan;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
