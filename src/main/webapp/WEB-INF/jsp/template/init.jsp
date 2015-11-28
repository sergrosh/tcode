<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" uri="custom-tglib" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request"/>
<c:set var="servletPath" value="${pageContext.request.servletPath}" scope="request"/>
<c:set var="currentUrl" value="${contextPath}/${servletPath}" scope="request"/>

<sec:authentication var="user" property="principal" scope="request"/>

<c:if test="${not custom:isUser(user)}">
    <c:set var="user" value="${null}"/>
</c:if>

