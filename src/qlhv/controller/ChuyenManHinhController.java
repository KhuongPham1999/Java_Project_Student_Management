package qlhv.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlhv.bean.DanhMucBean;
import qlhv.view.HocVienJPanel;
import qlhv.view.KhoaHocJPanel;
import qlhv.view.LopHocJPanel;
import qlhv.view.ThongKeJPanel;
import qlhv.view.TrangChuJPanel;

public class ChuyenManHinhController {

    private final JPanel root;
    private String kindSelected = "";
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel root) {  //chuyển màn hình đến root
        this.root = root;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {   //Mặc định màn hình bắt đầu là mục Trang chủ
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96, 100, 191)); //Đổi màu nền mới cho Panel
        jlbItem.setBackground(new Color(96, 100, 191)); //Đổi màu nền mới cho label

        root.removeAll(); //xóa những phần tử thuộc collection c ra khỏi danh sách
        root.setLayout(new BorderLayout());//Xây dựng một container để chứa các component bên trong
        root.add(new TrangChuJPanel()); // khởi tạo view trang chủ
        root.validate();
        root.repaint();// window dirty
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {       // duyệt hết các phần tử trong danh sách(DanhMucBean)
            item.getJpn().addMouseListener(new PanelEvent(item.getKind(), item.getJpn(), item.getJlb()));
            //Lấy ra panel của item đăng ký thành phần MouseListener bằng phương thức addMouseListener
        }
    }

    class PanelEvent implements MouseListener { //Inner class thực thi Interface MouseListener

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public PanelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {  //lựa chọn ra nút đang được click chuột đến dựa theo kind
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "HocVien":
                    node = new HocVienJPanel();
                    break;
                case "KhoaHoc":
                    node = new KhoaHocJPanel();
                    break;
                case "LopHoc":
                    node = new LopHocJPanel();
                    break;
                case "ThongKe":
                    node = new ThongKeJPanel();
                    break;
                default:
                    node = new TrangChuJPanel();
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node); //add view cho mỗi danh mục
            root.validate();
            root.repaint();
            setChangeBackground(kind);  //gọi đến phương thức của outer class
        }

        //đoạn code bên dưới override các method của interface MouseListener
        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;//sau khi clicked set set màu của panel = Color(96, 100, 191)
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {    //so sánh 2 string bỏ qua khác biệt vê kiểu chữ
                jpnItem.setBackground(new Color(76, 175, 80)); //trả lại màu nền cũ
                jlbItem.setBackground(new Color(76, 175, 80));
            }
        }

        private LayoutManager BorderLayout() {
            return null;
        }

    }

    private void setChangeBackground(String kind) {
        listItem.forEach((item) -> {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                item.getJpn().setBackground(new Color(76, 175, 80));
                item.getJlb().setBackground(new Color(76, 175, 80));
            }
        });
    }
}
