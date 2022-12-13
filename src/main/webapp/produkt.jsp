<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

        <form action="BestilCarport" method="post">
            <label for="flatroof">Vælg fladt tag:</label><br>
            <input type="flatroof" id="flatroof" name="flatroof"><br>
            <button type="submit">Videre</button>
        </form>

    </jsp:body>
</t:pagetemplate>