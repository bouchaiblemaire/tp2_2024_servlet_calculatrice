package fr.devavance.controler.exceptions;

import fr.devavance.controler.exceptions.OperatorException;
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
 
    
    public static final String  ORIGIN_OF_EXCEPTION = 
            "javax.servlet.error.exception";
    
    public static final String STANDARD_MESSAGE = "Une erreur est survenue.";

    public static final String CONVERSION_MESSAGE_ERROR=
            "Erreur de conversion : format numérique incorrect."
            + "\nou\nErreur de paramètres : nombre de paramètres incorrect.";
    
    public static final String ARITHMETIC_ERROR_MESSAGE
            = "Erreur arithmétique : division par zéro ou opération invalide";
    
    public static final String OPERATOR_MESSAGE_ERROR = "Erreur d'opérateur : "
            + "opérateur non reconnu ou invalide.";;
    
    public static final String INTERNAL_ERROR = "Erreur interne : ";
    
    

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
    

    
    public void processError(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String ErrorMessage = processMessageFromRootOfException(request);

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
        out.println("<p>" + ErrorMessage + "</p>");
        out.println("<p><a href='/calculatrice_etape_1'>Retour à l'accueil</a></p>");
        out.println("</div>");
        out.println("</body></html>");
    }
    
    
    /**
     * Process un message build from the root of the erroe
     * @param resquest : Request who is root of the exception
     * @return message's explaning the root of the exception
     */
    private String processMessageFromRootOfException(HttpServletRequest request){
        
        // Récupération de l'exception
        Throwable throwable = 
            (Throwable) request.getAttribute(ErrorHandler.ORIGIN_OF_EXCEPTION);
        
        
    
        if (throwable != null) {
            
            Class exceptionClass = throwable.getClass();
            
            if (exceptionClass ==  ArithmeticException.class)
                return ErrorHandler.ARITHMETIC_ERROR_MESSAGE;
            if (exceptionClass == NumberFormatException.class)
                return ErrorHandler.CONVERSION_MESSAGE_ERROR;
            if (exceptionClass == OperatorException.class)
                return ErrorHandler.OPERATOR_MESSAGE_ERROR;
            
            
        }
        return ErrorHandler.INTERNAL_ERROR + throwable.getMessage();

    }
        
}

