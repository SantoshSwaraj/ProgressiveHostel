/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassSection.Controller;

import ClassSection.Bean.ClassSectionBean;
import ClassSection.DAO.ClassSectionDAO;
import ClassSection.DAO.ClassSectionDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
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
@WebServlet(name = "GetSectionsByClassId", urlPatterns = {"/GetSectionsByClassId"})
public class GetSectionsByClassId extends HttpServlet {

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
            int CLASS_ID = Integer.parseInt(request.getParameter("CLASS_ID"));
            ClassSectionDAO classSectionDAO = new ClassSectionDAOImpl();
            ArrayList<ClassSectionBean> classSectionBeanList = classSectionDAO.getSectionsByClassId(CLASS_ID);
            Iterator it = classSectionBeanList.iterator();
            out.println("<option value=''>Select Section</option>");
            while (it.hasNext()) {
                ClassSectionBean classSectionBean = (ClassSectionBean) it.next();
                out.println("<option value = " + classSectionBean.getSECTION_ID()+ ">" + classSectionBean.getSectionBean().getSECTION_NAME()+ "</option>");
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
