/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarry.jsp.tp.two.service;

import com.jarry.jsp.tp.two.data.ArticleStub;
import com.jarry.jsp.tp.two.model.Article;
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
@WebServlet(name = "ArticleService", urlPatterns = {"/articles"})
public class ArticleService extends HttpServlet {
    
    private static ArrayList<Article> articles = ArticleStub.getAll();

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

        request.getRequestDispatcher("articles.jsp").forward(request, response);

    }

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
        request.setAttribute("articles", articles);
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
        String[] newCartArticles = request.getParameterValues("articles");
        
        ArrayList<Article> cartProducts = new ArrayList<>();
        
        if(request.getSession().getAttribute("cart") != null) {
            cartProducts = (ArrayList<Article>)request.getSession().getAttribute("cart");
        }
        
        if(cartProducts != null && (newCartArticles != null && newCartArticles.length > 0)) {
            for (int i = 0; i < newCartArticles.length; i++) {
                for(Article article : articles) {
                    if(article.getId() == Integer.valueOf(newCartArticles[i])) {
                        cartProducts.add(article);
                    }
                };
            }
            request.getSession().setAttribute("cart", cartProducts);
        }
        
        request.setAttribute("articles", articles);
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
    }

}
