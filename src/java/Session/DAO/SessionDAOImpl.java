/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session.DAO;

import Section.Bean.SectionBean;
import Session.Bean.SessionBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author mishra
 */
public class SessionDAOImpl implements SessionDAO {

    @Override
    public ArrayList getSessions() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<SessionBean> sessionBeanList = new ArrayList<>();

        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM session ORDER BY SESSION_ID");

            rs = pre.executeQuery();
            while (rs.next()) {
                SessionBean sessionBean = new SessionBean();
                sessionBean.setSESSION_ID(rs.getInt("SESSION_ID"));
                sessionBean.setSESSION(rs.getString("SESSION"));

                sessionBeanList.add(sessionBean);
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
        return sessionBeanList;
    }

    @Override
    public SessionBean getSessionById(int SESSION_ID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        SessionBean sessionBean = new SessionBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM session WHERE SESSION_ID = ?");

            pre.setInt(1, SESSION_ID);
            rs = pre.executeQuery();
            if(rs.next()){
                sessionBean.setSESSION_ID(rs.getInt("SESSION_ID"));
                sessionBean.setSESSION(rs.getString("SESSION"));
               
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
        return sessionBean;
    }

}
