/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.devavance.calculatrice.controller.interfaces;

import fr.devavance.calculatrice.beans.Operation;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author blemaire
 */
public interface IController {
    
    public static final String URL_PARAM_OPERATOR = "operation";
    public static final String URL_PARAM_OPERANDE_1 = "operande1";
    public static final String URL_PARAM_OPERANDE_2 = "operande2";
    public static final String ADD_OPERATOR = "add";
    public static final String SUB_OPERATOR = "sub";
    public static final String MUL_OPERATOR = "mul";
    public static final String DIV_OPERATOR = "div";
    
    
    String [] permittedOperations = {ADD_OPERATOR, SUB_OPERATOR, MUL_OPERATOR, DIV_OPERATOR};
    
        /**
     * Extract, check and validate the parameters for the Operation to
     * calculate
     * @param request : HTTP request
     * @return operation : The operation to be calculate
     */
    public Operation proceedParametersExtraction(HttpServletRequest request);
    
    
    
    /**
     * Calculate the Operation
     * @param operation : Operation with the result
     * @throws InvalidOperation
     */
    public void proceedOperation(Operation operation);
    
    
    /**
     * Proceed the view to the client
     * @param response : HTTP response who transport the Operation result
     * @param operation : The operation with the result
     * @throws IOException 
     */
    public void proceedView(HttpServletResponse response, Operation operation) 
            throws IOException;
    
    
       
    
}
