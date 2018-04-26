/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentOneTimeChargeDetails.Controller;

import StudentOneTimeChargeDetails.Bean.StudentOneTimeChargeDetailsBean;
import StudentOneTimeChargeDetails.DAO.StudentOneTimeChargeDetailsDAO;
import StudentOneTimeChargeDetails.DAO.StudentOneTimeChargeDetailsDAOImpl;
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
@WebServlet(name = "AddStudentOneTimeChargeDetails", urlPatterns = {"/AddStudentOneTimeChargeDetails"})
public class AddStudentOneTimeChargeDetails extends HttpServlet {

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
            StudentOneTimeChargeDetailsBean studentOneTimeChargeDetailsBean = new StudentOneTimeChargeDetailsBean();
            studentOneTimeChargeDetailsBean.setSTUDENT_ID((Integer) session.getAttribute("STUDENT_ID"));
            studentOneTimeChargeDetailsBean.setSECURITY_MONEY(Integer.parseInt(request.getParameter("SECURITY_MONEY")));
            studentOneTimeChargeDetailsBean.setPACKET_MONEY(Integer.parseInt(request.getParameter("PACKET_MONEY")));
            studentOneTimeChargeDetailsBean.setTOTAL_TO_PAY(Integer.parseInt(request.getParameter("TOTAL_TO_PAY")));
            studentOneTimeChargeDetailsBean.setTOTAL_PAID_AMT(Integer.parseInt(request.getParameter("TOTAL_PAID_AMT")));

            int BALANCE_AMT = Integer.parseInt(request.getParameter("TOTAL_TO_PAY")) - Integer.parseInt(request.getParameter("TOTAL_PAID_AMT"));
            studentOneTimeChargeDetailsBean.setBALANCE_AMT(BALANCE_AMT);

            studentOneTimeChargeDetailsBean.setENTRY_ID((Integer) session.getAttribute("EMPLOYEE_ID"));
            
            StudentOneTimeChargeDetailsDAO studentOneTimeChargeDetailsDAO = new StudentOneTimeChargeDetailsDAOImpl();
            int i = studentOneTimeChargeDetailsDAO.addStudentOneTimeChargeDetails(studentOneTimeChargeDetailsBean);

            if (i > 0) {
                session.setAttribute("msg", "One Time Charges Added");
                response.sendRedirect("/ProgressiveHostel/Student/NewStudentAdmissionSlip.jsp");

            } else {
                session.setAttribute("wmsg", "Unable to Pay One Time Charges..");
                response.sendRedirect("/ProgressiveHostel/Student/AddStudent.jsp?id=4");
            }

        } catch (Exception e) {
            session.setAttribute("wmsg", "Unable to Pay One Time Charges.. Try Again..");
            response.sendRedirect("/ProgressiveHostel/Student/AddStudent.jsp?id=4");
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
