/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.devavance.metier;

/**
 *
 * @author blemaire
 */
public enum Operator {    
    ADD("add"),
    SUB("sub"),
    MUL("mul"),
    DIV("div");
    
    private  String label;
    
    Operator(String operator){
        this.label = operator;
    }
   
    
    
    public static Operator valueOfLabel(String label) {
      for (Operator op : values()) {
        if (op.label.equals(label)) {
            return op;
        }
      }
    return null;
  }

    @Override
    public String toString() {
        return this.label;
    }
    
    
    
}
