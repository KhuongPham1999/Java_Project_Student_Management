/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.service;

import qlhv.dao.TaiKhoanDAO;
import qlhv.dao.TaiKhoanDAOImpl;
import qlhv.model.TaiKhoan;

/**
 *
 * @author Viet
 */
public class TaiKhoanServiceImpl implements TaiKhoanService{
    private TaiKhoanDAO taiKhoanDAO;

    public TaiKhoanServiceImpl() {
        taiKhoanDAO = new TaiKhoanDAOImpl();
    }
    
    @Override
    public TaiKhoan login(String tdn, String mk) {
        return taiKhoanDAO.login(tdn, mk);
    }
    
}
