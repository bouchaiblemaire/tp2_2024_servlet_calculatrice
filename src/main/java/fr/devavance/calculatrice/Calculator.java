package fr.devavance.calculatrice;

/**
 * @author BL
 * Calculatrice
 */
public class Calculator {
    

    public static double addition(String s_operande_1, String s_operande_2) 
            throws NumberFormatException {
        
        Operandes operandes = convertOperandesToDouble(
                                                    s_operande_1, 
                                                    s_operande_2 );

        return operandes.getOperande1() + operandes.getOperande2();
       
    }
	
    public static double soustraction(String s_operande_1, String s_operande_2) 
            throws NumberFormatException {

        Operandes operandes = convertOperandesToDouble(
                                                    s_operande_1, 
                                                    s_operande_2 );

              return operandes.operande1 - operandes.operande2;
       
    }
    
    public static double division(String s_operande_1, 
                                  String s_operande_2) 
                           throws NumberFormatException, ArithmeticException {
        
        Operandes operandes = convertOperandesToDouble(
                                                    s_operande_1, 
                                                    s_operande_2 );
        
        if (operandes.getOperande2() == 0) {
            throw new ArithmeticException("Division par zéro !");
        }

              return operandes.operande1 / (double) operandes.operande2;
       
    }
    

    public static double multiplication(String s_operande_1, 
                                        String s_operande_2) 
                                throws NumberFormatException {
        
        Operandes operandes = convertOperandesToDouble(
                                                    s_operande_1, 
                                                    s_operande_2 );
        
              return operandes.operande1 * operandes.operande2;
       
    }
    
    private static Operandes convertOperandesToDouble(
                                       String s_operande_1, 
                                       String s_operande_2) 
                                 throws NumberFormatException{
        
        Operandes operandes = new Operandes(
                              Integer.parseInt(s_operande_1), 
                              Integer.parseInt(s_operande_2) 
                                   );
        return operandes;
    }

    
    private static class Operandes {
        
        private int operande1;
        private int operande2;

        public Operandes(int operande1, int operande2) {
            this.operande1 = operande1;
            this.operande2 = operande2;
        }

        public int getOperande1() {
            return operande1;
        }

        public int getOperande2() {
            return operande2;
        }
        
    }
        
}
