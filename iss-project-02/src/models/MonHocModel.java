package models;

import entities.MonHoc;
import utils.DbConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonHocModel {
    public static ArrayList<MonHoc> getSubjects(Connection conn) {
        ArrayList<MonHoc> results = new ArrayList<MonHoc>();
        try {
            var rs = DbConnect.executeQuery(conn, "SELECT * FROM COURSEMAN.MON_HOC");
            while (rs.next()) {
                var mh = new MonHoc();
                mh.setMa_mon_hoc(rs.getInt("MA_MON_HOC"));
                mh.setTen_mon_hoc(rs.getString("TEN_MON_HOC"));
                mh.setMa_bo_mon(rs.getInt("MA_BO_MON"));
                results.add(mh);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }
}
