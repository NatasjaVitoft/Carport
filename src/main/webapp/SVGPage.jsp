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


        <section class="container">
            <div class="row content d-flex justify-content-center align-items-center">
                <div class="col-md-5">
                    <div class="box shadow bg-white p-4">
                        <h3 class="mb-4 text-center fs-1" style="text-transform: none; font-family: 'Times New Roman',serif">Din valgte caport</h3>

                        <br>

                        <h3 style="font-family: 'Times New Roman',Serif; text-transform: none">Bredde: ${sessionScope.width}</h3>
                        <h3 style="text-transform: none; font-family: 'Times New Roman',serif">Længde: ${sessionScope.length}</h3>
                        <br>

                        <h3 style="text-transform: none; font-family: 'Times New Roman', serif">Pris i alt:</h3>
                        <h3 style="text-transform: none; font-family: 'Times New Roman',serif">${sessionScope.totalprice} dkk</h3>
                        <br>
                        <br>
                        <br>
                        <br>
                        <h3 style="text-transform: none; font-family: 'Times New Roman',serif">Skitse af carporten:</h3>
                        <br>
                        <form action="SVGBeforePurchase" method="post">
                            <input class="button btn-dark btn-lg border-0 rounded-0" type="submit" value="Se tegning" style="font-family: 'Times New Roman',serif; text-transform: none">
                        </form>
                        <br>
                        <br>

                        <form action="addorder" method="post">
                            <div class="d-grid gap-2 mb-3">
                                <input class="btn btn-dark btn-lg border-0 rounded-0"
                                       type="submit" value="Køb Carport" style="text-transform: none; font-family: 'Times New Roman',serif"/>

                                <input class="btn btn-dark btn-lg border-0 rounded-0"
                                       type="button" value="Tilbage" style="font-family: 'Times New Roman',serif; text-transform: none" onclick="history.back(-1)"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

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
