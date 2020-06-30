/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhocvien;

import javax.swing.JDialog;
import qlhv.view.DangNhapJDialog;
import qlhv.view.MainJFrame;

/**
 *
 * @author Viet
 */
public class QuanLyHocVien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        new MainJFrame().setVisible(true);
        DangNhapJDialog dialog = new DangNhapJDialog(null, true);
        dialog.setTitle("ĐĂNG NHẬP HỆ THỐNG");
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
}
