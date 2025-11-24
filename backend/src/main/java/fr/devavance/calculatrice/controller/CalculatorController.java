package fr.devavance.calculatrice.controller;

<<<<<<< HEAD:backend/src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java

=======
/*
 * Click nbfs:nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs:nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import fr.devavance.calculatrice.Operation;
>>>>>>> ed212755453492682d2a0ae9ed6f9ba290baac25:src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD:backend/src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java
import fr.devavance.calculatrice.metiers.Calculator;
=======
import fr.devavance.calculatrice.Calculator;
import fr.devavance.calculatrice.Operation;
>>>>>>> ed212755453492682d2a0ae9ed6f9ba290baac25:src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java


/**
 *
 * @author B. LEMAIRE
 * Controller pour la calculatrice
 */
 
// Pour serveur Tomcat de démonstration
//@WebServlet(urlPatterns = {"/calculate/etape_1/*"}) 
@WebServlet(urlPatterns = {"/calculate/*"})
<<<<<<< HEAD:backend/src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java
public class CalculatorController extends HttpServlet {
<<<<<<< HEAD:backend/src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java


=======
    
=======
public class CalculatorController extends HttpServlet { 
>>>>>>> af48c414c899b360b4a445416485f3bc7c79eec3:src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java
    //<editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
>>>>>>> ed212755453492682d2a0ae9ed6f9ba290baac25:src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response)
<<<<<<< HEAD:backend/src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java
        throws ServletException, ArithmeticException, NumberFormatException, 
            IOException {

                
        // Récuprération des arguments
        String operation= request.getParameter("operation");
=======
            throws ServletException, IOException {
       
        Operation operation = new Operation();
  
        extractParamsFromURLParamaters(request, operation);
      
        checkIfAllElementsOfOperationNotEmpty(operation);
        
        proceedOperation(operation);
        
        proceedView(response, operation);
     

    }
    
    
    private void extractParamsFromURLParamaters(HttpServletRequest request, 
            Operation operation){
        
        String operator= request.getParameter("operation");
>>>>>>> ed212755453492682d2a0ae9ed6f9ba290baac25:src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java
        String operande1= request.getParameter("operande1");
        String operande2= request.getParameter("operande2");
        
<<<<<<< HEAD:backend/src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java

        if (operation==null || operande1 == null || operande2 == null ) 
         throw new ServletException("Format de l'opérationi invalide !");
=======
        operation.setOperator(operator);
        operation.setOperande1(operande1);
        operation.setOperande2(operande2);
    }
    
    
    private void checkIfAllElementsOfOperationNotEmpty(Operation operation) 
            throws ServletException{
        
        String operator= operation.getOperator();
        String operande1= operation.getOperande1();
        String operande2= operation.getOperande2();
                         
        if (operator==null 
            || operator.isEmpty() 
            || operande1 == null
            || operande1.isEmpty()
            || operande2 == null 
            || operande2.isEmpty()
         ) 
        throw new ServletException("Format de l'opérationi invalide !");
        
    }
    
    
    
     private void proceedOperation(Operation operation) 
            throws ServletException{
>>>>>>> ed212755453492682d2a0ae9ed6f9ba290baac25:src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java
            
        String operator= operation.getOperator();
        String operande1= operation.getOperande1();
        String operande2= operation.getOperande2();
        
        double result;
            
<<<<<<< HEAD:backend/src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java
        if (operation.equals("add"))
          resultat = Calculator.addition(operande1,
                  operande2);
        else if (operation.equals("sub"))
          resultat = Calculator.soustraction(operande1, 
                  operande2);
        else if (operation.equals("div"))
                resultat = Calculator.division(operande1,
                        operande2);
            else if (operation.equals("mul"))
                resultat = Calculator.multiplication(operande1,
                        operande2);
            else throw new ServletException("Opération invalide !");
  
       
      
        
     
=======
        
         try {            
            if (operator.equals("add"))
                result = Calculator.addition(operande1, 
                        operande2);
            else if (operator.equals("sub"))
                result = Calculator.soustraction(operande1, 
                        operande2);
            else if (operator.equals("div"))
                result = Calculator.division(operande1, 
                        operande2);
            else if (operator.equals("mul"))
                result = Calculator.multiplication(operande1, 
                        operande2);
            else throw new Exception("Opération invalide !");
        }
        catch(ArithmeticException e ){
            throw new ServletException(e);
        }
        catch (NumberFormatException e) {
               throw new ServletException(e);
        }
        catch (Exception e) {
               throw new ServletException(e);
        }       
   
        operation.setResult(result);
        
    }
     
    public void proceedView(HttpServletResponse response, Operation operation) 
            throws IOException{
        
           
        String operator= operation.getOperator();
        String operande1= operation.getOperande1();
        String operande2= operation.getOperande2();
        double result = operation.getResult();
>>>>>>> ed212755453492682d2a0ae9ed6f9ba290baac25:src/main/java/fr/devavance/calculatrice/controller/CalculatorController.java
        
               
        response.setContentType("text/html;charset=UTF-8");
        
                PrintWriter out = response.getWriter();
        try {

       
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Calculator</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div>");
        out.println("<p class=\"operande\">Operande 1 : " + operande1+"</p>");
        out.println("<p class=\"operande\">Operande 2 : " + operande2+"</p>");
        out.println("<p class=\"operation\">Operateur : " + operator+"</p>");
        out.println("<p class=\"resultat\">resultat : " + result +"</p>");
        out.println("</div>");
      
        
        out.write("<br><br>");
	out.write(
  "<a href=\"http://localhost:8080/calculatrice_frontend/\" >Home Page</a>");
        
        out.println("</body>");
        out.println("</html>");
        }
        finally{
        out.close();
        }
    }
    
}
