/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Section.Controller;

import Section.Bean.SectionBean;
import Section.DAO.SectionDAO;
import Section.DAO.SectionDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mishra
 */
@WebServlet(name = "GetSections", urlPatterns = {"/GetSections"})
public class GetSections extends HttpServlet {

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
        try {
            SectionDAO sectionDAO = new SectionDAOImpl();
            ArrayList<SectionBean> sectionBeanList = sectionDAO.getSections();
            if (!sectionBeanList.isEmpty()) {
                for (SectionBean sectionBean : sectionBeanList) {
                    out.println("<tr id='" + sectionBean.getSECTION_ID() + "'>");
                    out.println("<td>");
                    out.println(sectionBean.getSECTION_ID());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(sectionBean.getSECTION_NAME());
                    out.println("</td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<tr>");
                out.println("<td style='colspan:2'>");
                out.println("Data Not Available");
                out.println("<td>");
                out.println("<tr>");
            }
        } catch (Exception e) {
            out.println("<tr>");
            out.println("<td style='colspan:2'>");
            out.println("Data Not Available");
            out.println("<td>");
            out.println("<tr>");
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
