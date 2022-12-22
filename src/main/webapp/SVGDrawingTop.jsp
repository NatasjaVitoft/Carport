<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

        <form action="svgtop" method="post">
            <input type="submit" value="Se skiste">
        </form>



        ${requestScope.svg}


        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <input class="btn btn-dark btn-lg border-0 rounded-0"
               type="button" value="Tilbage" onclick="history.back(-1)"/>

    </jsp:body>

</t:pagetemplate>