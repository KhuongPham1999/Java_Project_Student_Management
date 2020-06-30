package qlhv.dao;

import java.util.List;
import qlhv.model.KhoaHoc;

/**
 *
 * @author Viet
 */
public interface KhoaHocDAO {
    public List<KhoaHoc> getList();
    public int insertKhoaHoc(KhoaHoc khoaHoc);
    public int updateKhoaHoc(KhoaHoc khoaHoc);
    public int deleteKhoaHoc(KhoaHoc khoaHoc);
}
