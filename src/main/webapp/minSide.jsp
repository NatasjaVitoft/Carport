<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="true" %>

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
        <form action="addorder" method="get">
            <input type="submit" value="Se ordre"/>
        </form>
        <br>

        <div style="width: 555px">
            <c:forEach var="item" items="${sessionScope.orderlist}">
                ID: ${item.order_id} <br>
                Email: ${item.email} <br>
                Date: ${item.date} <br>
                Pris: ${item.price} kr <br>
                Username: ${item.username} <br>
                Carport: ${item.carportID}, ${item.length}, ${item.width}
            </c:forEach>
        </div>

    </jsp:body>
</t:pagetemplate>
