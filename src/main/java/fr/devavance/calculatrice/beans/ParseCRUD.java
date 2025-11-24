/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.calculatrice.beans;

import fr.devavance.calculatrice.exception.CalculatorException;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author marmotton
 */
public class ParseCRUD {
    
    
    
    
    public static HashMap<String, String> parsePathInfo(HttpServletRequest request) throws CalculatorException {
       
        //throw new CalculatorException();  
        
         StringTokenizer st = new StringTokenizer(request.getPathInfo(), "/");
   
         
         HashMap<String, String> crud = new HashMap<String, String>();
         
         
         if (st.countTokens()!=3) throw new CalculatorException("Erreur opérande");
         
         crud.put("operator", st.nextToken());
         crud.put("operande_1", st.nextToken());
         crud.put("operande_2", st.nextToken());
         
         return crud;
         
         
          
    }
    
}
