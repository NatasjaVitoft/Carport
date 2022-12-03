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
        <div class="d-flex justify-content-center">
                <img src="${pageContext.request.contextPath}/images/2022-engerikatalog-vejleder-prio.jpg" width="1620px;"
                     class="img-fluid"/>
            </div>

        <br>

        <h4>Se vores produkt side på carporte</h4>

        <br>

        <div class="d-flex justify-content-start">
            <img src="${pageContext.request.contextPath}/images/fog-dobbelt-carport-car01du-large.jpeg" width="720px;"
                 class="img-fluid"/>
        </div>


        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>