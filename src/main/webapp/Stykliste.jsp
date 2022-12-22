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

        <form action="Bom" method="post">
            <input type="submit" value="Her kan du se din stykliste"/>
        </form>

        <br>
        <br>
        <br>

        <h3 style="font-family: 'Times New Roman',serif"> Træ & tagplader </h3>
        <br>
        <br>

        <div style="width: 1300px">
            <c:forEach var="item" items="${sessionScope.stykliste}">

                <table class="table table-light">
                    <thead>
                    <tr>
                        <th style="width: 35%">Beskrivelse</th>
                        <th style="width: 10%">Længde</th>
                        <th style="width: 10%">Antal</th>
                        <th style="width: 10%">Enhed</th>
                        <th style="width: 35%">Beskrivelse</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td style="text-align:  left">${item.name}</td>
                        <td style="text-align:  left">${item.length}</td>
                        <td style="text-align:  left">${item.quantity}</td>
                        <td style="text-align:  left">${item.unit}</td>
                        <td style="text-align: left">${item.description}</td>
                    </tr>
                    </tbody>
                </table>

            </c:forEach>
        </div>

        <br>
        <br>

        <h3 style="font-family: 'Times New Roman',serif"> Skruer & beslag </h3>
        <br>
        <br>


        <div style="width: 1300px">
            <c:forEach var="item" items="${sessionScope.styklistevariant}">

                <table class="table table-light">
                    <thead>
                    <tr>
                        <th scope="col" style="width: 35%"> Beskrivelse</th>
                        <th scope="col" style="width: 15%"> Antal</th>
                        <th scope="col" style="width: 15%">Enhed</th>
                        <th scope="col" style="width: 35%">Beskrivelse</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>

                        <td>${item.name}</td>
                        <td>${item.quantity}</td>
                        <td>${item.unit}</td>
                        <td>${item.description}</td>

                    </tr>
                    </tbody>
                </table>

            </c:forEach>
        </div>

    </jsp:body>
</t:pagetemplate>