/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.devavance.metier.calculatrice.patterns.factory.interfaces;

import fr.devavance.calculatrice.beans.Operation;


/**
 *
 * @author blemaire
 * @version 2025
 * 
 * Pattern factory for the Calculator
 * 
 * Calculator Factory interface
 */
public interface ICalculatorFactory {
      
    /**
     * Create an instance of an Calculator following the Operator request
     * @param operator : operator resquest
     * @return An instance of concrete Calculator
     */
    public ICalculator createCalculator(Operation operationToEvaluate);
    
}
