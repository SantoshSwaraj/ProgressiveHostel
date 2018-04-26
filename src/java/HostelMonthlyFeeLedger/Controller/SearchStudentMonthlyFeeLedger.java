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
@WebServlet(name = "SearchStudentMonthlyFeeLedger", urlPatterns = {"/SearchStudentMonthlyFeeLedger"})
public class SearchStudentMonthlyFeeLedger extends HttpServlet {

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
            HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBeanRecv = new HostelMonthlyFeeLedgerBean();
            HostelMonthlyFeeLedgerDAO hostelMonthlyFeeLedgerDAO = new HostelMonthlyFeeLedgerDAOImpl();
            String ADMISSION_NO_OR_STUDENT_ID = request.getParameter("ADMISSION_NO_OR_STUDENT_ID");
            if (ADMISSION_NO_OR_STUDENT_ID.contains("-")) {
                hostelMonthlyFeeLedgerBean.setADMISSION_NO(request.getParameter("ADMISSION_NO_OR_STUDENT_ID"));
                hostelMonthlyFeeLedgerBean.setBILL_MONTH_ID(Integer.parseInt(request.getParameter("BILL_MONTH_ID")));
                hostelMonthlyFeeLedgerBean.setBILL_YEAR(request.getParameter("BILL_YEAR"));
                hostelMonthlyFeeLedgerBeanRecv = hostelMonthlyFeeLedgerDAO.searchStudentMonthlyFeeLedgerByAdmissionNo(hostelMonthlyFeeLedgerBean);
                
            } else {
                hostelMonthlyFeeLedgerBean.setSTUDENT_ID(Integer.parseInt(request.getParameter("ADMISSION_NO_OR_STUDENT_ID")));
                hostelMonthlyFeeLedgerBean.setBILL_MONTH_ID(Integer.parseInt(request.getParameter("BILL_MONTH_ID")));
                hostelMonthlyFeeLedgerBean.setBILL_YEAR(request.getParameter("BILL_YEAR"));
                hostelMonthlyFeeLedgerBeanRecv = hostelMonthlyFeeLedgerDAO.searchStudentMonthlyFeeLedgerByStudentId(hostelMonthlyFeeLedgerBean);
            }
                    
            if(hostelMonthlyFeeLedgerBeanRecv.getHOSTEL_MONTHLY_FEE_LEDGER_ID()== null){ 
                /*============== Insert Hostel Monthly Fee Details, Since Entry for that month Do Not Exist ======*/
                session.setAttribute("HostelMonthlyFeeLedgerBean", hostelMonthlyFeeLedgerBean);
                response.sendRedirect("/ProgressiveHostel/HostelMonthlyFee/InsertHostelMonthlyFeeForm.jsp");
            }
            else if (hostelMonthlyFeeLedgerBeanRecv.getSTUDENT_ID() > 0 && hostelMonthlyFeeLedgerBean.getFLAG() == 0) {
                /*============== Update Hostel Monthly Fee Details, Since Entry for that month Exist due to OneTimeFee ======*/
                session.setAttribute("HostelMonthlyFeeLedgerBean", hostelMonthlyFeeLedgerBean);
                response.sendRedirect("/ProgressiveHostel/HostelMonthlyFee/UpdateHostelMonthlyFeeForm.jsp");
            } else if (hostelMonthlyFeeLedgerBeanRecv.getSTUDENT_ID() > 0 && hostelMonthlyFeeLedgerBean.getFLAG() == 1) {
                /*======Msg Back to Hostel Monthly Fee Form as Entry for that month already Exists======== */
                session.setAttribute("wmsg", "Fee Already Submitted for Month :" + hostelMonthlyFeeLedgerBean.getBILL_MONTH_ID());
                response.sendRedirect("/ProgressiveHostel/HostelMonthlyFee/HostelMonthlyFeeForm.jsp");
            } 

        } catch (Exception e) {
            session.setAttribute("wmsg", "Something went wrong.. Please Contact Your Service Provider");
            response.sendRedirect("/ProgressiveHostel/HostelMonthlyFee/HostelMonthlyFeeForm.jsp");
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
