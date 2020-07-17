package entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class NguoiDung {
    protected Connection conn;
    protected int ma_nd;
    protected String username;
    protected String ho_ten;
    protected int gioi_tinh;
    protected String dia_chi;
    protected String sdt;
    protected Date ngay_sinh;
    protected String email;
    protected int type;

    protected void read(ResultSet rs) throws SQLException {
        ma_nd = rs.getInt("MA_ND");
        username = rs.getString("USERNAME");
        ho_ten = rs.getString("HO_TEN");
        gioi_tinh = rs.getInt("GIOI_TINH");
        dia_chi = rs.getString("DIA_CHI");
        sdt = rs.getString("DSDT");
        ngay_sinh = rs.getDate("NGAY_SINH");
        email = rs.getString("DEMAIL");
        type = rs.getInt("KIEUND");
    }
    public int getMa_nd() {
        return ma_nd;
    }

    public String getUsername() {
        return username;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public int getGioi_tinh() {
        return gioi_tinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public String getSdt() {
        return sdt;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public String getEmail() {
        return email;
    }

    public int getType() {
        return type;
    }

    public Connection getConn() { return conn; }

    public void setConn(Connection conn) { this.conn = conn; }

}
