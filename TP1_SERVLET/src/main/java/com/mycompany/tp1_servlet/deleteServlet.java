/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp1_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexandre
 */
public class deleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        int status = artDBHandler.delete(id);
        if (status > 0){
            out.print ("<p>Record deleted successfully!</p>");
            response.sendRedirect("viewServlet");
        }else{
            out.println ("Sorry! unable to delete record");
        }
        response.sendRedirect ("viewServlet");
    } 
}
