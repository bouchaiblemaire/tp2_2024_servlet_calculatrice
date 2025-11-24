<%-- 
    Document   : index
    Created on : 14 août 2023, 15:26:47
    Author     : BL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculatrice</title>
    </head>
    <body>
        <div>
            <!--
        <h1>Calculatrice version 1</h1>
        <code>http://ip_serveur/calculatrice/calculate/operation/operande_1/operande_2</code>
            -->
            
               <form action="/calculatrice/calculate"  method="get">
           <p>Opérande 1 : <input type="text" name="operande1" /></p>
           <p>Opérande 2 : <input type="text" name="operande2" /></p>
           <p>Opérateur : <input type="text" name="operateur" /></p>
           <p><input type="submit"  value="valider" /></p>
        </form>
        </div>
    </body>
</html>
