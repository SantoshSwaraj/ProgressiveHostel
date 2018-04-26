/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentMaster.Controller;

import Session.Bean.SessionBean;
import Session.DAO.SessionDAO;
import Session.DAO.SessionDAOImpl;
import StudentMaster.Bean.StudentMasterBean;
import StudentMaster.DAO.StudentMasterDAO;
import StudentMaster.DAO.StudentMasterDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "AddStudentMaster", urlPatterns = {"/AddStudentMaster"})
public class AddStudentMaster extends HttpServlet {

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
            studentMasterBean.setSTUDENT_NAME(request.getParameter("STUDENT_NAME"));
            studentMasterBean.setSESSION_ID(Integer.parseInt(request.getParameter("SESSION_ID")));
            studentMasterBean.setCLASS_ID(Integer.parseInt(request.getParameter("CLASS_ID")));
            studentMasterBean.setSECTION_ID(Integer.parseInt(request.getParameter("SECTION_ID")));
            studentMasterBean.setSTUDENT_ROLL_NO(Integer.parseInt(request.getParameter("STUDENT_ROLL_NO")));

            String td[] = request.getParameter("STUDENT_DOB").split("-");
            if (td.length == 3) {
                studentMasterBean.setSTUDENT_DOB(new Date(Integer.parseInt(td[0]) - 1900, Integer.parseInt(td[1]) - 1, Integer.parseInt(td[2])));
            } else {
                studentMasterBean.setSTUDENT_DOB(null);
            }

            SessionDAO sessionDAO = new SessionDAOImpl();
            SessionBean sessionBean = sessionDAO.getSessionById(Integer.parseInt(request.getParameter("SESSION_ID")));
           
            StudentMasterDAO studentMasterDAO  = new StudentMasterDAOImpl();
            String ADMISSION_NO = studentMasterDAO.generateAdmissionNo(sessionBean);
            studentMasterBean.setADMISSION_NO(ADMISSION_NO);
            studentMasterBean.setIS_ACTIVE(1);

            studentMasterBean.setENTRY_ID((Integer) session.getAttribute("EMPLOYEE_ID"));

            //StudentMasterDAO studentMasterDAO = new StudentMasterDAOImpl();
            int NEW_STUDENT_ID = studentMasterDAO.addStudentMaster(studentMasterBean);

            if (NEW_STUDENT_ID > 0) {
                session.setAttribute("STUDENT_ID", NEW_STUDENT_ID);
                session.setAttribute("msg", "Student Basic Details Added.");
                response.sendRedirect("/ProgressiveHostel/Student/AddStudent.jsp?id=1");
            } else {
                session.setAttribute("wmsg", "Unable to Added Student Basic Details.");
                response.sendRedirect("/ProgressiveHostel/Student/AddStudent.jsp?id=0");
            }

        } catch (Exception e) {
            session.setAttribute("wmsg", "Unable to Added Student Basic Details.. Try Again..");
            response.sendRedirect("/ProgressiveHostel/Student/AddStudent.jsp?id=0");
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
