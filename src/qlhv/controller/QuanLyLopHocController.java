/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import qlhv.model.LopHoc;
import qlhv.service.LopHocService;
import qlhv.service.LopHocServiceImpl;
import qlhv.utility.LopHocTableModel;
import qlhv.view.LopHocJFrame;

/**
 *
 * @author Viet
 */
public class QuanLyLopHocController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private String[] listColumn={"STT","Mã lớp học","Mã khoá học","Tên khoá học","Mã học viên","Tên học viên",
        "Ngày đăng ký","Tình trạng"};
    private LopHocService lopHocService;
    private JButton btnRefresh;
    private JButton btnDeleteHocVien;
    private JButton btnDeleteLopHoc;
    private JTable table;

    public QuanLyLopHocController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JButton btnRefresh, JButton btnDeleteHocVien, JButton btnDeleteLopHoc) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.btnRefresh = btnRefresh;
        this.btnDeleteHocVien = btnDeleteHocVien;
        this.btnDeleteLopHoc = btnDeleteLopHoc;
        this.lopHocService = new LopHocServiceImpl();
    }

  
    
    public void setDataToTable() {
        List<LopHoc> listItem= lopHocService.getList();
        DefaultTableModel model = new LopHocTableModel().setTableModel(listItem, listColumn);
        table = new JTable(model);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
    
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    int selectedRowIndex = table.getSelectedRow();
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    
                    LopHoc lopHoc = new LopHoc();
                    lopHoc.setMaLopHoc((Integer.parseInt(model.getValueAt(selectedRowIndex, 1).toString())));
                    lopHoc.getKhoaHoc().setMaKhoaHoc(Integer.parseInt(model.getValueAt(selectedRowIndex, 2).toString()));
                    lopHoc.getHocVien().setMaHocVien(Integer.parseInt(model.getValueAt(selectedRowIndex, 4).toString()));
                    
                    String stringDate = model.getValueAt(selectedRowIndex, 6).toString();
                    try {
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
                        lopHoc.setNgayDangKy(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(QuanLyLopHocController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    lopHoc.setTinhTrang((boolean) model.getValueAt(selectedRowIndex, 7));
                    
                    LopHocJFrame frame = new LopHocJFrame(lopHoc, "update");
                    frame.setTitle("Thông tin lớp học");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }

        });
        
        table.getColumn("STT").setMaxWidth(50);
        table.getColumn("STT").setMinWidth(50);
        table.getColumn("Mã lớp học").setMaxWidth(120);
        table.getColumn("Mã lớp học").setMinWidth(120);
        table.getColumn("Mã khoá học").setMaxWidth(120);
        table.getColumn("Mã khoá học").setMinWidth(120);
        table.getColumn("Mã học viên").setMaxWidth(120);
        table.getColumn("Mã học viên").setMinWidth(120);
        table.getColumn("Ngày đăng ký").setMaxWidth(150);
        table.getColumn("Ngày đăng ký").setMinWidth(150);
        table.getColumn("Tình trạng").setMaxWidth(100);
        table.getColumn("Tình trạng").setMinWidth(100);
        table.getColumn("Tên học viên").setMinWidth(200);
        table.getColumn("Tên khoá học").setMinWidth(250);
        
        JScrollPane scrollPane= new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.getViewport().setPreferredSize(new Dimension(1400, 400));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
        
        TableRowSorter rowSorter= new TableRowSorter(model);
        table.setRowSorter(rowSorter);
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text= jtfSearch.getText();
                if(text.trim().length()==0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text= jtfSearch.getText();
                if(text.trim().length()==0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LopHocJFrame frame = new LopHocJFrame(new LopHoc(),"insert");
                frame.setTitle("Thông tin lớp học");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200,83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(0,153,0));
            }
        });
        
        btnDeleteLopHoc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                selectedRow = table.convertRowIndexToModel(selectedRow);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                if(selectedRow != -1 && showDialog("Xoá lớp học?")) {
                    int maLopHoc = Integer.parseInt(model.getValueAt(selectedRow, 1).toString());
                    int maKhoaHoc = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());
                    lopHocService.deleteLopHoc(maLopHoc, maKhoaHoc);
                    setDataToTable();
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                btnDeleteLopHoc.setBackground(new Color(102,102,102));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDeleteLopHoc.setBackground(new Color(153,153,153));
            }
            
        });
        
        btnDeleteHocVien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                selectedRow = table.convertRowIndexToModel(selectedRow);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                if(selectedRow != -1 && showDialog("Xoá học viên?")) {
                    int maLopHoc = Integer.parseInt(model.getValueAt(selectedRow, 1).toString());
                    int maKhoaHoc = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());
                    int maHocVien = Integer.parseInt(model.getValueAt(selectedRow, 4).toString());
                    lopHocService.deleteLopHoc(maLopHoc, maKhoaHoc,maHocVien);
                    setDataToTable();
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                btnDeleteHocVien.setBackground(new Color(102,102,102));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDeleteHocVien.setBackground(new Color(153,153,153));
            }
            
        });
        
        btnRefresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setDataToTable();
                jtfSearch.setText("");
            }
            
        });
    }
    
    public boolean showDialog(String msg) {
        int dialogResult = JOptionPane.showConfirmDialog(null, msg, "Xác nhận xoá", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
