package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GiaoVu extends NguoiDung {

    public void read(ResultSet rs) {
        try {
            super.read(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
