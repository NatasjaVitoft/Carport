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


        <div class="container">
            <div class="row justify-content-center align-items-center text-center">
                <h2>Hvilken carport ønkser du?</h2>
                <br>
                <div class="col-md-3 text-center">
                    <a href="bestilFladtTag.jsp"><img src="images/carport1.jpg" alt="HTML tutorial"
                                                      style="width:250px;height:200px;"></a>
                    <br>
                    <br>
                    <p>Carport med fladt tag</p>
                </div>
                <div class="col-md-3 text-center">
                    <a href="bestilTagMedRejsning.jsp"><img src="images/carport2.jpg" alt="HTML tutorial"
                                                      style="width:250px;height:200px;"></a>
                    <br>
                    <br>
                    <p>Carport med tag af høj rejsning</p>
                </div>
            </div>
        </div>
        <br>


    </jsp:body>
</t:pagetemplate>