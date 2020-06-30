/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import qlhv.model.TaiKhoan;
import qlhv.service.TaiKhoanService;
import qlhv.service.TaiKhoanServiceImpl;
import qlhv.view.MainJFrame;

/**
 *
 * @author Viet
 */
public class TaiKhoanController {
    private JDialog dialog;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JPasswordField jpwMatKhau;
    private JLabel jlbMsg;
    
    private TaiKhoanService taiKhoanService = null;

    public TaiKhoanController(JDialog dialog, JButton btnSubmit, JTextField jtfTenDangNhap, JPasswordField jpwMatKhau, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jpwMatKhau = jpwMatKhau;
        this.jlbMsg = jlbMsg;
        taiKhoanService = new TaiKhoanServiceImpl();
    }

   
    
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfTenDangNhap.getText().length() == 0 || jpwMatKhau.getPassword().length == 0) {
                    jlbMsg.setText("Vui lòng điền đầy đủ thông tin!");
                } else {
                    TaiKhoan taiKhoan = taiKhoanService.login(jtfTenDangNhap.getText(), String.valueOf(jpwMatKhau.getPassword()));
                    if (taiKhoan == null) {
                        jlbMsg.setText("Tên đăng nhập hoặc mật khẩu không đúng!");
                    } else {
                        if (taiKhoan.isTinhTrang()) {
                            dialog.dispose();
                            MainJFrame frame = new MainJFrame();
//                        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            frame.setVisible(true);
                        } else {
                            jlbMsg.setText("Tài khoản đã bị vô hiệu hoá!");
                        }
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 153, 0));
            }
        });
    }
}
