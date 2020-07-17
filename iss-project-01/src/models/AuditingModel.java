//package sample;
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DbConnect;
import entities.Auditing;

public class AuditingModel
{
    public AuditingModel(){}

    public ArrayList<Auditing> GetAllAuditing()
    {
        ArrayList<Auditing> results = new ArrayList<Auditing>();

        try
        {
            ResultSet rs = DbConnect.executeQuery(Auditing.query1());
            while (rs.next())
            {
                results.add(Auditing.read(rs));
            }

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        return results;
    }
}
