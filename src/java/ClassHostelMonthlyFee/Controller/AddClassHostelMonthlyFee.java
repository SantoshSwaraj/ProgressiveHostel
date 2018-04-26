/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassHostelMonthlyFee.Controller;

import ClassHostelMonthlyFee.Bean.ClassHostelMonthlyFeeBean;
import ClassHostelMonthlyFee.DAO.ClassHostelMonthlyFeeDAO;
import ClassHostelMonthlyFee.DAO.ClassHostelMonthlyFeeDAOImpl;
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
@WebServlet(name = "AddClassHostelMonthlyFee", urlPatterns = {"/AddClassHostelMonthlyFee"})
public class AddClassHostelMonthlyFee extends HttpServlet {

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
            ClassHostelMonthlyFeeBean classHostelMonthlyFeeBean = new ClassHostelMonthlyFeeBean();
            classHostelMonthlyFeeBean.setCLASS_ID(Integer.parseInt(request.getParameter("CLASS_ID")));
            classHostelMonthlyFeeBean.setFEE(Integer.parseInt(request.getParameter("FEE")));

            ClassHostelMonthlyFeeDAO classHostelMonthlyFeeDAO = new ClassHostelMonthlyFeeDAOImpl();
            int i = classHostelMonthlyFeeDAO.addClassHostelMonthlyFee(classHostelMonthlyFeeBean);

            if (i > 0) {
                session.setAttribute("msg", "Class-Hostel-Monthly-Fee Added.");
                response.sendRedirect("/ProgressiveHostel/Setup/SetClassHostelMonthlyCharge.jsp");
            } else {
                session.setAttribute("wmsg", "Unable to Add Class-Hostel-Monthly-Fee.");
                response.sendRedirect("/ProgressiveHostel/Setup/SetClassHostelMonthlyCharge.jsp");
            }

        } catch (Exception e) {
            session.setAttribute("wmsg", "Unable to Add Class-Hostel-Monthly-Fee.. Try Again..");
            response.sendRedirect("/ProgressiveHostel/Setup/SetClassHostelMonthlyCharge.jsp");
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
