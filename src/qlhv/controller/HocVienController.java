/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import qlhv.model.HocVien;
import qlhv.service.HocVienService;
import qlhv.service.HocVienServiceImpl;

/**
 *
 * @author Viet
 */
public class HocVienController {

    private JButton btnSubmit;
    private JTextField jtfMaHocVien;
    private JTextField jtfHoTen;
    private JDateChooser jdcNgaySinh;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private JTextField jtfSoDienThoai;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbTinhTrang;
    private JLabel jlbMsg;

    private HocVien hocVien;
    private HocVienService hocVienService;

    public HocVienController() {
        hocVienService = new HocVienServiceImpl();
    }

    public HocVienController(JButton btnSubmit, JTextField jtfMaHocVien, JTextField jtfHoTen, JDateChooser jdcNgaySinh, JRadioButton jrdNam,
            JRadioButton jrdNu, JTextField jtfSoDienThoai, JTextArea jtaDiaChi, JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;

        hocVienService = new HocVienServiceImpl();
    }

    public void setView(HocVien hocVien) {
        this.hocVien = hocVien;

        jtfMaHocVien.setText(String.valueOf(hocVien.getMaHocVien()));
        jtfHoTen.setText(hocVien.getHoTen());
        jdcNgaySinh.setDate(hocVien.getNgaySinh());
        if (hocVien.isGioiTinh()) {
            jrdNam.setSelected(true);
            jrdNu.setSelected(false);
        } else {
            jrdNam.setSelected(false);
            jrdNu.setSelected(true);
        }
        jtfSoDienThoai.setText(hocVien.getSoDienThoai());
        jtaDiaChi.setText(hocVien.getDiaChi());
        jcbTinhTrang.setSelected(hocVien.isTinhTrang());
    }

    public void setEvent(String type) {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Pattern regexPhone = Pattern.compile("^(0(\\d){9})?$");
                Pattern regexMaHV = Pattern.compile("^\\d+$");

                if (jtfMaHocVien.getText().trim().length() == 0 || jtfHoTen.getText().trim().length() == 0 || jdcNgaySinh.getDate() == null) {
                    jlbMsg.setText("Vui lòng điền dữ liệu bắt buộc!");
                } else if (!regexMaHV.matcher(jtfMaHocVien.getText()).matches()) {
                    jlbMsg.setText("Mã học viên phải là một số!");
                } else if (!regexPhone.matcher(jtfSoDienThoai.getText()).matches()) {
                    jlbMsg.setText("Số điện thoại phải gồm 10 chữ số bắt đầu bằng 0!");
                } else {
//                    if (showDialog()) {
                    hocVien.setMaHocVien(Integer.parseInt(jtfMaHocVien.getText()));
                    hocVien.setHoTen(jtfHoTen.getText().trim());
                    hocVien.setNgaySinh(jdcNgaySinh.getDate());
                    hocVien.setGioiTinh(jrdNam.isSelected());
                    hocVien.setSoDienThoai(jtfSoDienThoai.getText());
                    hocVien.setDiaChi(jtaDiaChi.getText().trim());
                    hocVien.setTinhTrang(jcbTinhTrang.isSelected());

                    int affectedRow = 0;
                    if (type.equalsIgnoreCase("insert")) {
                        affectedRow = hocVienService.insertHocVien(hocVien);
                    } else {
                        affectedRow = hocVienService.updateHocVien(hocVien);
                    }

                    if (affectedRow > 0) {
                        jlbMsg.setText("Cập nhật dữ liệu thành công");
                        jtfMaHocVien.setText("");
                        jtfHoTen.setText("");
                        jtfSoDienThoai.setText("");
                        jtaDiaChi.setText("");
                    } else {
                        jlbMsg.setText("Cập nhật dữ liệu không thành công");
                    }
//                    }
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

//    private boolean showDialog() {
//        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật dữ liệu không?",
//                    "Thông báo", JOptionPane.YES_NO_OPTION);
//        return dialogResult == JOptionPane.YES_NO_OPTION;
//    }
}
