/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentDocumentDetails.Controller;

import StudentDocumentDetails.Bean.StudentDocumentDetailsBean;
import StudentDocumentDetails.DAO.StudentDocumentDetailsDAO;
import StudentDocumentDetails.DAO.StudentDocumentDetailsDAOImpl;
import Utils.Upload;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author mishra
 */
@WebServlet(name = "AddStudentDocumentDetails", urlPatterns = {"/AddStudentDocumentDetails"})
public class AddStudentDocumentDetails extends HttpServlet {

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
        HashMap htmlfields = new HashMap();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            try {
                ServletFileUpload servlet = new ServletFileUpload();
                FileItemIterator fii = servlet.getItemIterator(request);
                StudentDocumentDetailsBean studentDocumentDetailsBean = new StudentDocumentDetailsBean();
                while (fii.hasNext()) {
                    FileItemStream file = fii.next();
                    if (file.isFormField()) {
                        InputStream input = file.openStream();
                        byte b[] = new byte[input.available()];
                        input.read(b);
                        String value = new String(b);
                        htmlfields.put(file.getFieldName(), value);
                    } else {
                        Calendar cal = Calendar.getInstance();
                        if (file.getFieldName().equals("STUDENT_PHOTO_DOC")) {
                            String fileName = Long.toString(cal.getTimeInMillis());
                            String postfix = "@Photo";
                            String s = Upload.writeFile(file, fileName + postfix);
                            studentDocumentDetailsBean.setSTUDENT_PHOTO_DOC(s);

                        } else if (file.getFieldName().equals("STUDENT_AADHAR_DOC")) {
                            String fileName = Long.toString(cal.getTimeInMillis());
                            String postfix = "@Aadhar";
                            String s = Upload.writeFile(file, fileName + postfix);
                            studentDocumentDetailsBean.setSTUDENT_AADHAR_DOC(s);

                        } else if (file.getFieldName().equals("STUDENT_SCHOOL_ID_DOC")) {
                            String fileName = Long.toString(cal.getTimeInMillis());
                            String postfix = "@SchoolId";
                            String s = Upload.writeFile(file, fileName + postfix);
                            studentDocumentDetailsBean.setSTUDENT_SCHOOL_ID_DOC(s);

                        }
                    }
                }

                studentDocumentDetailsBean.setENTRY_ID((Integer) session1.getAttribute("EMPLOYEE_ID"));
                studentDocumentDetailsBean.setSTUDENT_ID((Integer) session1.getAttribute("STUDENT_ID"));

                StudentDocumentDetailsDAO studentDocumentDetailsDAO = new StudentDocumentDetailsDAOImpl();
                int i = studentDocumentDetailsDAO.addStudentDocumentDetails(studentDocumentDetailsBean);

                if (i > 0) {
                    session1.setAttribute("msg", "Student All Details Added Successfully");
                    response.sendRedirect("/ProgressiveHostel/Student/AddStudent.jsp?id=4");

                } else {
                    session1.setAttribute("wmsg", "Unable to Add Student Documents Details");
                    response.sendRedirect("/ProgressiveHostel/Student/AddStudent.jsp?id=3");
                }

            } catch (Exception e) {
                session1.setAttribute("wmsg", "Unable to Add Student Documents Details.. Try Again..");
                response.sendRedirect("/ProgressiveHostel/Student/AddStudent.jsp?id=3");
            }
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
