/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.calculatrice.beans;

/**
 *
 * @author marmotton
 */
public class Calculator {
    
    /**
     * 
     * @param s_operande_1 : première opérande
     * @param s_operande_2 : seconde opérande
     * @return somme des deux opérances
     * @throws NumberFormatException 
     */
    public static double add(String s_operande_1, String s_operande_2) throws NumberFormatException {
        int operande_1 = Integer.parseInt(s_operande_1);        
        int operande_2 = Integer.parseInt(s_operande_2);

        return operande_1 + operande_2;
       
    }
	

    
}
