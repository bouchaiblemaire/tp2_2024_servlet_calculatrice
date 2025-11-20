/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.metier.calculatrice.patterns.factory.caclators.factory;

import fr.devavance.calculatrice.beans.Operation;
import fr.devavance.calculatrice.exceptions.OperatorException;
import fr.devavance.metier.calculatrice.Operator;
import fr.devavance.metier.calculatrice.patterns.factory.caclators.AddCalculator;
import fr.devavance.metier.calculatrice.patterns.factory.caclators.DivCalculator;
import fr.devavance.metier.calculatrice.patterns.factory.caclators.MulCalculator;
import fr.devavance.metier.calculatrice.patterns.factory.caclators.SubCalculator;
import fr.devavance.metier.calculatrice.patterns.factory.interfaces.ICalculator;
import fr.devavance.metier.calculatrice.patterns.factory.interfaces.ICalculatorFactory;
import java.util.HashSet;

/**
 *
 * @author blemaire
 * @version 2025
 * 
 * Pattern factory for the Calculator
 */
public class CalculatorFactory implements ICalculatorFactory {
    
  private HashSet<String> permittedOperators = null;

    public CalculatorFactory() {
         this.permittedOperators = new HashSet<String>();

    for (Operator operator : Operator.values()) {
      permittedOperators.add(operator.toString());
    }
  }

        
     
    @Override
    public ICalculator createCalculator(Operation operationToEvaluate) {
        
      Operator operatorToApplyForCalculation = operationToEvaluate.getOperator();
      
      checkOperatorValidity(operatorToApplyForCalculation);
               
        
      if ( operatorToApplyForCalculation.name().equals(Operator.ADD.toString()))
        return new AddCalculator();
      
      if ( operatorToApplyForCalculation.name().equals(Operator.SUB.toString()))
        return new SubCalculator();
      
      if ( operatorToApplyForCalculation.name().equals(Operator.MUL.toString()))
        return new MulCalculator();
      

    return new DivCalculator();       
        
   }
    
    
    
    

    /**
     * Check the validity of the operator
     * @param operator : Operator for the calculatation
     * @throws OperatorException : The operator is not permitted
     */
    private  void checkOperatorValidity(Operator operator) 
            throws OperatorException {
   
      if (operator==null || ! this.permittedOperators.contains(operator.toString()) )
        
            throw new OperatorException();
    }
    
    
}
