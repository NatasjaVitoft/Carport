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




        <form action="addorder" method="post">
        <section class="container">
            <div class="row content d-flex justify-content-center align-items-center">
                <div class="col-md-5">
                    <div class="box shadow bg-white p-4">
                        <h3 class="mb-4 text-center fs-1">Din valgte caport</h3>

                        <br>

                        <h3>Din valgte Bredde: ${sessionScope.width}</h3>
                        <h3>Din valgte Længde: ${sessionScope.length}</h3>
                        <br>

                        <h2>Pris i alt:</h2>
                        <h3>${sessionScope.totalPrice} .- dkk</h3>
                        <br>
                        <h3>Carporten set oppefra:</h3>
                        <button class="btn btn-dark btn-lg border-0 rounded-0" type="button" data-toggle="collapse"
                                data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                            Se tegning
                        </button>
                        <div class="collapse" id="collapseExample">
                            <div class="card card-body">
                                    ${requestScope.generateSvgTop}
                            </div>
                        </div>

                        <br>
                        <br>
                        <br>
                        <br>

                        <h3>Carporten set fra siden:</h3>
                        <button class="btn btn-dark btn-lg border-0 rounded-0" type="button" data-toggle="collapse"
                                data-target="#collapseExampleTwo"
                                aria-expanded="false" aria-controls="collapseExampleTwo">
                            Se tegning
                        </button>
                        <div class="collapse" id="collapseExampleTwo">
                            <br>

                                ${requestScope.sideDrawing}
                        </div>
                        <br>
                        <br>
                        <br>
                        <br>

                        <div class="d-grid gap-2 mb-3">
                            <input class="btn btn-dark btn-lg border-0 rounded-0"
                                   type="submit" value="Køb Carport"/>
                            <input class="btn btn-dark btn-lg border-0 rounded-0"
                                   type="submit" value="Tilbage"/>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        </form>
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
