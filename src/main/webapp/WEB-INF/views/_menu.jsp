<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div style="padding: 5px; background: #86c0e0;">

    <a href="${pageContext.request.contextPath}/">Home</a>

    <c:if test="${not empty loggedUserId}">
        |
        <a href="${pageContext.request.contextPath}/user/update">Edit User</a>
    </c:if>
    <c:if test="${not empty loggedUserId}">
        |
        <a href="${pageContext.request.contextPath}/user/${loggedUserId}">My Account Info</a>
    </c:if>

    <c:if test="${not empty loggedUserId}">
        |
        <a href="${pageContext.request.contextPath}/product/marketplace">Marketplace</a>
    </c:if>

    <c:if test="${loggedUserId == 0 or empty loggedUserId}">
        |
        <a href="${pageContext.request.contextPath}/login">Login</a>
    </c:if>

    <c:if test="${loggedUserId == 0 or empty loggedUserId}">
        |
        <a href="${pageContext.request.contextPath}/account/create">Register</a>
    </c:if>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        |
        <a href="${pageContext.request.contextPath}/admin/users">Manage Users</a>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        |
        <a href="${pageContext.request.contextPath}/product/manage">Manage Products</a>
    </sec:authorize>

</div>