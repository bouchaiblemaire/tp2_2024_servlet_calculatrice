/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.devavance.controler.factory.interfaces;

import fr.devavance.metier.Operation;
import fr.devavance.controler.interfaces.ICalculator;


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
