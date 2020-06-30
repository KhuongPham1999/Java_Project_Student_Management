/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import qlhv.model.LopHoc;

/**
 *
 * @author Viet
 */
public class LopHocTableModel {
    public DefaultTableModel setTableModel(List<LopHoc> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex==7? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int rows= listItem.size();
        int columns= listColumn.length;
        dtm.setColumnCount(columns);
        Object[] obj;
        if(rows>0) {
            for (int i = 0; i < rows; i++) {
                LopHoc lopHoc=listItem.get(i);
                obj= new Object[columns];
                obj[0]=(i+1)+"";
                obj[1]=lopHoc.getMaLopHoc()+"";
                obj[2]=lopHoc.getKhoaHoc().getMaKhoaHoc()+"";
                obj[3]=lopHoc.getKhoaHoc().getTenKhoaHoc();
                obj[4]=lopHoc.getHocVien().getMaHocVien()+"";
                obj[5]=lopHoc.getHocVien().getHoTen();
                obj[6]=lopHoc.getNgayDangKy()+"";
                obj[7]=lopHoc.isTinhTrang();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
