/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.dao;

import qlhv.model.TaiKhoan;

/**
 *
 * @author Viet
 */
public interface TaiKhoanDAO {
    public TaiKhoan login(String tdn, String mk);
}
