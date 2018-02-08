<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td><c:out value="${product.name}" /></td>
            <td><c:out value="${product.description}" /></td>
            <td><fmt:formatNumber value="${product.price}" type="currency" currencyCode="USD" /></td>
        </tr>
    </c:forEach>
</table>