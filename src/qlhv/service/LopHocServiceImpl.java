/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.service;

import java.util.List;
import qlhv.dao.LopHocDAO;
import qlhv.dao.LopHocDAOImpl;
import qlhv.model.LopHoc;

/**
 *
 * @author Viet
 */
public class LopHocServiceImpl implements LopHocService {
    private LopHocDAO lopHocDAO = null;

    public LopHocServiceImpl() {
        lopHocDAO= new LopHocDAOImpl();
    }
    
    @Override
    public List<LopHoc> getList() {
        return lopHocDAO.getList();
    }

    @Override
    public int deleteLopHoc(int maLopHoc, int maKhoaHoc) {
        return lopHocDAO.deleteLopHoc(maLopHoc, maKhoaHoc);
    }

    @Override
    public int deleteLopHoc(int maLopHoc, int maKhoaHoc, int maHocVien) {
        return lopHocDAO.deleteLopHoc(maLopHoc, maKhoaHoc, maHocVien);
    }

    @Override
    public int insertLopHoc(LopHoc lopHoc) {
        return lopHocDAO.insertLopHoc(lopHoc);
    }

    @Override
    public int updateLopHoc(LopHoc lopHoc) {
        return lopHocDAO.updateLopHoc(lopHoc);
    }
    
}
