/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.calculatrice;

/**
 *
 * @author marmotton
 */
public class Calculator {
    
    /**
     * Addition
     * @param s_operande_1 : première opérande
     * @param s_operande_2 : seconde opérande
     * @return somme des deux opérances
     * @throws NumberFormatException 
     */
    public static double addition(String s_operande_1, String s_operande_2) throws NumberFormatException {
        int operande_1 = Integer.parseInt(s_operande_1);        
        int operande_2 = Integer.parseInt(s_operande_2);

        return operande_1 + operande_2;
       
    }
	
    /**
     * Soustraction
     * @param s_operande_1 : première opérande
     * @param s_operande_2 : seconde opérande
     * @return somme des deux opérances
     * @throws NumberFormatException 
     */
    public static double soustraction(String s_operande_1, String s_operande_2) throws NumberFormatException {
        int operande_1 = Integer.parseInt(s_operande_1);        
        int operande_2 = Integer.parseInt(s_operande_2);

        return operande_1 - operande_2;
       
    }
    
     /**
     * Division
     * @param s_operande_1 : première opérande
     * @param s_operande_2 : seconde opérande
     * @return somme des deux opérances
     * @throws NumberFormatException 
     */
    public static double division(String s_operande_1, String s_operande_2) throws NumberFormatException, ArithmeticException {
        int operande_1 = Integer.parseInt(s_operande_1);        
        int operande_2 = Integer.parseInt(s_operande_2);

        return operande_1 / operande_2;
       
    }
    
     /**
     * Multiplication
     * @param s_operande_1 : première opérande
     * @param s_operande_2 : seconde opérande
     * @return somme des deux opérances
     * @throws NumberFormatException 
     */
    public static double multiplication(String s_operande_1, String s_operande_2) throws NumberFormatException {
        int operande_1 = Integer.parseInt(s_operande_1);        
        int operande_2 = Integer.parseInt(s_operande_2);

        return operande_1 * operande_2;
       
    }
    
}
