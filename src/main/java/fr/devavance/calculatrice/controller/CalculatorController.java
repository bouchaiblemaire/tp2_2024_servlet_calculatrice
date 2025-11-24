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
import fr.devavance.calculatrice.beans.ParseCRUD;
import fr.devavance.calculatrice.exception.CalculatorException;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
/**
 *
 * @author marmotton
 */
@WebServlet(urlPatterns = {"/calculate/*"})
public class CalculatorController extends HttpServlet {

    

     //<editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
  
        
       if (request.getPathInfo() == null ) throw new ServletException("Pas d'arguments !");
        
       response.setContentType("text/html;charset=UTF-8");
  
  
       PrintWriter out = response.getWriter();
              
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculator</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            /* Question 1 */
            out.println("<p> request.getContextPath() : "+ request.getContextPath() + "</p>");
            out.println("<p> request.getPathInfo() : "+ request.getPathInfo()+ "</p>");
            
            /* Question 2 */
            try {
                HashMap <String, String> crud_args = ParseCRUD.parsePathInfo(request);
                out.println(crud_args.toString());
            }
            catch(CalculatorException e){
                throw new ServletException(e);
            }
            
            
            
             out.println("<p>"+Calculator.add("12","20") + "</p>");
            out.println("</body>");
            out.println("</html>");
            
            out.close();
    
    }

    
  
}
