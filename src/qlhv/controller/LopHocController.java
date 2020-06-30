/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.controller;

import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import qlhv.model.LopHoc;
import qlhv.service.LopHocService;
import qlhv.service.LopHocServiceImpl;

/**
 *
 * @author Viet
 */
public class LopHocController {
    private JLabel jlbMsg;
    private JButton btnSubmit;
    private JTextField jtfMaLopHoc;
    private JTextField jtfMaHocVien;
    private JTextField jtfMaKhoaHoc;
    private JDateChooser jdcNgayDangKy;
    private JCheckBox jcbTinhTrang;
    private LopHoc lopHoc;
    private LopHocService lopHocService;

    public LopHocController(JLabel jlbMsg, JButton btnSubmit, JTextField jtfMaLopHoc, JTextField jtfMaHocVien, JTextField jtfMaKhoaHoc, JDateChooser jdcNgayDangKy, JCheckBox jcbTinhTrang) {
        this.jlbMsg = jlbMsg;
        this.btnSubmit = btnSubmit;
        this.jtfMaLopHoc = jtfMaLopHoc;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jtfMaKhoaHoc = jtfMaKhoaHoc;
        this.jdcNgayDangKy = jdcNgayDangKy;
        this.jcbTinhTrang = jcbTinhTrang;
        lopHocService = new LopHocServiceImpl();
    }
    
    public void setView(LopHoc lopHoc) {
        this.lopHoc = lopHoc;
        jtfMaLopHoc.setText(String.valueOf(lopHoc.getMaLopHoc()));
        jtfMaKhoaHoc.setText(String.valueOf(lopHoc.getKhoaHoc().getMaKhoaHoc()));
        jtfMaHocVien.setText(String.valueOf(lopHoc.getHocVien().getMaHocVien()));
        jdcNgayDangKy.setDate(lopHoc.getNgayDangKy());
        jcbTinhTrang.setSelected(lopHoc.isTinhTrang());
    }
    
    public void setEvent(String type) {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfMaHocVien.getText().trim().length() == 0 || jtfMaLopHoc.getText().trim().length() == 0
                        || jtfMaKhoaHoc.getText().trim().length() == 0 || jdcNgayDangKy.getDate() == null) {
                    jlbMsg.setText("Vui lòng điền dữ liệu bắt buộc!");
                } else {
                    if(showDialog()) {
                        lopHoc.setMaLopHoc(Integer.parseInt(jtfMaLopHoc.getText()));
                        lopHoc.getKhoaHoc().setMaKhoaHoc(Integer.parseInt(jtfMaKhoaHoc.getText()));
                        lopHoc.getHocVien().setMaHocVien(Integer.parseInt(jtfMaHocVien.getText()));
                        lopHoc.setNgayDangKy(jdcNgayDangKy.getDate());
                        lopHoc.setTinhTrang(jcbTinhTrang.isSelected());
                        
                        int affectedRow =0;
                        if(type.equalsIgnoreCase("insert")) {
                            affectedRow = lopHocService.insertLopHoc(lopHoc);
                        } else {
                            affectedRow = lopHocService.updateLopHoc(lopHoc);
                        }
                        
                        if(affectedRow>0) {
                            jlbMsg.setText("Cập nhật dữ liệu thành công.");
                        } else {
                            jlbMsg.setText("Cập nhật dữ liệu không thành công!");
                        }
                    }
                }
            }
            
        });
    }
    
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật dữ liệu không?",
                    "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_NO_OPTION;
    }
}
