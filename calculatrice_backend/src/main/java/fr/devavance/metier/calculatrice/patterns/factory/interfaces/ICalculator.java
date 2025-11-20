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
 */
public interface ICalculator {    
    /**
     * Evaluate the Operation
     * @param operationToEvaluate 
     */
    public void calculate(Operation operationToEvaluate);
    
}
