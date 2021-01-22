/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examemployee.servlets;

import com.mycompany.examemployee.entity.EmployeeTB;
import com.mycompany.examemployeeclient.service.EmployeeClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author mohit
 */
public class TestServlet extends HttpServlet {

    @Inject
    @RestClient
    EmployeeClient employeeClient;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
            out.println("<form method='post'>");
            out.println("<label>Department Name</label>");
            out.println("<select name='drpdeptid'>");
            out.println("<option value='Select Department'>Select Department</option>");
            out.println("<option value='IT'>IT</option>");
            out.println("<option value='Sales'>Sales</option>");
            out.println("</select>");
            out.println("<input type='submit' name='btnsubmit' value='Submit' />");
            out.println("</form>");

            if (!request.getParameter("drpdeptid").equals("Select Department")) {
                String deptName = request.getParameter("drpdeptid");

                out.println("<table border='1'>");
                out.println("<tr><td>Id</td>");
                out.println("<td>Name</td>");
                out.println("<td>Department Name</td>");
                out.println("<td>Salary</td></tr>");
                Collection<EmployeeTB> emps = employeeClient.GetEmployees(deptName);
                for (EmployeeTB emp : emps) {
                    out.println("<tr><td>" + emp.getId() + "</td>");
                    out.println("<td>" + emp.getName() + "</td>");
                    out.println("<td>" + emp.getDepartmentName() + "</td>");
                    out.println("<td>" + emp.getSalary() + "</td></tr>");
                }
                out.println("</table>");
            } else {
            }

            out.println("</body>");
            out.println("</html>");
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
