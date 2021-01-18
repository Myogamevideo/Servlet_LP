/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarry.servlet.tp.one;

import com.jarry.servlet.tp.one.datas.Stub;
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
 * @author aj-al
 * @WebServlet("/shopping")
 */
@WebServlet(name = "Shopping", urlPatterns = {"/shopping"})
public class Shopping extends HttpServlet {
    
    private static final ArrayList<String> products = Stub.getProducts();
    
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
            out.println("<title>Servlet Shopping</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Shopping</h1>");
            if(response.getStatus() == 404) {
                out.println("<h2>Article(s) non trouvé(s).</h2>");
            } else if (response.getStatus() >= 400) {
                out.println("<h2>Une erreur est survenue lors de la tentative de l'ajout de l'article.</h2>");
            }else {
                out.println("<h2>Articles :</h2>");
                out.println("<ul>");
                Shopping.products.forEach(article -> {
                    out.println("<li>"+ article +"</li>");
                });
                out.println("</ul>");
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
        String newProduct = request.getParameter("product");

        if(newProduct == null) {
            response.setStatus(400);
        } else {
            Shopping.products.add(newProduct);
            response.setStatus(201);
            processRequest(request, response);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productToEdit = request.getParameter("product");
        String newProductValue = request.getParameter("new-value");

        System.out.println(productToEdit);
        System.out.println(newProductValue);
        
        if(productToEdit == null || productToEdit.isEmpty() || newProductValue == null || newProductValue.isEmpty()) {
            response.setStatus(400);
        } else if(products.contains(productToEdit)) {
            for (int i = 0; i < products.size(); i++) {
                if(products.get(i).equals(productToEdit)) {
                    products.set(i, newProductValue);
                }
            }
        } else {
            response.setStatus(404);
        }
        
        processRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productToDelete = request.getParameter("product");
        
        System.out.println(productToDelete);
        
        if(productToDelete == null || productToDelete.isEmpty()) {
            response.setStatus(400);
        } else if(!products.contains(productToDelete)) {
            response.setStatus(404);
        } else {
            for (int i = 0; i < products.size(); i++) {
                if(products.get(i).equals(productToDelete)) {
                    products.remove(i);
                }
            }
        }
        
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
