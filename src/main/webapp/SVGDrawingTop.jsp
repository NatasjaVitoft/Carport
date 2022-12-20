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

        <!---<section class="container">
            <div class="row content d-flex justify-content-center align-items-center">
                <div class="col-md-7">
                    <div class="box shadow bg-white p-4">
                        <h3 class="mb-4 text-center fs-1">Skitse af carport med fladt tag</h3>

                        <br>
                        <div class="d-flex justify-content-center"> --->
                                ${requestScope.svg}
        <!--- </div>
                        <br>
                        <br>
                        <br>
                        <br>
                        <div class="d-flex justify-content-center">--->
        <br>
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
        <!--- </div>
                    </div>
                </div>
            </div>
        </section> --->

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

    </jsp:body>

</t:pagetemplate>