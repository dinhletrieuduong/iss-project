package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SinhVien extends NguoiDung {
    private String mssv;
    private int ma_khoa;
    private int ma_bo_mon;

    @Override
    public void read(ResultSet rs) {
        try {
            super.read(rs);
            mssv = rs.getString("MSSV");
            ma_khoa = rs.getInt("MA_KHOA");
            ma_bo_mon = rs.getInt("MA_BO_MON");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getMssv() {
        return mssv;
    }

    public int getMa_khoa() {
        return ma_khoa;
    }

    public int getMa_bo_mon() {
        return ma_bo_mon;
    }
}
