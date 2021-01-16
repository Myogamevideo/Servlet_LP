/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp1_servlet;

/**
 *
 * @author Alexandre
 */
public class Article {
    private int reference; 
    private String designation; 
    private double prixUnit; 
    private int quantite;  

    public  Article(int ref, String des, double pu, int qu) { 
       this.reference = ref; 
       this.designation=des; 
       this.prixUnit=pu; 
       this.quantite=qu; 
    } 
    
    public  Article() { 
       this.reference = 0; 
       this.designation = null; 
       this.prixUnit = 0; 
       this.quantite = 0; 
    } 

    public void afficherArticle() { 
       System.out.println(reference+"  "+designation+"  "+prixUnit+"  "+quantite); 
    }  
    
    public void setReference(int reference){
        this.reference = reference;
    }
    
    public int getReference(){
        return reference;    
    }
    
    public void setDesignation(String designation){
        this.designation = designation;
    }
    
    public String getDesignation(){
        return designation;    
    }
    
    public void setPrixUnit(double prixUnit){
        this.prixUnit = prixUnit;
    }
    
    public double getPrixUnit(){
        return prixUnit;    
    }
    
    public void setQuantite(int quantite){
        this.quantite = quantite;
    }
    
    public int getQuantite(){
        return quantite;    
    }
}
