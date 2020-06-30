/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.dao;

import java.util.List;
import qlhv.bean.KhoaHocBean;
import qlhv.bean.LopHocBean;

/**
 *
 * @author Viet
 */
public interface ThongKeDAO {
    public List<LopHocBean> getListByLopHoc();
    public List<KhoaHocBean> getListByKhoaHoc();
}
