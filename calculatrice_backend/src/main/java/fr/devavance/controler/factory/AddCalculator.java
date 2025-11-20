 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.controler.factory;

import fr.devavance.metier.Operation;
import fr.devavance.controler.interfaces.ICalculator;


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
