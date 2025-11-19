/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.calculatrice.factory.CalculatriceFactory;

import fr.devavance.calculatrice.controller.interfaces.IController;
import fr.devavance.calculatrice.exceptions.InvalidOperation;
import fr.devavance.calculatrice.factory.operateur.Addition;
import fr.devavance.calculatrice.factory.operateur.interfaces.IOperateurFactory;

/**
 *
 * @author bouchaib.lemaire
 */
public class OperatorFactory {
    
    public IOperateurFactory createOperator(String operator){
                
        if (operator.equals(IController.ADD_OPERATOR))
            return new Addition();
        
        if (operator.equals(IController.SUB_OPERATOR))
            return new Addition();
          
        if (operator.equals(IController.DIV_OPERATOR))
            return new Addition();
            
        if (operator.equals(IController.MUL_OPERATOR))
            return new Addition();
                
        throw new InvalidOperation();
        
    }
    
}
