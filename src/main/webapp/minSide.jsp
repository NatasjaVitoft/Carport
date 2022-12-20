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

        <h5>Hej </h5>
        <p>velkommen til din side</p>

        <form action="addorder" method="get">
            <input type="submit" value="Her kan du se dine ordre"/>
        </form>
        <br>
        <br>
        <br>

        <div style="width: 1300px">
            <c:forEach var="item" items="${sessionScope.orderlist}">

                <table class="table table-dark">
                    <thead>
                    <tr>
                        <th scope="col">Order id</th>
                        <th scope="col">Dato</th>
                        <th scope="col">Pris</th>
                        <th scope="col">Email</th>
                        <th scope="col">Carport</th>
                        <th scope="col">Længde</th>
                        <th scope="col">Bredde</th>
                        <th scope="col">Stk liste</th>
                        <th scope="col">Skitse ovenfra</th>
                        <th scope="col">Skitse fra siden</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">${item.order_id}</th>
                        <td>${item.date}</td>
                        <td>${item.price}</td>
                        <td>${item.email}</td>
                        <td>${item.carportID}</td>
                        <td>${item.length} cm</td>
                        <td>${item.width} cm</td>
                        <td>
                            <form action="Bom" method="get">
                            <form action="Stykliste.jsp">
                                 <input class="btn btn-light border-0 rounded-0" type="submit"value="Stykliste"/>
                                 <input type="hidden" name="hiddenid" value="${item.order_id}"/>
                            </form>
                            </form>
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
