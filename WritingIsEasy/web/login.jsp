<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>WritingIsEasy - Login</title>
        <meta charset="UTF-8">        
        <meta name="author" content="Sara Casti">
        <meta name="keywords" content="html, css, fpw, writingiseasy">
        <meta name="description" content="Esempio form login"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="external/myStyle.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div>
            <h3>Login</h3>
            <form action="login.html" method="post">
                <label for="user"> Username: ${userJsp} </label>
                <input type="text" name="user" id="user" value="${userJsp}">
                <br>
                <label for="psw"> Password: ${passJsp} </label>
                <input type="password" name="psw" id="psw">
                <br>
                <label for="profileImg"> Your Profile Image: ${urlJsp} </label>
                <input type="url" name="profileImg" id="profileImg">
                <br>
                <!-- Radio button -->
                <label for="M">M </label>
                <input type="radio" id="M" name="sex">
                <label for="F">F</label>
                <input type="radio" id="F" name="sex">
                <br>
                <!-- Inserimento di una descrizione -->
                <label>Inserisci una descrizione qui: </label>
                <br>
                <textarea>..Insert your text here..s</textarea>
                <br>
                <h4>Scegli la categoria del tuo libro</h4>
                <!-- Scelta multipla bassa-cardinalitÃ -->
                <label for="sport">Sport:</label>
                <input type="checkbox" name="category" id="sport" value="sport">
                <br>
                <!--<label>Science:</label> -->
                <input type="checkbox" name="category" id="science" value="science">  Science
                <br>
                <label for="romanzo">Romanzo:</label>
                <input type="checkbox" name="category" id="romanzo" value="romanzo">
                <br>
                <input type="submit" value="Invia">
                    
            </form>
        </div>
    </body>
</html>
