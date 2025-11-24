/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.calculatrice.beans;

/**
 *
 * @author BL
 */
public class Operation {
    private String operande1;
    private String operande2;
    private String operateur;
    private String resultat;

    public Operation(String operande1, String operande2, String operateur, String resultat) {
        this.operande1 = operande1;
        this.operande2 = operande2;
        this.operateur = operateur;
        this.resultat = resultat;
    }

    
    public String getOperande1() {
        return operande1;
    }

    public String getOperande2() {
        return operande2;
    }

    public String getOperateur() {
        return operateur;
    }

    public String getResultat() {
        return resultat;
    }

    
    public void setOperande1(String operande1) {
        this.operande1 = operande1;
    }

    public void setOperande2(String operande2) {
        this.operande2 = operande2;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "Operation{" + "operande1=" + operande1 + ", operande2=" + operande2 + ", operateur=" + operateur + ", resultat=" + resultat + '}';
    }
    
    
 
    
}
