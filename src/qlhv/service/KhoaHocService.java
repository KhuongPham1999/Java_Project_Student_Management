/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.service;

import java.util.List;
import qlhv.model.KhoaHoc;

/**
 *
 * @author Viet
 */
public interface KhoaHocService {
    public List<KhoaHoc> getList();
    public int insertKhoaHoc(KhoaHoc khoaHoc);
    public int updateKhoaHoc(KhoaHoc khoaHoc);
    public int deleteKhoaHoc(KhoaHoc khoaHoc);
}
