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

        <form action="addorder" method="post">
            <input type="submit" value="Her kan du se din stykliste"/>
        </form>
        <br>
        <br>
        <br>

        <div style="width: 1300px">
            <c:forEach var="item" items="${sessionScope.stykliste}">

                <table class="table table-dark">
                    <thead>
                    <tr>
                        <th scope="col">Beskrivelse</th>
                        <th scope="col">Længde</th>
                        <th scope="col">Antal</th>
                        <th scope="col">Enhed</th>
                        <th scope="col">Beskrivelse</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">${item.orders_id}</th>
                        <td>${item.name}</td>
                        <td>${item.length}</td>
                        <td>${item.quantity}</td>
                        <td>${item.unit}</td>
                        <td>${item.description}</td>
                        <td>
                            <button class="btn btn-light border-0 rounded-0" type="button" data-toggle="collapse"
                                    data-target="#collapseExampleThree"
                                    aria-expanded="false" aria-controls="collapseExampleThree">
                                Stk liste
                            </button>
                            <div class="collapse" id="collapseExampleThree">
                                <br>


                            </div>
                        </td>
                        <td>
                            <button class="btn btn-light border-0 rounded-0" type="button" data-toggle="collapse"
                                    data-target="#collapseExample"
                                    aria-expanded="false" aria-controls="collapseExample">
                                Skitse
                            </button>
                            <div class="collapse" id="collapseExample">
                                <br>


                            </div>
                        </td>
                        <td>
                            <button class="btn btn-light border-0 rounded-0" type="button" data-toggle="collapse"
                                    data-target="#collapseExample1"
                                    aria-expanded="false" aria-controls="collapseExample1">
                                Skitse
                            </button>
                            <div class="collapse" id="collapseExample1">
                                <br>

                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>

            </c:forEach>
        </div>

    </jsp:body>
</t:pagetemplate>