<%-- 
    Document   : index
    Created on : 14 août 2023, 15:26:47
    Author     : BL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<jsp:useBean id="operation" beanName="operation" scope="request" 
             type="fr.devavance.calculatrice.beans.Operation"/>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculatrice</title>
    </head>
    <body>
        <div>   
            <p>opérande 1 :  <%=operation.getOperande1()%></p>
            <p>opérande 2 :  <%=operation.getOperande2()%></p>
            <p>opérateur  :  <%=operation.getOperateur()%></p> 
            <h1>résultat :   <%=operation.getResultat() %></h1>
            
            <!--
            <p>opérande 1 : ${operation.operande1}</p>
            <p>opérande 2 : ${operation.operande2}</p>
            <p>opérateur  : ${operation.operateur}</p> 
            <h1>résultat : ${operation.resultat}</h1>
            -->
    
        </div>
    </body>
</html>
