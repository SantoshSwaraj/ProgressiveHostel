/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OneTimeCharges.Controller;

import StudentMaster.Bean.StudentMasterBean;
import StudentMaster.DAO.StudentMasterDAO;
import StudentMaster.DAO.StudentMasterDAOImpl;
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
@WebServlet(name = "SearchRegistratedStudent", urlPatterns = {"/SearchRegistratedStudent"})
public class SearchRegistratedStudent extends HttpServlet {

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
            StudentMasterBean studentMasterBean = new StudentMasterBean();
            StudentMasterDAO studentMasterDAO = new StudentMasterDAOImpl();
            String ADMISSION_NO_OR_STUDENT_ID = request.getParameter("ADMISSION_NO_OR_STUDENT_ID");
            if (ADMISSION_NO_OR_STUDENT_ID.contains("-")) {
                studentMasterBean = studentMasterDAO.getStudentMasterDetailsByAdmissionNo(ADMISSION_NO_OR_STUDENT_ID);
            } else {
                studentMasterBean = studentMasterDAO.getStudentMasterDetailsById(Integer.parseInt(ADMISSION_NO_OR_STUDENT_ID));
            }

            if (studentMasterBean.getSTUDENT_ID() == null) {
                session.setAttribute("wmsg", "Student is Not Registered!!");
                response.sendRedirect("/ProgressiveHostel/OneTimeCharges/OneTimeChargeForm.jsp");
            }
            else if (studentMasterBean.getSTUDENT_ID() > 0) {

                StudentOneTimeChargeDetailsDAO studentOneTimeChargeDetailsDAO = new StudentOneTimeChargeDetailsDAOImpl();
                StudentOneTimeChargeDetailsBean studentOneTimeChargeDetailsBeanRecv = studentOneTimeChargeDetailsDAO.getStudentOneTimeChargeDetailsByStudentId(studentMasterBean.getSTUDENT_ID());

                if (studentOneTimeChargeDetailsBeanRecv.getSTUDENT_ID() == null) {
                    session.setAttribute("StudentMasterBean", studentMasterBean);
                    response.sendRedirect("/ProgressiveHostel/OneTimeCharges/OneTimeChargesFormOpen.jsp");

                } else {
                    session.setAttribute("wmsg", "Student Already Submitted One Time Fee..");
                    response.sendRedirect("/ProgressiveHostel/OneTimeCharges/OneTimeChargeForm.jsp");
                }

            }

        } catch (Exception e) {
            session.setAttribute("wmsg", "Something went wrong.. Contact Admin");
            response.sendRedirect("/ProgressiveHostel/OneTimeCharges/OneTimeChargeForm.jsp");
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
