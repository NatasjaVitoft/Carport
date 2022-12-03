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


        <section class="container">
            <div class="row content d-flex justify-content-center align-items-center">
                <div class="col-md-5">
                    <div class="box shadow bg-white p-4">
                        <h3 class="mb-4 text-center fs-1">Login Form</h3>

                        <form class="mb-3" action="login" method="post">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control rounded-0" id="username"
                                       name="username" placeholder="username" required>
                                <label for="username">Username </label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="password" class="form-control rounded-0" id="password"
                                       name="Password" placeholder="Password" required>
                                <label for="password">Password </label>
                            </div>
                            <div class="form-check mb-3">
                                <input class="form-check-input" type="checkbox" id="autoSizingCheck2">
                                <label class="form-check-label">Remember me</label>
                            </div>
                            <div class="d-grid gap-2 mb-3">
                                <input class="btn btn-dark btn-lg border-0 rounded-0"
                                       type="submit" value="Login"/>
                            </div>
                            <div class="forgot-password-link mb-3">
                                <div class="text-right">
                                    <a href="#" title="Forgot Password" class="text-decoration-none">Forgot
                                        Password?</a>
                                </div>
                                <div class="text-right">
                                    <a href="#" title="Not a user" class="text-decoration-none">SignUp</a>
                                </div>
                            </div>
                        </form>
                        <div class="sign-up-accounts">
                            <p class="text-center">Or Sign Up With</p>
                            <div class="social-accounts d-flex justify-content-center">
                                <a href="#" title="Facebook"><i class="fa fa-facebook"></i></a>
                                <a href="#" title="Twitter"><i class="fa fa-twitter"></i></a>
                                <a href="#" title="Google"><i class="fa fa-google"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <br>

    </jsp:body>
</t:pagetemplate>