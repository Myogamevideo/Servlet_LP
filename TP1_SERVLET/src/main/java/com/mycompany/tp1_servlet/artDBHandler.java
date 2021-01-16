/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp1_servlet;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Alexandre
 */
public class artDBHandler {
    public static Connection getConnection ()
    {
        Connection con = null;
        try
        {
            con = DriverManager.getConnection ("jdbc:derby://localhost:1527/TP1_Servlet","root", "root");;
        } 
        catch (SQLException e)
        {
            System.out.println (e);
        }
        return con;
    }
    
    public static int save(Article a)
    {
        int status = 0;
        try
        {
            Connection con = artDBHandler.getConnection ();
            PreparedStatement ps = con.prepareStatement ("insert into article (reference, designation) values (?,?)");
            ps.setInt(1, a.getReference ());
            ps.setString (2, a.getDesignation ());
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (SQLException ex)
        {
            ex.printStackTrace ();
        }
        return status;
    }
    
    public static int update (Article a)
    {
        int status = 0;
        try
        {
            Connection con = artDBHandler.getConnection ();
            PreparedStatement ps = con.prepareStatement ("update article set designation=?");
            ps.setString (1, a.getDesignation ());
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (SQLException ex)
        {
            ex.printStackTrace ();
        }
        return status;
    }
    
    public static int delete (int id)
    {
        int status = 0;
        try
        {
            Connection con = artDBHandler.getConnection ();
            PreparedStatement ps =con.prepareStatement ("delete from article where reference=?");
            ps.setInt (1, id);
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (SQLException e)
        {
            e.printStackTrace ();
        }
        return status;
    }
    
    public static Article getArticleById (int id)
    {
        Article e = new Article ();
        try
        {
            Connection con = artDBHandler.getConnection ();
            PreparedStatement ps =con.prepareStatement ("select * from article where id=?");
            ps.setInt (1, id);
            ResultSet rs = ps.executeQuery ();
            if (rs.next ())
            {
             e.setReference(rs.getInt(1));
             e.setDesignation(rs.getString(2));
             e.setQuantite(rs.getInt(3));
            }
            con.close ();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace ();
        }
        return e;
    }
    
    public static List <Article> getAllArticle ()
    {
        List<Article> list = new ArrayList<Article>();
        try
        {
            Connection con = artDBHandler.getConnection ();
            PreparedStatement ps = con.prepareStatement ("select * from article");
            ResultSet rs = ps.executeQuery ();
            while (rs.next ())
         {
             Article e = new Article ();
             e.setReference(rs.getInt(1));
             e.setDesignation(rs.getString(2));
             e.setQuantite(rs.getInt(3));
             list.add (e);
         }
            con.close ();
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
        return list;
    }
}
