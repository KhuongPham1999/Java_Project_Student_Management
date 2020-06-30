/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.service;

import java.util.List;
import qlhv.dao.HocVienDAO;
import qlhv.dao.HocVienDAOImpl;
import qlhv.model.HocVien;

/**
 *
 * @author Viet
 */
public class HocVienServiceImpl implements HocVienService {

    HocVienDAO hocVienDao = null;

    public HocVienServiceImpl() {
        hocVienDao = new HocVienDAOImpl();
    }

    @Override
    public List<HocVien> getList() {
        return hocVienDao.getList();
    }

    @Override
    public int insertHocVien(HocVien hocVien) {
        return hocVienDao.insertHocVien(hocVien);
    }

    @Override
    public int deleteHocVien(HocVien hocVien) {
        return hocVienDao.deleteHocVien(hocVien);
    }

    @Override
    public int updateHocVien(HocVien hocVien) {
        return hocVienDao.updateHocVien(hocVien);
    }
}
