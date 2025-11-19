/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  fr.devavance.calculatrice.factory.operateur;

import fr.devavance.calculatrice.factory.operateur.interfaces.IOperateurFactory;


/**
 *
 * @author bouchaib.lemaire
 */
public class Division implements IOperateurFactory {

    @Override
    public Double evaluate(Integer operande_1, Integer operande_2) {
        
        if (operande_2==0) throw new ArithmeticException();
        
        return Double.valueOf(operande_1 / (float) operande_2);       
      }
    
}
