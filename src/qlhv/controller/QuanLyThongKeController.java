/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import qlhv.bean.KhoaHocBean;
import qlhv.bean.LopHocBean;
import qlhv.service.ThongKeService;
import qlhv.service.ThongKeServiceImpl;
/**
 *
 * @author Viet
 */
public class QuanLyThongKeController {
    private ThongKeService thongKeService = null;

    public QuanLyThongKeController() {
        thongKeService = new ThongKeServiceImpl();
    }
    
    public void setDataToChart1(JPanel jpnItem) {
        List<LopHocBean> list = thongKeService.getListByLopHoc();
        if (list != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            list.forEach((item) -> {
                dataset.addValue(item.getSoLuongHocVien(), "Học viên", item.getNgayDangKy());
            });
            
            JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ SỐ LƯỢNG HỌC VIÊN ĐĂNG KÝ THEO THÁNG",
                    "Thời gian", "Số lượng", dataset, PlotOrientation.VERTICAL, false, true, false);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }
    
    public void setDataToChart2(JPanel jpnItem) {
        List<KhoaHocBean> list = thongKeService.getListByKhoaHoc();
        if(list != null) {
            TaskSeriesCollection ds =  new TaskSeriesCollection();
            
            list.forEach((item) -> {
                TaskSeries taskSeries = new TaskSeries(item.getTenKhoaHoc());
                Task task = new Task(item.getTenKhoaHoc(), item.getNgayBatDau(), item.getNgayKetThuc());
                taskSeries.add(task);
                ds.add(taskSeries);
            });
            
            JFreeChart chart = ChartFactory.createGanttChart("THỐNG KÊ TÌNH TRẠNG KHOÁ HỌC", "Khoá học", "Thời gian", ds, true, false, false
        );
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }
    
}
