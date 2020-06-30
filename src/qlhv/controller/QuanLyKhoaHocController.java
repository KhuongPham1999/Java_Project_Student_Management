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
import qlhv.model.KhoaHoc;
import qlhv.service.KhoaHocService;
import qlhv.service.KhoaHocServiceImpl;
import qlhv.utility.KhoaHocTableModel;
import qlhv.view.KhoaHocJFrame;

/**
 *
 * @author Viet
 */
public class QuanLyKhoaHocController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JButton btnRefresh;
    private JButton btnDelete;
    private String[] listColumn = {"STT", "Mã khoá học", "Tên khoá học", "Mô tả", "Ngày bắt đầu", "Ngày kết thúc",
        "Tình trạng"};
    private KhoaHocService khoaHocService;
    private JTable table;

    public QuanLyKhoaHocController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JButton btnRefresh, JButton btnDelete) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.btnRefresh = btnRefresh;
        this.btnDelete = btnDelete;
        khoaHocService = new KhoaHocServiceImpl();
    }

    public void setDataToTable() {
        List<KhoaHoc> list = khoaHocService.getList();
        DefaultTableModel model = new KhoaHocTableModel().setTableModel(list, listColumn);
        table = new JTable(model);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.validate();
        table.repaint();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

                    KhoaHoc khoaHoc = new KhoaHoc();
                    khoaHoc.setMaKhoaHoc(Integer.parseInt(model.getValueAt(selectedRowIndex, 1).toString()));
                    khoaHoc.setTenKhoaHoc(model.getValueAt(selectedRowIndex, 2).toString());
                    khoaHoc.setMoTa(model.getValueAt(selectedRowIndex, 3) != null ? model.getValueAt(selectedRowIndex, 3).toString()
                            : "");

                    String stringDate = model.getValueAt(selectedRowIndex, 4).toString();
                    try {
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
                        khoaHoc.setNgayBatDau(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(QuanLyKhoaHocController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    stringDate = model.getValueAt(selectedRowIndex, 5).toString();
                    try {
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
                        khoaHoc.setNgayKetThuc(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(QuanLyKhoaHocController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    khoaHoc.setTinhTrang((boolean) model.getValueAt(selectedRowIndex, 6));

                    KhoaHocJFrame frame = new KhoaHocJFrame(khoaHoc,"update");
                    frame.setVisible(true);
                    frame.setTitle("Thông tin khoá học");
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                }
            }

        });

        table.getColumn("STT").setMaxWidth(50);
        table.getColumn("Mã khoá học").setMaxWidth(120);
        table.getColumn("Mã khoá học").setMinWidth(120);
        table.getColumn("Mô tả").setMinWidth(250);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.getViewport().setPreferredSize(new Dimension(1400, 400));

        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();

        TableRowSorter rowSorter = new TableRowSorter(model);
        table.setRowSorter(rowSorter);
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
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
                KhoaHocJFrame frame = new KhoaHocJFrame(new KhoaHoc(),"insert");
                frame.setTitle("Thông tin khoá học");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 153, 0));
            }
        });

        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KhoaHoc khoaHoc = new KhoaHoc();
                int selectedRow = table.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                selectedRow = table.convertRowIndexToModel(selectedRow);
                if (selectedRow != -1 && showDialog()) {
                    khoaHoc.setMaKhoaHoc(Integer.parseInt(model.getValueAt(selectedRow, 1).toString()));
                    khoaHocService.deleteKhoaHoc(khoaHoc);
                    setDataToTable();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnDelete.setBackground(new Color(102, 102, 102));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDelete.setBackground(new Color(153, 153, 153));
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

    public boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Xoá dữ liệu được chọn?", "Xác nhận xoá", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
