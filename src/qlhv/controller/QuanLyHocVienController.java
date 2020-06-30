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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import qlhv.model.HocVien;
import qlhv.service.HocVienService;
import qlhv.service.HocVienServiceImpl;
import qlhv.utility.HocVienTableModel;
import qlhv.view.HocVienJFrame;

/**
 *
 * @author Viet
 */
public class QuanLyHocVienController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JButton btnDelete;
    private JButton btnRefresh;

    private HocVienService hocVienService = null;
    private JTable table;//JTable cho phép hiển thị một mảng các phần tử, hoặc một Vector.

    private String[] listColumn = {"STT", "Mã học viên", "Họ và tên", "Ngày sinh", "Giới tính",
        "Số điện thoại", "Địa chỉ", "Tình trạng"};

    private TableRowSorter<TableModel> rowSorter;

    public QuanLyHocVienController() {
    }

    public QuanLyHocVienController(JPanel jpnView, JButton btnAdd, JButton btnDelete, JButton btnRefresh, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.btnDelete = btnDelete;
        this.btnRefresh = btnRefresh;
        this.hocVienService = new HocVienServiceImpl();
    }

    public void setDataToTable() {

        List<HocVien> listItem = hocVienService.getList();

        DefaultTableModel model = new HocVienTableModel().setTableModel(listItem, listColumn);//khởi tạo tên cột của bảng
        table = new JTable(model);

        //rowSorter= new TableRowSorter<>(table.getModel());
        rowSorter = new TableRowSorter<>(model);
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                text = text.trim();
                if (text.length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                text = text.trim();
                if (text.length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        table.getColumnModel().getColumn(0).setMinWidth(50);
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);

//        table.getColumnModel().getColumn(1).setMinWidth(100);
//        table.getColumnModel().getColumn(1).setMaxWidth(100);
//        table.getColumnModel().getColumn(1).setPreferredWidth(100);
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
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

                    HocVien hocVien = new HocVien();
                    hocVien.setMaHocVien(Integer.parseInt(model.getValueAt(selectedRowIndex, 1).toString()));
                    hocVien.setHoTen(model.getValueAt(selectedRowIndex, 2).toString());

                    String stringDate = model.getValueAt(selectedRowIndex, 3).toString();
                    try {
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
                        hocVien.setNgaySinh(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(QuanLyHocVienController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    hocVien.setGioiTinh(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam"));
                    hocVien.setSoDienThoai(model.getValueAt(selectedRowIndex, 5) != null
                            ? model.getValueAt(selectedRowIndex, 5).toString() : "");
                    hocVien.setDiaChi(model.getValueAt(selectedRowIndex, 6) != null
                            ? model.getValueAt(selectedRowIndex, 6).toString() : "");
                    hocVien.setTinhTrang((boolean) model.getValueAt(selectedRowIndex, 7));

                    HocVienJFrame frame = new HocVienJFrame(hocVien, "update");
                    frame.setTitle("Thông tin học viên");
                    frame.setResizable(false);//thay đổi kích thước cửa sổ
                    frame.setLocationRelativeTo(null);  //Đặt cửa sổ xuất hiện ở giữa màn hình
                    frame.setVisible(true);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));

        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }

//    public void getHocVienFromTable() {
//        HocVien hocVien = new HocVien();
//        int selected = table.getSelectedRow();
//        jtfSearch.setText(model.getValueAt(selected, 1).toString());
//    }
    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HocVienJFrame frame = new HocVienJFrame(new HocVien(), "insert");
                frame.setTitle("Thông tin học viên");
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
                HocVien hocVien = new HocVien();
                int selectedRow = table.getSelectedRow();
                selectedRow = table.convertRowIndexToModel(selectedRow);
                if (selectedRow != -1 && showDialog()) {
                    hocVien.setMaHocVien(Integer.parseInt(table.getModel().getValueAt(selectedRow, 1).toString()));
                    int deleteHocVien = hocVienService.deleteHocVien(hocVien);
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
