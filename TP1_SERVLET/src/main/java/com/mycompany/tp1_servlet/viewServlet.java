/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp1_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexandre
 */
public class viewServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        try (PrintWriter out = response.getWriter ()) {
            out.println ("<a href='index.html'>Add Article</a>");
            out.println ("<h1>Article List</h1>");
            List<Article> list = artDBHandler.getAllArticle();            
            out.print ("<table border='1' width='100%' ");
            out.print("<tr><th>Reference</th><th>Designation</th><th>PrixUnit</th><th>Quantite</th><th>Update</th><th>Delete</th></tr>");
            
            list.forEach(e -> {
                out.print ("<tr><td>" + e.getReference () + "</td><td>" + e.getDesignation () + "</td><td>" + e.getPrixUnit () + "</td><td>" + e.getQuantite () +
                        "</td><td><a href='updateServlet?id=" + e.getReference () +"'>update</a></td>"
                                + "<td><a href='deleteServlet?id=" + e.getReference () + "'>delete</a></td></tr>");
            });
            out.print ("</table>");
        }
    }
}
