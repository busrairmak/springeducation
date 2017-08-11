<%@ page import="com.mebitech.springeducation.ColorEnum" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Car</title>
    <style>

        table, th, td{
            border: 1px solid black;
            padding: 5px;
            border-radius: 2px;
        }

    </style>
</head>
<body>
<h2>Car Page</h2>

<c:set var="colors" value="<%=ColorEnum.values()%>"/>

<c:if test="${car.name == null}">
    <h2>Add Car</h2>
    <form:form method="POST" action="car/addCar" commandName="car" modelAttribute="car">
        <table>
            <tr>
                <th>Name</th>
                <th>Model</th>
                <th>Color</th>
            </tr>

            <tr>
                <td>
                    <form:input path="name"/>
                </td>
                <td>
                    <form:input path="model"/>
                </td>
                <td>
                    <form:select path="color">
                        <c:forEach items="${colors}" var="color">
                            <option value="${color}">${color.name()}</option>
                        </c:forEach>
                    </form:select>
                </td>


                <td>
                    <input type="submit" value="Add">
                </td>
            </tr>
        </table>
    </form:form>
</c:if>


<c:if test="${car.name != null}">
    <h2>Update Car</h2>
    <form:form method="POST" action="/car/updateCar/${car.id}" commandName="car" modelAttribute="car">
        <table>
            <tr>
                <th>Name</th>
                <th>Model</th>
                <th>Color</th>
            </tr>

            <tr>
                <td>
                    <form:input path="name"/>
                </td>
                <td>
                    <form:input path="model"/>
                </td>
                <td>
                    <form:select path="color">
                        <c:forEach items="${colors}" var="color">

                            <c:if test="${color == car.color}">
                                <option selected value="${color}">${color.name()}</option>
                            </c:if>

                            <c:if test="${color != car.color}">
                                <option value="${color}">${color.name()}</option>
                            </c:if>

                        </c:forEach>
                    </form:select>
                </td>


                <td>
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </form:form>
</c:if>

<h2>Cars</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Model</th>
        <th>Color</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>

    <c:forEach var="car" items="${cars}">

        <tr>
            <td>${car.id}</td>
            <td>${car.name}</td>
            <td>${car.model}</td>
            <td style="background-color:${car.color}; color:white;" >${car.color}</td>
            <td>
                <form method="DELETE" action="car/delete/${car.id}">
                    <button type="submit">Delete</button>
                </form>
            </td>
            <td>
                <a href="/car/edit/${car.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>

</table>


</body>
</html>
