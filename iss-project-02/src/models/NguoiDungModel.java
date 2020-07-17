package models;

import entities.GiaoVien;
import entities.GiaoVu;
import entities.NguoiDung;
import entities.SinhVien;
import utils.DbConnect;
import utils.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class NguoiDungModel {
    private static String usernamePrefix = "CE_";

    public static ArrayList<GiaoVien> getLecturer(Connection conn) {
        var results = new ArrayList<GiaoVien>();
        var qr = "SELECT * FROM COURSEMAN.NGUOI_DUNG WHERE KIEUND = 2";
        try {
            var rs = DbConnect.executeQuery(conn, qr);
            while (rs.next()) {
                var gv = new GiaoVien();
                gv.read(rs);
                results.add(gv);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public static ArrayList<SinhVien> getStudents(Connection conn) {
        var results = new ArrayList<SinhVien>();
        var qr = "SELECT MA_ND, USERNAME, GIOI_TINH, DIA_CHI, SDT AS DSDT, " +
                "        NGAY_SINH, EMAIL AS DEMAIL, " +
                "        HO_TEN, KIEUND, MA_BO_MON, MA_KHOA, MSSV, KIEUGV " +
                "FROM COURSEMAN.NGUOI_DUNG WHERE KIEUND = 3";
        try {
            var rs = DbConnect.executeQuery(conn, qr);
            while (rs.next()) {
                var gv = new SinhVien();
                gv.read(rs);
                results.add(gv);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public static NguoiDung signIn(String username, String passwd) {
        username = (usernamePrefix + username).toUpperCase();
        Connection conn = DbConnect.signIn(username, passwd);

        if (conn != null) {
            System.out.println("Add CE_ Prefix");
            System.out.println("Signed in to database successfully!");
            System.out.println("Check user type");
            var qr = "SELECT MA_ND, USERNAME, GIOI_TINH, DIA_CHI, COURSEMAN.FN_DECRYPTDATA(SDT) AS DSDT, " +
                    "        NGAY_SINH, COURSEMAN.FN_DECRYPTDATA(EMAIL) AS DEMAIL, " +
                    "        HO_TEN, KIEUND, MA_BO_MON, MA_KHOA, MSSV, KIEUGV " +
                    "FROM COURSEMAN.NGUOI_DUNG WHERE USERNAME = ?";
            try {
                var rs = DbConnect.executeQuery(conn, qr, username);
                if (rs.next()) {
                    var type = rs.getInt("KIEUND");
                    NguoiDung nd = null;
                    switch (type) {
                        case 1:
                            nd = new GiaoVu();
                            ((GiaoVu)nd).read(rs);
                            break;
                        case 2:
                            nd = new GiaoVien();
                            ((GiaoVien)nd).read(rs);
                            break;
                        case 3:
                            nd = new SinhVien();
                            ((SinhVien)nd).read(rs);
                            break;
                        default:
                            break;
                    }
                    assert nd != null;
                    nd.setConn(conn);
                    return nd;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
