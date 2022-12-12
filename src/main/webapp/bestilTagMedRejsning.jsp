
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

        <h1> Carport med høj rejsning </h1>

        <form action="bestil" method="post">
            <label for="width">Vælg bredde</label>
            <select name="width" id="width">
                <option value="600">600</option>
                <option value="700">700</option>
                <option value="800">800</option>
                <option value="900">900</option>
            </select>

            <br>

            <label for="length">Vælg længde</label>
            <select name="length" id="length">
                <option value="600">600</option>
                <option value="780">780</option>
                <option value="700">700</option>
                <option value="800">800</option>
                <option value="900">900</option>
                <option value="1000">1000</option>
                <option value="1100">1100</option>
                <option value="1200">1200</option>
                <option value="1300">1300</option>
            </select>

            <br>

            <input class="btn btn-dark btn-lg border-0 rounded-0"
                   type="submit" value="bestil"/>
        </form>


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

    </jsp:body>
</t:pagetemplate>