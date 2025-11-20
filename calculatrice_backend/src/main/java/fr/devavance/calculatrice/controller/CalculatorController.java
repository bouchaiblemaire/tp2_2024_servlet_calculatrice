package fr.devavance.calculatrice.controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.devavance.calculatrice.beans.Operation;
import fr.devavance.calculatrice.controller.interfaces.IController;
import fr.devavance.metier.calculatrice.Operator;
import fr.devavance.metier.calculatrice.patterns.factory.caclators.factory.CalculatorFactory;
import fr.devavance.metier.calculatrice.patterns.factory.interfaces.ICalculator;


/**
 *
 * @author B. LEMAIRE
 * Controller pour la calculatrice
 */
 

@WebServlet(urlPatterns = {"/calculate/*"})
public class CalculatorController extends HttpServlet implements IController {
    


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
        
        proceedView(response, operation);
     

    }

       
    
    public Operation proceedParametersExtraction(HttpServletRequest request){
         
        Operation operationToEvaluate = createOperationFromHttpRequest(request);    
        return operationToEvaluate;
          
    }
    
   
    
    
    public void proceedOperation(Operation operationToEvaluate) {
            

        ICalculator calculatorRequested = 
                new CalculatorFactory().createCalculator(operationToEvaluate);
                
        calculatorRequested.calculate(operationToEvaluate);
        
    }
     
  
    
      public void proceedView(HttpServletResponse response, Operation ViewDataOperation) 
            throws IOException{
        
           
        Operator operator= ViewDataOperation.getOperator();
        Integer operande1= ViewDataOperation.getOperande1();
        Integer operande2= ViewDataOperation.getOperande2();
        double result = ViewDataOperation.getResult();
        
               
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
     * Create the operation from the URL HTTP Request
     * @param request
     * @return The operation to evaluate
     * @throws NumberFormatException : Their is a problem with de conversion
     */
    private  Operation createOperationFromHttpRequest(HttpServletRequest request) {
        
        String operator= request.getParameter(IController.URL_PARAM_OPERATOR);
        String operande1= request.getParameter(IController.URL_PARAM_OPERANDE_1);
        String operande2= request.getParameter(IController.URL_PARAM_OPERANDE_2);    

        
        Operation operationToCalculate 
                = checkAndConvertOperandesToInteger(operande1, operande2);
        
        operationToCalculate.setOperator(Operator.valueOfLabel(operator));
        
        return operationToCalculate;
    
    }

   

}
