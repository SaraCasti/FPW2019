<%-- 
    Document   : articleJson
    Created on : 3-giu-2019, 13.46.35
    Author     : Sary
--%>
<%@page contentType="application/json" pageEncoding="UTF-8"%> 
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<json:array>
    <c:forEach var="usr" items="${usersList}">
        <json:object>
            <json:property name="username" value="${usr.getUsername()}"/>
        </json:object>
    </c:forEach>
</json:array>
