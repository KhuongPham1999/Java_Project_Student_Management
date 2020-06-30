/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.controller;

import java.util.List;
import javax.swing.JLabel;
import qlhv.service.TrangChuService;
import qlhv.service.TrangChuServiceImpl;

/**
 *
 * @author Viet
 */
public class TrangChuController {
    private JLabel jlbKhoaHoc;
    private JLabel jlbHocVien;
    private JLabel jlbLopHoc;
    private TrangChuService service = null;

    public TrangChuController(JLabel jlbKhoaHoc, JLabel jlbHocVien, JLabel jlbLopHoc) {
        this.jlbKhoaHoc = jlbKhoaHoc;
        this.jlbHocVien = jlbHocVien;
        this.jlbLopHoc = jlbLopHoc;
        service = new TrangChuServiceImpl();
    }
    
    public void setView() {
        List<Integer> list = service.statistical();
        jlbKhoaHoc.setText(list.get(0).toString());
        jlbHocVien.setText(list.get(1).toString());
        jlbLopHoc.setText(list.get(2).toString());
    }
}
