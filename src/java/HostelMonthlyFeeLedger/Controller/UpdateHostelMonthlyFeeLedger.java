/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HostelMonthlyFeeLedger.Controller;

import HostelMonthlyFeeLedger.Bean.HostelMonthlyFeeLedgerBean;
import HostelMonthlyFeeLedger.DAO.HostelMonthlyFeeLedgerDAO;
import HostelMonthlyFeeLedger.DAO.HostelMonthlyFeeLedgerDAOImpl;
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
@WebServlet(name = "UpdateHostelMonthlyFeeLedger", urlPatterns = {"/UpdateHostelMonthlyFeeLedger"})
public class UpdateHostelMonthlyFeeLedger extends HttpServlet {

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
            HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean = new HostelMonthlyFeeLedgerBean();
            hostelMonthlyFeeLedgerBean.setHOSTEL_MONTHLY_FEE_LEDGER_ID(Integer.parseInt(request.getParameter("HOSTEL_MONTHLY_FEE_LEDGER_ID")));
            hostelMonthlyFeeLedgerBean.setCURRENT_MONTH_FEE(Integer.parseInt(request.getParameter("CURRENT_MONTH_FEE")));
            hostelMonthlyFeeLedgerBean.setARREARS_AMT(Integer.parseInt(request.getParameter("ARREARS_AMT")));
            hostelMonthlyFeeLedgerBean.setTOTAL_TO_PAY(Integer.parseInt(request.getParameter("TOTAL_TO_PAY")));
            hostelMonthlyFeeLedgerBean.setTOTAL_PAID_AMT(Integer.parseInt(request.getParameter("TOTAL_PAID_AMT")));

            int BALANCE_AMT = Integer.parseInt(request.getParameter("TOTAL_TO_PAY")) - Integer.parseInt(request.getParameter("TOTAL_PAID_AMT"));
            hostelMonthlyFeeLedgerBean.setBALANCE_AMT(BALANCE_AMT);
            hostelMonthlyFeeLedgerBean.setFLAG(1);
            
            hostelMonthlyFeeLedgerBean.setENTRY_ID((Integer) session.getAttribute("EMPLOYEE_ID"));

            HostelMonthlyFeeLedgerDAO hostelMonthlyFeeLedgerDAO = new HostelMonthlyFeeLedgerDAOImpl();

            int i = hostelMonthlyFeeLedgerDAO.updateHostelMonthlyFeeLedger(hostelMonthlyFeeLedgerBean);

            if (i > 0) {
                

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
