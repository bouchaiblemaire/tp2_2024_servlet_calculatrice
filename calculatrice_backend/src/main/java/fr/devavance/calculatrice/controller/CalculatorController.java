package fr.devavance.calculatrice.controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.devavance.calculatrice.Calculator;
import fr.devavance.calculatrice.beans.Operation;
import fr.devavance.calculatrice.controller.interfaces.IController;
import fr.devavance.calculatrice.exceptions.InvalidOperation;

import fr.devavance.calculatrice.exceptions.OperatorException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author B. LEMAIRE
 * Controller pour la calculatrice
 */
 

@WebServlet(urlPatterns = {"/calculate/*"})
public class CalculatorController extends HttpServlet implements IController {
    
    private static List <String> permittedOperators = null;
    

    @Override
    public void init() throws ServletException {
        super.init();
        this.permittedOperators = Arrays.asList(IController.permittedOperations);    
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
       
        Operation operation = proceedParametersExtraction(request);
  
        proceedOperation(operation);
        
        System.out.println(operation);
        proceedView(response, operation);
     

    }

       
    
    public Operation proceedParametersExtraction(HttpServletRequest request){
         
        
        Operation operationToCalculate = createOperation(request);
        
        checkOperator(operationToCalculate);
        
        return operationToCalculate;
          
    }
    
   
    
    
     public void proceedOperation(Operation operation) {
            
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
            else throw new InvalidOperation();
        
        
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
    
    

    /**
     * Check the validity of the operator
     * @param operationToCalculate : Operation to calculate
     * @throws OperatorException : The operator is not permitted
     */
    private  void checkOperator(Operation operationToCalculate) 
            throws OperatorException {
        if (operationToCalculate.getOperator()==null
            || operationToCalculate.getOperator().isEmpty() 
            || ! this.permittedOperators.contains(operationToCalculate.getOperator())
            )
        
            throw new OperatorException();
    }
    
    
    
    
    /**
     * check and convert the operands from String to int
     * @param s_operande_1
     * @param s_operande_2
     * @return The operation to calculate
     * @throws NumberFormatException : Their is a problem with de conversion
     */
    private Operation checkAndConvertOperandesToInteger(
                                       String s_operande_1, 
                                       String s_operande_2) 
                                 throws NumberFormatException{
        
        
        Operation operationToBeCalculate = new Operation(
                              Integer.parseInt(s_operande_1), 
                              Integer.parseInt(s_operande_2) 
                                   );
        
        return operationToBeCalculate;
    }

    /**
     * Create the opearation
     * @param request
     * @return The operation to calculate
     * @throws NumberFormatException : Their is a problem with de conversion
     */
    private  Operation createOperation(HttpServletRequest request) {
        String operator= request.getParameter("operation");
        String operande1= request.getParameter("operande1");
        String operande2= request.getParameter("operande2");    
    
        Operation operationToCalculate =  
                checkAndConvertOperandesToInteger(operande1, operande2);
        
        return operationToCalculate;
    
    }
    

}
