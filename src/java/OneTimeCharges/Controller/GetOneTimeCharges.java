/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OneTimeCharges.Controller;

import ClassSection.Bean.ClassSectionBean;
import ClassSection.DAO.ClassSectionDAO;
import ClassSection.DAO.ClassSectionDAOImpl;
import OneTimeCharges.Bean.OneTimeChargeBean;
import OneTimeCharges.DAO.OneTimeChargesDAO;
import OneTimeCharges.DAO.OneTimeChargesDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mishra
 */
@WebServlet(name = "GetOneTimeCharges", urlPatterns = {"/GetOneTimeCharges"})
public class GetOneTimeCharges extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            OneTimeChargesDAO oneTimeChargesDAO = new OneTimeChargesDAOImpl();
            ArrayList<OneTimeChargeBean> oneTimeChargeBeanList = oneTimeChargesDAO.getOneTimeCharges();
            if (!oneTimeChargeBeanList.isEmpty()) {
                int count = 1;
                for (OneTimeChargeBean oneTimeChargeBean : oneTimeChargeBeanList) {
                    out.println("<tr id='" + oneTimeChargeBean.getONE_TIME_CHARGE_ID() + "'>");
                    out.println("<td>");
                    out.println(oneTimeChargeBean.getONE_TIME_CHARGE_ID());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(oneTimeChargeBean.getCHARGE_NAME());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(oneTimeChargeBean.getCHARGE_AMOUNT());
                    out.println("</td>");
                    out.println("</tr>");
                }
            } else {

            }
        } catch (Exception e) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
