# TP2 - Ecriture d'une servlet



## Objectifs

L'objectif de cet exercice est de développer une calculatrice permettant à l'utilisateur de saisir deux opérandes (entiers) et d e sélectionne r l'opération à effectuer parmi l'addition, la multiplication, la division et la soustraction.


## Travail à faire

### Question 1 : étape 1 - Développement du back-end

1. Développement de la classe `Calculator`
Développer la `classe fr.devavance.Calculator` avec 4 méthodes statiques
	* addition : `public static double add(String s_operande_1, String s_operande_2) throws NumberFormatException`
	* soustraction 
	* divition 
	* multiplication
	

2. Développement de la servlet `CalculatorController`
Développer la servlet `classe fr.devavance.calculatrice.controller.CalculatorController` permettant de répondre aux requêtes HTTP de type GET sous la forme :

`http://localhost:port/nom_projet/calculate?operation=xx&operande1=yy&operande2=zz`

où
* `nom_projet` est le nom du projet
* `localhost` est la machine où se trouve le serveur tomcat
* `port` : est le port sur lequel le serveur tomcat reçoit les requêtes HTTP (port d'écoute)
* `xx` : type d'opération parmi `+` (addition), `-` (soustraction), `/` (division)  ou `*` multiplication
* `yy` : valeur de l'opérande 1 pour l'opértation
* `zz` : valeur de l'opérande 2 pour l'opération


La servlet renverra au navigateur une page valide contenant 4 paragraphes :
 * **premier paragraphe** : valeur de l'opérande 1
 * **deuxième paragraphe** : valeur de l'opérande 2
 * **troisième paragraphe** : opération demandée
 * **quatrième paragraphe** : résultat


En cas d'erreurs une exception de type `ServletException` sera levée.


**Note 1** : Les paramètres dans l'URL sont récupérables avec en utilisant la méthode d'instance getParameter sur l'argument request (`HttpServletRequest`)

**Note 2** : Une instance de `ServletException` est capable d'encapsuler l'exception à l'origine de l'erreur (`rootCause`). Lire la javadoc.


**Exemple :**

URL : 
```
http://localhost:port/nom_projet/voiture?marque=fiat
```

Recupération de du paramètre marque dans le code de la servlet :

```
String marqueVoiture=request.getParameter("marque");
```


Testez votre application notamment pour évaluer le comportement de l'application lorsque les paramètres et/ou le nombre de paramètres n'est pas correct.


### Question 2 : étape 2 Création du front-end

Créer un autre projet  contenant un formulaire permettant de saisir les informations concernant l'opération à effectuer et faisant réaliser l'opération par la servlet (back-end).


**Avant de commencer, dessinez l'infrastructure de l'application Web.**


### Question 2 :


Capture des exceptions et les pages d'erreurs



Faire throw new ServletException en première instruction de doGet

Etude de la classe `CalculatorExceptionHandler`

Parser l'URL 