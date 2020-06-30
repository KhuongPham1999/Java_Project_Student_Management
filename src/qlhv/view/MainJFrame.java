
package qlhv.view;

import java.util.List;
import java.util.ArrayList;
import qlhv.bean.DanhMucBean;
import qlhv.controller.ChuyenManHinhController;

/**
 *
 * @author Viet
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    @SuppressWarnings("empty-statement")
    public MainJFrame() {
        initComponents();//khởi tạo các thành phần
        setTitle("QUẢN LÝ HỌC VIÊN");
        
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);  //Chuyển màn hình đến jpnView
        controller.setView(jpnTrangChu ,jlbTrangChu);
        
        List<DanhMucBean> listIteam = new ArrayList<>();
        listIteam.add(new DanhMucBean("TrangChu", jpnTrangChu, jlbTrangChu));
        listIteam.add(new DanhMucBean("HocVien", jpnHocVien, jlbHocVien));
        listIteam.add(new DanhMucBean("KhoaHoc", jpnKhoaHoc, jlbKhoaHoc));
        listIteam.add(new DanhMucBean("LopHoc", jpnLopHoc, jlbLopHoc));
        listIteam.add(new DanhMucBean("ThongKe", JpnThongKe, jlbThongKe));
        
        controller.setEvent(listIteam);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnView = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jpnLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnHocVien = new javax.swing.JPanel();
        jlbHocVien = new javax.swing.JLabel();
        jpnTrangChu = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        JpnThongKe = new javax.swing.JPanel();
        jlbThongKe = new javax.swing.JLabel();
        jpnKhoaHoc = new javax.swing.JPanel();
        jlbKhoaHoc = new javax.swing.JLabel();
        jpnLopHoc = new javax.swing.JPanel();
        jlbLopHoc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1800, 1000));

        jpnView.setBackground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1359, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );

        jpnMenu.setBackground(new java.awt.Color(82, 83, 81));

        jpnLogo.setBackground(new java.awt.Color(232, 64, 60));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlhv/images/Icon_UngDung.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ HỌC VIÊN");

        javax.swing.GroupLayout jpnLogoLayout = new javax.swing.GroupLayout(jpnLogo);
        jpnLogo.setLayout(jpnLogoLayout);
        jpnLogoLayout.setHorizontalGroup(
            jpnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnLogoLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jpnLogoLayout.setVerticalGroup(
            jpnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLogoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnHocVien.setBackground(new java.awt.Color(76, 175, 80));

        jlbHocVien.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlbHocVien.setForeground(new java.awt.Color(255, 255, 255));
        jlbHocVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlhv/images/Icon_menu2.png"))); // NOI18N
        jlbHocVien.setText("Quản lý học viên");

        javax.swing.GroupLayout jpnHocVienLayout = new javax.swing.GroupLayout(jpnHocVien);
        jpnHocVien.setLayout(jpnHocVienLayout);
        jpnHocVienLayout.setHorizontalGroup(
            jpnHocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHocVienLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbHocVien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnHocVienLayout.setVerticalGroup(
            jpnHocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHocVienLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbHocVien)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnTrangChu.setBackground(new java.awt.Color(76, 175, 80));

        jlbTrangChu.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlbTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jlbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlhv/images/Icon_menu1.png"))); // NOI18N
        jlbTrangChu.setText("Màn hình chính");

        javax.swing.GroupLayout jpnTrangChuLayout = new javax.swing.GroupLayout(jpnTrangChu);
        jpnTrangChu.setLayout(jpnTrangChuLayout);
        jpnTrangChuLayout.setHorizontalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbTrangChu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnTrangChuLayout.setVerticalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbTrangChu)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        JpnThongKe.setBackground(new java.awt.Color(76, 175, 80));

        jlbThongKe.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        jlbThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlhv/images/Icon_menu5.png"))); // NOI18N
        jlbThongKe.setText("Thống kê dữ liệu");

        javax.swing.GroupLayout JpnThongKeLayout = new javax.swing.GroupLayout(JpnThongKe);
        JpnThongKe.setLayout(JpnThongKeLayout);
        JpnThongKeLayout.setHorizontalGroup(
            JpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnThongKeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbThongKe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpnThongKeLayout.setVerticalGroup(
            JpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnThongKeLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jlbThongKe)
                .addGap(15, 15, 15))
        );

        jpnKhoaHoc.setBackground(new java.awt.Color(76, 175, 80));

        jlbKhoaHoc.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlbKhoaHoc.setForeground(new java.awt.Color(255, 255, 255));
        jlbKhoaHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlhv/images/Icon_menu3.png"))); // NOI18N
        jlbKhoaHoc.setText("Quản lý khoá học");

        javax.swing.GroupLayout jpnKhoaHocLayout = new javax.swing.GroupLayout(jpnKhoaHoc);
        jpnKhoaHoc.setLayout(jpnKhoaHocLayout);
        jpnKhoaHocLayout.setHorizontalGroup(
            jpnKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhoaHocLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbKhoaHoc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnKhoaHocLayout.setVerticalGroup(
            jpnKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhoaHocLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbKhoaHoc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnLopHoc.setBackground(new java.awt.Color(76, 175, 80));

        jlbLopHoc.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlbLopHoc.setForeground(new java.awt.Color(255, 255, 255));
        jlbLopHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLopHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlhv/images/Icon_menu4.png"))); // NOI18N
        jlbLopHoc.setText("Quản lý lớp học");

        javax.swing.GroupLayout jpnLopHocLayout = new javax.swing.GroupLayout(jpnLopHoc);
        jpnLopHoc.setLayout(jpnLopHocLayout);
        jpnLopHocLayout.setHorizontalGroup(
            jpnLopHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLopHocLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbLopHoc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnLopHocLayout.setVerticalGroup(
            jpnLopHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLopHocLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbLopHoc)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnHocVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpnThongKe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnKhoaHoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnLopHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jpnLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnRootLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(979, Short.MAX_VALUE)))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnRootLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(109, 109, 109))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpnThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlbHocVien;
    private javax.swing.JLabel jlbKhoaHoc;
    private javax.swing.JLabel jlbLopHoc;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JPanel jpnHocVien;
    private javax.swing.JPanel jpnKhoaHoc;
    private javax.swing.JPanel jpnLogo;
    private javax.swing.JPanel jpnLopHoc;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnTrangChu;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
