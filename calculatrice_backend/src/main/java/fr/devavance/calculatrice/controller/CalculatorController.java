package fr.devavance.calculatrice.controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.devavance.calculatrice.Calculator;
import fr.devavance.calculatrice.Operation;

import fr.devavance.calculatrice.exceptions.OperatorException;
import java.util.ArrayList;


/**
 *
 * @author B. LEMAIRE
 * Controller pour la calculatrice
 */
 

@WebServlet(urlPatterns = {"/calculate/*"})
public class CalculatorController extends HttpServlet {
    
    private static ArrayList<String> permittedOperators = null;
    

    @Override
    public void init() throws ServletException {
        super.init();
        this.permittedOperators = new ArrayList<>();
        
        this.permittedOperators.add("add");
        this.permittedOperators.add("sub");
        this.permittedOperators.add("mul");
        this.permittedOperators.add("div");
        
        
    }
    
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
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
       
        Operation operation = new Operation();
  
        extractAndCheckParamsFromURLParamaters(request, operation);
        
        proceedOperation(operation);
        
        proceedView(response, operation);
     

    }

    
    
    private void extractAndCheckParamsFromURLParamaters(HttpServletRequest request, 
            Operation operation){
        
        String operator= request.getParameter("operation");
        String operande1= request.getParameter("operande1");
        String operande2= request.getParameter("operande2");
        
        checkOperator(operator);
          
        Operandes operandes =  convertOperandesToInteger(operande1, operande2);
        
        operation.setOperator(operator);
        operation.setOperande1(operandes.getOperande1());
        operation.setOperande2(operandes.getOperande2());
    }
    
    

    private void checkOperator(String operator) throws OperatorException {
        if (operator==null
                || operator.isEmpty() 
                || ! this.permittedOperators.contains(operator))
            
            throw new OperatorException();
    }
    
    
    
     private void proceedOperation(Operation operation) 
            throws ServletException{
            
        String operator= operation.getOperator();
        Integer operande1= operation.getOperande1();
        Integer operande2= operation.getOperande2();
        
        double result;
                 
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
            else throw new ServletException("Opération invalide !");
        
        
        operation.setResult(result);
        
    }
     
    public void proceedView(HttpServletResponse response, Operation operation) 
            throws IOException{
        
           
        String operator= operation.getOperator();
        Integer operande1= operation.getOperande1();
        Integer operande2= operation.getOperande2();
        double result = operation.getResult();
        
               
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
      
        out.println("</body>");
        out.println("</html>");
        }
        finally{
        out.close();
        }
    }
    
    
    
    private static Operandes convertOperandesToInteger(
                                       String s_operande_1, 
                                       String s_operande_2) 
                                 throws NumberFormatException{
        
        
        Operandes operandes = new Operandes(
                              Integer.parseInt(s_operande_1), 
                              Integer.parseInt(s_operande_2) 
                                   );
        
        return operandes;
    }
    
    
    private static class Operandes {
        
        private Integer operande1;
        private Integer operande2;

        public Operandes(Integer operande1, Integer operande2) {
            this.operande1 = operande1;
            this.operande2 = operande2;
        }

        public Integer getOperande1() {
            return operande1;
        }

        public Integer getOperande2() {
            return operande2;
        }
        
        
    }

}
