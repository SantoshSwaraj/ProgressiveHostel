/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Santosh Kushwaha
 */
public class CollectionDAOImpl implements CollectionDAO {

    @Override
    public int getTotalCollection() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        int totalCollection = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT SUM(PAID_AMT) as totalCollection FROM collection");

            rs = pre.executeQuery();
            if (rs.next()) {
                totalCollection = rs.getInt("totalCollection");
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pre != null) {
                    pre.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return totalCollection;
    }

}
