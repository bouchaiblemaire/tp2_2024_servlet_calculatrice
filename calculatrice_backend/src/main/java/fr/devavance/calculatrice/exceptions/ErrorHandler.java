package fr.devavance.calculatrice;

import fr.devavance.calculatrice.exceptions.OperatorException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet mappée comme page d'erreur
@WebServlet("/error-handler")
public class ErrorHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processError(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processError(request, response);
    }

    private void processError(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Récupération de l'exception
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String message = "Une erreur est survenue.";

    
        if (throwable != null) {
            
            Class exceptionClass = throwable.getClass();
            
            if (exceptionClass ==  ArithmeticException.class) {
                message = "Erreur arithmétique : division par zéro ou opération invalide.";
            } else if (exceptionClass == NumberFormatException.class) {
                message = "Erreur de conversion : format numérique incorrect.\nou\nErreur de paramètres : nombre de paramètres incorrect.";
            } else if (exceptionClass == OperatorException.class) {
                message = "Erreur d'opérateur : opérateur non reconnu ou invalide.";
            } else {
                message = "Erreur interne : " + throwable.getMessage();
            }
        }

        // Réponse HTML avec boîte de dialogue stylisée
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>Erreur</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f9f9f9; }");
        out.println(".dialog { max-width: 500px; margin: 100px auto; padding: 20px;");
        out.println(" background: #fff; border: 2px solid #e74c3c; border-radius: 10px;");
        out.println(" box-shadow: 0 0 10px rgba(0,0,0,0.2); }");
        out.println(".dialog h2 { color: #e74c3c; margin-top: 0; }");
        out.println(".dialog p { font-size: 1.1em; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<div class='dialog'>");
        out.println("<h2>⚠️ Erreur détectée</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<p><a href='/calculatrice_etape_1'>Retour à l'accueil</a></p>");
        out.println("</div>");
        out.println("</body></html>");
    }
}

