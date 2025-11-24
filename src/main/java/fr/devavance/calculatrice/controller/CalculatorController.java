package fr.devavance.calculatrice.controller;

/*
 * Click nbfs:nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs:nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.devavance.calculatrice.beans.Calculator;
import fr.devavance.calculatrice.beans.Operation;
import javax.servlet.RequestDispatcher;

/**
 * @author marmotton
 */
@WebServlet(name="CalculatorController", urlPatterns = {"/calculate/*"})
public class CalculatorController extends HttpServlet {

    
    
    
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
        
 
        
            request.setCharacterEncoding("UTF-8") ;
	    
            // Récupération des données
            String s_operande1 = request.getParameter("operande1") ;
            String s_operande2 = request.getParameter("operande2") ;
            String s_operateur = request.getParameter("operateur") ;
            
            
             
            if (s_operande1==null || s_operande2==null || s_operateur==null){
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            
     
            // Calcul du résultat
            double resultat=0.0;
            
            try {
                resultat = Calculator.add(s_operande1, s_operande2);
            }
            catch(NumberFormatException e){
                throw new ServletException(e);
            }
    
            
            Operation operation = new Operation(s_operande1, 
                    s_operande2, 
                    s_operateur, 
                    String.valueOf(resultat)
            );
            
            
            // Activation de la vue resultat
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            request.setAttribute("operation", operation);    
            rd.forward(request, response);
                 
      
    
    }

    
  
}
