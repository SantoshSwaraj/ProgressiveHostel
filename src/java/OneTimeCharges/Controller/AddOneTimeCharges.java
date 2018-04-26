/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OneTimeCharges.Controller;

import OneTimeCharges.Bean.OneTimeChargeBean;
import OneTimeCharges.DAO.OneTimeChargesDAO;
import OneTimeCharges.DAO.OneTimeChargesDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddOneTimeCharges", urlPatterns = {"/AddOneTimeCharges"})
public class AddOneTimeCharges extends HttpServlet {

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
            OneTimeChargeBean oneTimeChargeBean = new OneTimeChargeBean();
            oneTimeChargeBean.setCHARGE_NAME(request.getParameter("CHARGE_NAME"));
            oneTimeChargeBean.setCHARGE_AMOUNT(Integer.parseInt(request.getParameter("CHARGE_AMOUNT")));

            OneTimeChargesDAO oneTimeChargesDAO = new OneTimeChargesDAOImpl();
            int i = oneTimeChargesDAO.addOneTimeCharges(oneTimeChargeBean);

            if (i > 0) {
                session.setAttribute("msg", "One Time Charge Added.");
                response.sendRedirect("/ProgressiveHostel/Setup/SetOneTimeCharges.jsp");
            } else {
                session.setAttribute("msg", "Unable to Add One Time Charge.");
                response.sendRedirect("/ProgressiveHostel/Setup/SetOneTimeCharges.jsp");
            }
        } catch (Exception e) {
            session.setAttribute("msg", "Unable to Add One Time Charge. Try Again..");
            response.sendRedirect("/ProgressiveHostel/Setup/SetOneTimeCharges.jsp");
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
