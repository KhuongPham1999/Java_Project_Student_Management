/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.service;

import java.util.List;
import qlhv.dao.KhoaHocDAO;
import qlhv.dao.KhoaHocDAOImpl;
import qlhv.model.KhoaHoc;

/**
 *
 * @author Viet
 */
public class KhoaHocServiceImpl implements KhoaHocService{
    private KhoaHocDAO khoaHocDAO;

    public KhoaHocServiceImpl() {
        this.khoaHocDAO = new KhoaHocDAOImpl();
    }
    
    @Override
    public List<KhoaHoc> getList() {
        return khoaHocDAO.getList();
    }

    @Override
    public int insertKhoaHoc(KhoaHoc khoaHoc) {
        return khoaHocDAO.insertKhoaHoc(khoaHoc);
    }

    @Override
    public int deleteKhoaHoc(KhoaHoc khoaHoc) {
        return khoaHocDAO.deleteKhoaHoc(khoaHoc);
    }

    @Override
    public int updateKhoaHoc(KhoaHoc khoaHoc) {
        return khoaHocDAO.updateKhoaHoc(khoaHoc);
    }
    
}
