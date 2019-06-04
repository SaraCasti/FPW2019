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
        <title>WritingIsEasy</title>
        <meta charset="UTF-8">
        <meta name="author" content="Sara Casti">
        <meta name="keywords" content="html, css, fpw, writingiseasy">
        <meta name="description" content="Progetto FPW 2019">
        <link rel="stylesheet" type="text/css" href="external/myStyle.css" media="screen">
        <script type="text/javascript" src="external/jquery-lib.js"></script>
        <script type="text/javascript" src="external/searchScript.js"></script>
        <!--<base href="images/"> -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div id="side-bar">
            <label for="search">Cerca qui: </label>
            <input id="search" type="text">
            <h4>I Libri più letti</h4>
            <ol>
                <li>Il signore degli anelli..</li>
                <li>The vampire diares..</li>
                <li>Me and you..</li>
            </ol>
        </div>
        <div id="main-content">
            <h2>
                <c:if test="${user != null}">
                    Benvenuto ${user.getUsername()}!
                </c:if>
            </h2>
            <c:forEach var="book" items="${allBooks}">
                <div>
                    <h3>${book.getNome()}</h3>
                </div>
            </c:forEach>
           
            <div id="content">

                <p>
                     Her old collecting she considered discovered. So at parties he warrant oh staying. Square new horses and put better end. Sincerity collected happiness do is contented. Sigh ever way now many. Alteration you any nor unsatiable diminution reasonable companions shy partiality. Leaf by left deal mile oh if easy. Added woman first get led joy not early jokes. 

                    Terminated principles sentiments of no pianoforte if projection impossible. Horses pulled nature favour number yet highly his has old. Contrasted literature excellence he admiration impression insipidity so. Scale ought who terms after own quick since. Servants margaret husbands to screened in throwing. Imprudence oh an collecting partiality. Admiration gay difficulty unaffected how. 

                    How promotion excellent curiosity yet attempted happiness. Gay prosperous impression had conviction. For every delay death ask style. Me mean able my by in they. Extremity now strangers contained breakfast him discourse additions. Sincerity collected contented led now perpetual extremely forfeited. 

                    His having within saw become ask passed misery giving. 
                </p>
            </div>    
        </div>
        
        <footer id="footer">Sito sviluppato da Sara Casti - Corso di <strong>FPW</strong></footer>
    </body>
</html>
