 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.metier.calculatrice.patterns.factory.caclators;

import fr.devavance.calculatrice.beans.Operation;
import fr.devavance.metier.calculatrice.patterns.factory.interfaces.ICalculator;

/**
 *
 * @author blemaire
 */
public class AddCalculator implements ICalculator {

    @Override
    public void calculate(Operation operationToEvaluate) {
           operationToEvaluate.setResult(Double.valueOf(operationToEvaluate.getOperande1()
                   + operationToEvaluate.getOperande2()));
    } 
}
