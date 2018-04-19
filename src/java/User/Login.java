/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        HttpSession session1 = request.getSession();
        try {
            int i = 0;
            UserBean userBean = new UserBean();
            userBean.setUSERNAME(request.getParameter("USERNAME"));
            userBean.setPASSWORD(request.getParameter("PASSWORD"));
            int USER_ID = Query.checkLoginDetails(userBean);
            if (USER_ID > 0) {
                HttpSession session = request.getSession();
                userBean = Query.viewLoginUserDetails(USER_ID);
                session.setAttribute("USER_ID", userBean.getUSER_ID());
                session.setAttribute("EMPLOYEE_ID", userBean.getEMPLOYEE_ID()); 
                session.setAttribute("EMP_NAME", userBean.getEMP_NAME());
                session.setAttribute("MOBILE_NO", userBean.getMOBILE_NO());
                session.setAttribute("EMAIL", userBean.getEMAIL());
                session.setAttribute("USERNAME", userBean.getUSERNAME());
                session.setAttribute("PASSWORD", userBean.getPASSWORD());
                session.setAttribute("USER_TYPE_ID", userBean.getUSER_TYPE_ID()); 
                session.setAttribute("STATUS", userBean.getSTATUS()); 
                response.sendRedirect("/ProgressiveHostel/AdminDashboard.jsp"); 
            } else {
                session1.setAttribute("wmsg", "Username and password not matched.");
                response.sendRedirect("/ProgressiveHostel/index.jsp");
            }
        } catch (IOException e) {
            session1.setAttribute("wmsg", "Try Again Later.");
            response.sendRedirect("/ProgressiveHostel/index.jsp");
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
