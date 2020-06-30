/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.dao;

import java.util.List;
import qlhv.model.LopHoc;

/**
 *
 * @author Viet
 */
public interface LopHocDAO {
    public List<LopHoc> getList();
    public int insertLopHoc(LopHoc lopHoc);
    public int updateLopHoc(LopHoc lopHoc);
    public int deleteLopHoc(int maLopHoc, int maKhoaHoc);
    public int deleteLopHoc(int maLopHoc, int maKhoaHoc, int maHocVien);
}
