/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import qlhv.model.KhoaHoc;

/**
 *
 * @author Viet
 */
public class KhoaHocTableModel {
    public DefaultTableModel setTableModel(List<KhoaHoc> listItem, String[] listColumn) {
        DefaultTableModel dtm= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex==6? Boolean.class : String.class;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns= listColumn.length;
        int rows= listItem.size();
        dtm.setColumnCount(columns);
        Object[] obj;
        if(rows>0) {
            for (int i = 0; i < rows; i++) {
                obj = new Object[columns];
                KhoaHoc khoaHoc = listItem.get(i);
                obj[0] = (i+1)+"";
                obj[1] = khoaHoc.getMaKhoaHoc()+"";
                obj[2] = khoaHoc.getTenKhoaHoc();
                obj[3] = khoaHoc.getMoTa();
                obj[4] = khoaHoc.getNgayBatDau()+"";
                obj[5] = khoaHoc.getNgayKetThuc()+"";
                obj[6] = khoaHoc.isTinhTrang();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
    
}
