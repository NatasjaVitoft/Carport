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

        <section class="container">
            <div class="row content d-flex justify-content-center align-items-center">
                <div class="col-md-5">
                    <div class="box shadow bg-white p-4">
                        <h3 class="mb-4 text-center fs-1">Opret bruger</h3>

                        <form class="mb-3" action="Opret" method="post">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control rounded-0" id="username"
                                       name="username" placeholder="username" required>
                                <label for="username">Username </label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="password" class="form-control rounded-0" id="password"
                                       name="password" placeholder="Password" required>
                                <label for="password">Password </label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="role" class="form-control rounded-0" id="role"
                                       name="role" placeholder="Role" required>
                                <label for="role">role </label>
                            </div>
                            <div class="form-floating mb-3">
                                <h5>Indtast adresse & kontakt oplysninger</h5>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="email" class="form-control rounded-0" id="email"
                                       name="email" placeholder="email" required>
                                <label for="email">Email </label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control rounded-0" id="adresse"
                                       name="adresse" placeholder="adresse" required>
                                <label for="adresse">Adresse </label>
                            </div>
                            <div class="col">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control rounded-0" id="by"
                                           name="by" placeholder="by" required>
                                    <label for="by">By </label>
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control rounded-0" id="postnummer"
                                           name="postnummer" placeholder="postnummer" required>
                                    <label for="postnummer">Postnummer </label>
                                </div>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control rounded-0" id="fuldenavn"
                                       name="fuldenavn" placeholder="fuldenavn" required>
                                <label for="fuldenavn">Fulde navn </label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control rounded-0" id="telefon"
                                       name="telefon" placeholder="telefon" required>
                                <label for="telefon">Telefon </label>
                            </div>
                            <div class="d-grid gap-2 mb-3">
                                <input class="btn btn-dark btn-lg border-0 rounded-0"
                                       type="submit" value="Opret bruger"/>
                            </div>
                            <div class="forgot-password-link mb-3">
                                <div class="text-right">
                                    <a href="login.jsp" title="Already a user" class="text-decoration-none">Already a
                                        user?</a>
                                </div>
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
        <br>
        <br>
        <br>
        <br>

    </jsp:body>
</t:pagetemplate>