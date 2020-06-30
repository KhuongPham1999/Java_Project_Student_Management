/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import qlhv.model.HocVien;

/**
 *
 * @author Viet
 */
public class HocVienTableModel {
    public DefaultTableModel setTableModel(List<HocVien> listItem, String[] listColumn) {
        
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {    //dòng này để không cho phép chỉnh sửa dữ liệu trong ô
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex ==7 ? Boolean.class: String.class;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn); //dòng này định nghĩa tên cột từ danh sách cột(String[])
        int columns = listColumn.length;
        int rows= listItem.size();
        Object[] obj;
        if(rows>0){
            for (int i = 0; i < rows; i++) {
                HocVien hocVien = listItem.get(i);
                obj= new Object[columns];
                obj[0]= String.valueOf(i+1);  //Lấy ra số thứ tự
                obj[1]= String.valueOf(hocVien.getMaHocVien());
                obj[2]= hocVien.getHoTen();
                obj[3]= String.valueOf(hocVien.getNgaySinh());
                obj[4]= hocVien.isGioiTinh()==true? "Nam":"Nữ";
                obj[5]= hocVien.getSoDienThoai();
                obj[6]= hocVien.getDiaChi();
                obj[7]= hocVien.isTinhTrang();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
