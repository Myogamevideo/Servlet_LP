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
 */
@WebServlet(name = "ShoppingCart", urlPatterns = {"/shopping-cart"})
public class ShoppingCart extends HttpServlet {

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
            out.println("<title>Servlet ShoppingCart</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShoppingCart</h1>");
            out.println("<br />");
            out.println("<h2>Articles dans le panier :</h2>");
            out.println("<ul>");
            if(request.getSession().getAttribute("cart") != null) {
                ArrayList<String> cartProducts = (ArrayList<String>)request.getSession().getAttribute("cart");
                if(cartProducts != null) {
                    cartProducts.forEach((product) -> {
                        out.println("<li>"+ product +"</li>");
                    });
                }
            }
            out.println("</ul>");
            out.println("<br />");
            out.println("<h2>Articles disponible :</h2>");
            out.println("<form method='post'>");
            out.println("<ul>");
            products.forEach(article -> {
                out.println("<li><input type=checkbox name=articles value="+ article +"><label>"+ article +"</label</li>");
            });
            out.println("</ul>");
            if(products.size() > 0) {
                out.println("<input type=submit value='Ajouter au panier' />");
            }
            out.println("</form>");
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
        String[] articles = request.getParameterValues("articles");
        
        
        ArrayList<String> cartProducts = new ArrayList<>();
        
        if(request.getSession().getAttribute("cart") != null) {
            cartProducts = (ArrayList<String>)request.getSession().getAttribute("cart");
        }
        
        if(cartProducts != null) {
            for (int i = 0; i < articles.length; i++) {
                cartProducts.add(articles[i]);
            }
            request.getSession().setAttribute("cart", cartProducts);
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
