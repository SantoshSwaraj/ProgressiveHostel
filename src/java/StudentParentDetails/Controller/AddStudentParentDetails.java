/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentParentDetails.Controller;

import StudentParentDetails.Bean.StudentParentDetailsBean;
import StudentParentDetails.DAO.StudentParentDetailsDAO;
import StudentParentDetails.DAO.StudentParentDetailsDAOImpl;
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
@WebServlet(name = "AddStudentParentDetails", urlPatterns = {"/AddStudentParentDetails"})
public class AddStudentParentDetails extends HttpServlet {

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
            StudentParentDetailsBean studentParentDetailsBean = new StudentParentDetailsBean();
            studentParentDetailsBean.setSTUDENT_ID((Integer) session.getAttribute("STUDENT_ID"));
            studentParentDetailsBean.setSTUDENT_FATHER_NAME(request.getParameter("STUDENT_FATHER_NAME"));
            if (!"".equals(request.getParameter("STUDENT_FATHER_MOBILE_NUMBER"))) {
                studentParentDetailsBean.setSTUDENT_FATHER_MOBILE_NUMBER(request.getParameter("STUDENT_FATHER_MOBILE_NUMBER"));

            } else {
                studentParentDetailsBean.setSTUDENT_FATHER_MOBILE_NUMBER("");
            }

            if (!"".equals(request.getParameter("STUDENT_FATHER_OCCUPATION"))) {
                studentParentDetailsBean.setSTUDENT_FATHER_OCCUPATION(request.getParameter("STUDENT_FATHER_OCCUPATION"));

            } else {
                studentParentDetailsBean.setSTUDENT_FATHER_OCCUPATION(request.getParameter(""));
            }

            studentParentDetailsBean.setSTUDENT_MOTHER_NAME(request.getParameter("STUDENT_MOTHER_NAME"));

            if (!"".equals(request.getParameter("STUDENT_MOTHER_MOBILE_NUMBER"))) {
                studentParentDetailsBean.setSTUDENT_MOTHER_MOBILE_NUMBER(request.getParameter("STUDENT_MOTHER_MOBILE_NUMBER"));

            } else {
                studentParentDetailsBean.setSTUDENT_MOTHER_MOBILE_NUMBER(request.getParameter(""));

            }

            if (!"".equals(request.getParameter("STUDENT_MOTHER_OCCUPATION"))) {
                studentParentDetailsBean.setSTUDENT_MOTHER_OCCUPATION(request.getParameter("STUDENT_MOTHER_OCCUPATION"));

            } else {
                studentParentDetailsBean.setSTUDENT_MOTHER_OCCUPATION(request.getParameter("STUDENT_MOTHER_OCCUPATION"));

            }
            
            if (!"".equals(request.getParameter("STUDENT_GUARDIAN_NAME"))) {
                studentParentDetailsBean.setSTUDENT_GUARDIAN_NAME(request.getParameter("STUDENT_GUARDIAN_NAME"));

            } else {
                studentParentDetailsBean.setSTUDENT_GUARDIAN_NAME(request.getParameter(""));

            }
            
            if (!"".equals(request.getParameter("STUDENT_GUARDIAN_MOBILE"))) {
                studentParentDetailsBean.setSTUDENT_GUARDIAN_MOBILE(request.getParameter("STUDENT_GUARDIAN_MOBILE"));

            } else {
                studentParentDetailsBean.setSTUDENT_GUARDIAN_MOBILE(request.getParameter(""));

            }
            
            

            studentParentDetailsBean.setENTRY_ID((Integer) session.getAttribute("EMPLOYEE_ID"));

            StudentParentDetailsDAO studentParentDetailsDAO = new StudentParentDetailsDAOImpl();
            int i = studentParentDetailsDAO.addStudentParentDetails(studentParentDetailsBean);

            if (i > 0) {
                session.setAttribute("msg", "Student Parents Details Added.");
                response.sendRedirect("/ProgressiveHostel/Student/AddStudent.jsp?id=2");
            } else {
                session.setAttribute("wmsg", "Unable to Add Student Parents Details.");
                response.sendRedirect("/ProgressiveHostel/Student/AddStudent.jsp?id=1");
            }

        } catch (Exception e) {
            session.setAttribute("wmsg", "Unable to Add Student Parents Details.Try Again..");
            response.sendRedirect("/ProgressiveHostel/Student/AddStudent.jsp?id=1");
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
