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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Santosh Kushwaha
 */
@WebServlet(name = "StudentDuesList", urlPatterns = {"/StudentDuesList"})
public class StudentDuesList extends HttpServlet {

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
            HostelMonthlyFeeLedgerDAO hostelMonthlyFeeLedgerDAO = new HostelMonthlyFeeLedgerDAOImpl();
            ArrayList<HostelMonthlyFeeLedgerBean> list = hostelMonthlyFeeLedgerDAO.getStudentDuesList();

            if (!list.isEmpty()) {
                int count = 1;
                for (HostelMonthlyFeeLedgerBean hmflb : list) {
                    out.println("<tr id='" + hmflb.getStudentMasterBean().getSTUDENT_ID() + "'>");
                    out.println("<td>");
                    out.println(count);
                    out.println("</td>");
                    out.println("<td>");
                    out.println(hmflb.getSessionBean().getSESSION());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(hmflb.getStudentMasterBean().getSTUDENT_ID());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(hmflb.getStudentMasterBean().getSTUDENT_NAME().toUpperCase());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(hmflb.getStudentMasterBean().getADMISSION_NO());
                    out.println("</td>");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    out.println("<td>");
                    out.println(sdf.format(hmflb.getStudentMasterBean().getENTRY_DATE()));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(hmflb.getClassBean().getCLASS_NAME());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(hmflb.getSectionBean().getSECTION_NAME());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(hmflb.getStudentMasterBean().getSTUDENT_ROLL_NO());
                    out.println("</td>");
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    String[] currDate = sdf1.format(new Date()).split("-");
                    int CURR_YEAR = Integer.parseInt(currDate[0]);
                    int CURR_MONTH_ID = Integer.parseInt(currDate[1]);
                    int DUES_AMT = (((CURR_YEAR - Integer.parseInt(hmflb.getBILL_YEAR()))*12 + (CURR_MONTH_ID - hmflb.getBILL_MONTH_ID()))*hmflb.getCURRENT_MONTH_FEE())+hmflb.getBALANCE_AMT();
                    out.println("<td>");
                    out.println(DUES_AMT);
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
