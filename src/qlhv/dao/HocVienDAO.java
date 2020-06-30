/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.dao;

import java.util.List;
import qlhv.model.HocVien;

/**
 *
 * @author Viet
 */
public interface HocVienDAO {
    public List<HocVien> getList();
    public int insertHocVien(HocVien hocVien);
    public int updateHocVien(HocVien hocVien);
    public int deleteHocVien(HocVien hocVien);
}
