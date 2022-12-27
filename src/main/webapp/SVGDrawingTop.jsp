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

        <form action="svgafterpurchase" method="post">
            <input class="btn btn-secondary border-0 rounded-0" type="submit" value="Se tegning"/>
            <br>
            <br>
            <br>
        </form>



        ${requestScope.svg}

        </form>


        <br>
        <br>
        <br>
        <input class="btn btn-dark btn-lg border-0 rounded-0"
               type="button" value="Tilbage" onclick="history.back(-1)"/>

    </jsp:body>

</t:pagetemplate>