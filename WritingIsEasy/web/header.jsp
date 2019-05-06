<%-- 
    Document   : header
    Created on : 15-apr-2019, 13.06.42
    Author     : Sary
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="myHeader">
    <header>
        <div id="logo_img">
            <a href="../index.html">
            <img title="Logo" src="images/logo.jpg" alt="logo sito WritingIsEasy" width="150"></a>
            <p id="header">Everyone can write his book!</p>
        </div>
        <div id="banner"><h1 id="logo">WritingIsEasy</h1></div>
    </header>


    <h3>Homepage del nostro sito!...</h3>
    <nav>            
        <ul>
            <li class="current_page_item">Home page</li>
            <li class="page_item"><a href="libri.html">I miei libri</a></li>
            <li class="page_item"><a href="http://www.google.it" target="_blank">Cerca su google</a></li>
            <li class="page_item">
                <c:if test="${user==null}">
                    <a href="login.html">
                        Login 
                    </a>
                </c:if>
                <c:if test="${user!=null}">
                    <a href="logout.html">
                        ${user.getUsername()}, Logout 
                    </a>
                </c:if>
            </li>
            <li class="page_item"><a href="#gossip">Gossip</a></li>
        </ul>
    </nav>
</div>
