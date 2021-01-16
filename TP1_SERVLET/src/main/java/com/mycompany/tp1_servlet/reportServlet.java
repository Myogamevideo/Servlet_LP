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
public class reportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        try (PrintWriter out = response.getWriter ()) {
            int reference = Integer.parseInt(request.getParameter("reference"));
            String designation = request.getParameter("designation");
            Article a = new Article();
            a.setReference(reference);
            a.setDesignation(designation);
            int status = artDBHandler.save(a);
            if (status > 0){
                out.print ("<p>Record saved successfully!</p>");
                request.getRequestDispatcher ("index.html").include(request, response);
            }else{
                out.println ("Sorry! unable to save record");
            }
        }
    }
}
