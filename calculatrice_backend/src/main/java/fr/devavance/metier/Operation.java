/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.metier;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author blemaire
 */
public class Operation implements Serializable {
    private Operator operator;
    private Integer operande1;
    private Integer operande2;
    private Double result;

    
    
    public Operation() {
    }

       
    public Operation( Integer operande1, Integer operande2) {
        this.operande1 = operande1;
        this.operande2 = operande2;
    }
        
    public Operation(Operator operator, Integer operande1, Integer operande2) {
        this.operator = operator;
        this.operande1 = operande1;
        this.operande2 = operande2;
    }

 
    
    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
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
