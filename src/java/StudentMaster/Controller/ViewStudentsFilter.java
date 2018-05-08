/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentMaster.Controller;

import StudentMaster.Bean.StudentMasterBean;
import StudentMaster.DAO.StudentMasterDAO;
import StudentMaster.DAO.StudentMasterDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "ViewStudentsFilter", urlPatterns = {"/ViewStudentsFilter"})
public class ViewStudentsFilter extends HttpServlet {

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
            if (request.getParameter("SESSION_ID") != null) {
                studentMasterBean.setSESSION_ID(Integer.parseInt(request.getParameter("SESSION_ID")));

            } else {
                studentMasterBean.setSESSION_ID(0);
            }

            if (request.getParameter("CLASS_ID") != null) {
                studentMasterBean.setCLASS_ID(Integer.parseInt(request.getParameter("CLASS_ID")));
            } else {
                studentMasterBean.setCLASS_ID(0);

            }

            if (request.getParameter("SECTION_ID") != null) {
                studentMasterBean.setSECTION_ID(Integer.parseInt(request.getParameter("SECTION_ID")));
            } else {
                studentMasterBean.setSECTION_ID(0);

            }
            Date START_DATE = null;
            String fd[] = request.getParameter("START_DATE").split("T");
            String td[] = fd[0].split("-");
            if (td.length == 3) {
                START_DATE = (new Date(Integer.parseInt(td[0]) - 1900, Integer.parseInt(td[1]) - 1, Integer.parseInt(td[2])));
            }

            Date END_DATE = null;
            String fd1[] = request.getParameter("END_DATE").split("T");
            String td1[] = fd1[0].split("-");
            if (td1.length == 3) {
                END_DATE = (new Date(Integer.parseInt(td1[0]) - 1900, Integer.parseInt(td1[1]) - 1, Integer.parseInt(td1[2])));
            }

            StudentMasterDAO studentMasterDAO = new StudentMasterDAOImpl();
            ArrayList<StudentMasterBean> studentMasterBeanRecvList = studentMasterDAO.getStudentMasterDetailsByFilter(studentMasterBean, START_DATE, END_DATE);
            if (!studentMasterBeanRecvList.isEmpty()) {
                int count = 1;
                for (StudentMasterBean studentMasterBean1 : studentMasterBeanRecvList) {
                    out.println("<tr id='" + studentMasterBean1.getSTUDENT_ID() + "'>");
                    out.println("<td>");
                    out.println(count);
                    out.println("</td>");
                    out.println("<td>");
                    out.println(studentMasterBean1.getSessionBean().getSESSION());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(studentMasterBean1.getSTUDENT_ID());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(studentMasterBean1.getSTUDENT_NAME());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(studentMasterBean1.getADMISSION_NO());
                    out.println("</td>");
                    out.println("<td>");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    out.println(sdf.format(studentMasterBean1.getENTRY_DATE()));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(studentMasterBean1.getClassBean().getCLASS_NAME());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(studentMasterBean1.getSectionBean().getSECTION_NAME());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(studentMasterBean1.getSTUDENT_ROLL_NO());
                    out.println("</td>");
                    out.println("</tr>");
                }
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
