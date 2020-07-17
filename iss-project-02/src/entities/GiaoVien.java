package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GiaoVien extends NguoiDung{

    private int kieugv;

    public void read(ResultSet rs) {
        try {
            super.read(rs);
            kieugv = rs.getObject("KIEUGV") == null ? -1 : rs.getInt("KIEUGV");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getKieugv() { return kieugv; }

    public void setKieugv(int kieugv) { this.kieugv = kieugv; }
}
