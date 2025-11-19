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
public class Multiplication implements IOperateurFactory {

    @Override
    public Double evaluate(Integer operande_1, Integer operande_2) {
 
        return Double.valueOf(operande_1 *  operande_2);
       
      }
    
}
