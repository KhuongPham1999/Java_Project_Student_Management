/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.service;

import java.util.List;
import qlhv.dao.TrangChuDAO;
import qlhv.dao.TrangChuDAOImpl;

/**
 *
 * @author Viet
 */
public class TrangChuServiceImpl implements TrangChuService {

    TrangChuDAO trangChuDAO = null;

    public TrangChuServiceImpl() {
        trangChuDAO = new TrangChuDAOImpl();
    }

    @Override
    public List<Integer> statistical() {
        return trangChuDAO.statistical();
    }

}
