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

import fr.devavance.calculatrice.Calculator;


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

        
        // Récuprération des arguments
        String operation= request.getParameter("operation");
        String operande1= request.getParameter("operande1");
        String operande2= request.getParameter("operande2");
  
      

        double resultat;
        
        try {
              if (operation==null || operande1 == null || operande2 == null ) 
                  throw new Exception("Format de l'opérationi invalide !");
            

            
            if (operation.equals("add"))
                resultat = Calculator.addition(operande1, operande2);
            else if (operation.equals("sub"))
                resultat = Calculator.soustraction(operande1, operande2);
            else if (operation.equals("div"))
                resultat = Calculator.division(operande1, operande2);
            else if (operation.equals("mul"))
                resultat = Calculator.multiplication(operande1, operande2);
            else throw new ServletException("Opération invalide !");
        }
        catch(ArithmeticException e){
            throw new ServletException(e);
        }
        catch (NumberFormatException e) {
               throw new ServletException(e);
        }
        catch (Exception e) {
               throw new ServletException(e);
        }
        
        
        
               
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

       
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Calculator</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div>");
        out.println("<p class=\"operande\">Operande 1 : " + operande1+"</p>");
        out.println("<p class=\"operande\">Operande 2 : " + operande2+"</p>");
        out.println("<p class=\"operation\">Operateur : " + operation+"</p>");
        out.println("<p class=\"resultat\">resultat : " + resultat+"</p>");
        out.println("</div>");
      
        out.println("</body>");
        out.println("</html>");

        out.close();

    }

}
