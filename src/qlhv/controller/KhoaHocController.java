package qlhv.controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import qlhv.model.KhoaHoc;
import qlhv.service.KhoaHocService;
import qlhv.service.KhoaHocServiceImpl;

/**
 *
 * @author Viet
 */
public class KhoaHocController {
    private JTextField jtfMaKhoaHoc;
    private JTextField jtfTenKhoaHoc;
    private JDateChooser jdcNgayBatDau;
    private JDateChooser jdcNgayKetThuc;
    private JCheckBox jcbTinhTrang;
    private JTextArea jtaMota;
    private JButton btnSubmit;
    private JLabel jlbMsg;
    
    private KhoaHoc khoaHoc;
    private KhoaHocService khoaHocService;

    public KhoaHocController() {
    }

    public KhoaHocController(JTextField jtfMaKhoaHoc, JTextField jtfTenKhoaHoc, JDateChooser jdcNgayBatDau, JDateChooser jdcNgayKetThuc, JCheckBox jcbTinhTrang, JTextArea jtaMota, JButton btnSubmit, JLabel jlbMsg) {
        this.jtfMaKhoaHoc = jtfMaKhoaHoc;
        this.jtfTenKhoaHoc = jtfTenKhoaHoc;
        this.jdcNgayBatDau = jdcNgayBatDau;
        this.jdcNgayKetThuc = jdcNgayKetThuc;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jtaMota = jtaMota;
        this.btnSubmit = btnSubmit;
        this.jlbMsg = jlbMsg;
        
        khoaHocService= new KhoaHocServiceImpl();
    }

    
    
    public void setView(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
        jtfMaKhoaHoc.setText(String.valueOf(khoaHoc.getMaKhoaHoc()));
        jtfTenKhoaHoc.setText(khoaHoc.getTenKhoaHoc());
        jdcNgayBatDau.setDate(khoaHoc.getNgayBatDau());
        jdcNgayKetThuc.setDate(khoaHoc.getNgayKetThuc());
        jcbTinhTrang.setSelected(khoaHoc.isTinhTrang());
        jtaMota.setText(khoaHoc.getMoTa());
    }
    
    public void setEvent(String type) {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Pattern regexMaKh = Pattern.compile("^\\d+$");
                if (jtfMaKhoaHoc.getText().trim().length() == 0 || jtfTenKhoaHoc.getText().trim().length() == 0
                        || jdcNgayBatDau.getDate() == null || jdcNgayKetThuc.getDate() == null) {
                    jlbMsg.setText("Vui lòng điền các thông tin bắt buộc");
                } else if(!regexMaKh.matcher(jtfMaKhoaHoc.getText()).matches()) {
                    jlbMsg.setText("Mã khóa học phải là một số");
                } else {
//                    if (showDialog()) {
                    khoaHoc.setMaKhoaHoc(Integer.parseInt(jtfMaKhoaHoc.getText().trim()));
                    khoaHoc.setTenKhoaHoc(jtfTenKhoaHoc.getText().trim());
                    khoaHoc.setMoTa(jtaMota.getText().trim());
                    khoaHoc.setNgayBatDau(jdcNgayBatDau.getDate());
                    khoaHoc.setNgayKetThuc(jdcNgayKetThuc.getDate());
                    khoaHoc.setTinhTrang(jcbTinhTrang.isSelected());
                    int affectedRow = 0;
                    if (type.equalsIgnoreCase("insert")) {
                        affectedRow = khoaHocService.insertKhoaHoc(khoaHoc);
                    } else {
                        affectedRow = khoaHocService.updateKhoaHoc(khoaHoc);
                    }

                    if (affectedRow > 0) {
                        jlbMsg.setText("Cập nhật dữ liệu thành công");
                        jtfMaKhoaHoc.setText("");
                        jtfTenKhoaHoc.setText("");
                        jtaMota.setText("");
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
    
//    public boolean showDialog() {
//        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn cập nhật dữ liệu?", "Thông báo", 
//                JOptionPane.YES_NO_OPTION);
//        return dialogResult == JOptionPane.YES_OPTION;
//    }
}
