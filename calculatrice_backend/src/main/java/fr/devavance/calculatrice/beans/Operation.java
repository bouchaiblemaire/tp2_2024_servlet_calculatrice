/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.calculatrice.beans;

import java.util.Objects;

/**
 *
 * @author blemaire
 */
public class Operation {
    private String operator;
    private Integer operande1;
    private Integer operande2;

    
    public Operation( Integer operande1, Integer operande2) {
        this.operande1 = operande1;
        this.operande2 = operande2;
    }
        
    public Operation(String operator, Integer operande1, Integer operande2) {
        this.operator = operator;
        this.operande1 = operande1;
        this.operande2 = operande2;
    }
    private Double result;

    public Operation() {
    }

    
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getOperande1() {
        return operande1;
    }

    public void setOperande1(Integer operande1) {
        this.operande1 = operande1;
    }

    public Integer getOperande2() {
        return operande2;
    }

    public void setOperande2(Integer operande2) {
        this.operande2 = operande2;
    }
    
    
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.operator);
        hash = 31 * hash + Objects.hashCode(this.operande1);
        hash = 31 * hash + Objects.hashCode(this.operande2);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Operation other = (Operation) obj;
        if (!Objects.equals(this.operator, other.operator)) {
            return false;
        }
        if (!Objects.equals(this.operande1, other.operande1)) {
            return false;
        }
        return Objects.equals(this.operande2, other.operande2);
    }



  
    
    
    
    
}
