<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>

<%@include file="init.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="meta.jsp" %>
    <%@include file="css.jsp" %>
    <%@include file="script.jsp" %>
</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar">

<tiles:insertAttribute name="header"/>

<div class="container">
    <div class="content" style="min-height: 500px;">
        <div class="container-fluid">
            <tiles:insertAttribute name="content"/>
        </div>
    </div>
</div>

<tiles:insertAttribute name="footer"/>

<%@include file="alertify.jsp" %>

</body>
</html>
