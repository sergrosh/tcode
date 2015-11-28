<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="custom-tglib" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${message ne null}">
    <div class="alert alert-success">
            ${message.message}
    </div>
</c:if>
<form class="form-inline" action="${Mappings.ADMIN_USER_LIST}" method="GET" role="form">
    <div class="form-group">
        <input type="text" class="form-control" id="search" name="search" value="${search}" placeholder="search">
        <button type="submit" class="btn btn-default">Find</button>
    </div>
</form>
<table class="table table-bordered">
    <tr>
        <th>User name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Roles</th>
        <th>Action</th>
    </tr>
    <%--@elvariable id="users" type="java.util.List<User>"--%>
    <%--@elvariable id="user" type="com.tcode.persistence.model.SpringUser"--%>
    <c:forEach varStatus="status" items="${users}" var="user">
        <tr class="${(status.index % 2) == 0 ? "info" : "active"}">
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${custom:join(user.roles, ', ')}</td>
            <td>
                <a href="${Mappings.ADMIN_USER_PAGE}?id=${user.id}" class="btn btn-primary btn-lg disabled"
                   role="button">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>