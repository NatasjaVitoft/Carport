
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


        <section class="container">
            <div class="row content d-flex justify-content-center align-items-center">
                <div class="col-md-5">
                    <div class="box shadow bg-white p-4">
                        <h3 class="mb-4 text-center fs-1">Customize Carport med høj rejsning af tag</h3>

                        <form class="mb-3" action="bestil" method="post">
                            <div class="mb-3">
                                <p>Vælg bredde</p>
                                <select class="form-control rounded-0" name="width" id="width">
                                    <option value="600">600</option>
                                    <option value="650">650</option>
                                    <option value="700">700</option>
                                    <option value="750">750</option>
                                    <option value="800">800</option>
                                    <option value="850">850</option>
                                    <option value="900">900</option>
                                    <option value="950">950</option>
                                    <option value="1000">1000</option>
                                    <option value="1050">1050</option>
                                    <option value="1100">1100</option>
                                    <option value="1150">1150</option>
                                    <option value="1200">1200</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <p>Vælg længde</p>
                                <select class="form-control rounded-0" name="length" id="length">
                                    <option value="600">600</option>
                                    <option value="650">650</option>
                                    <option value="700">700</option>
                                    <option value="750">750</option>
                                    <option value="800">800</option>
                                    <option value="850">850</option>
                                    <option value="900">900</option>
                                    <option value="950">950</option>
                                    <option value="1000">1000</option>
                                    <option value="1050">1050</option>
                                    <option value="1100">1100</option>
                                    <option value="1150">1150</option>
                                    <option value="1200">1200</option>
                                </select>
                            </div>
                            <div class="d-grid gap-2 mb-3">
                                <input class="btn btn-dark btn-lg border-0 rounded-0"
                                       type="submit" value="Se Tilbud"/>
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

    </jsp:body>
</t:pagetemplate>