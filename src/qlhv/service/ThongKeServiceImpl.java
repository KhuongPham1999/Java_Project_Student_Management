/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.service;

import java.util.List;
import qlhv.bean.KhoaHocBean;
import qlhv.bean.LopHocBean;
import qlhv.dao.ThongKeDAO;
import qlhv.dao.ThongKeDaoImpl;

/**
 *
 * @author Viet
 */
public class ThongKeServiceImpl implements ThongKeService{
    private ThongKeDAO thongKeDAO;

    public ThongKeServiceImpl() {
        thongKeDAO = new ThongKeDaoImpl();
    }

    @Override
    public List<LopHocBean> getListByLopHoc() {
        return thongKeDAO.getListByLopHoc();
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        return thongKeDAO.getListByKhoaHoc();
    }
    
}
