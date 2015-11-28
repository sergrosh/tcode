<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<div style="margin-top: 40px;">
    <form:form action="${Mappings.ADMIN_USER_DO}" modelAttribute="user" id="userEditForm" method="post"
               class="form-horizontal">

        <fieldset>
            <form:hidden path="id"/>
            <t:input path="username" label="User name:"/>
            <t:input path="password" label="Password:"/>
            <div class="control-group">
                <label class="control-label" for="encryptedPassword">Original password</label>

                <div class="controls">
                    <input type="text" class="input-xlarge" id="encryptedPassword" name="encryptedPassword">
                </div>
            </div>
            <t:input path="email" label="Email:"/>
        </fieldset>

        <spring:eval var="roles" expression="@environmentBean.getRoles()"/>

        <div class="form-group">
            <label class="col-sm-2 control-label">Roles:</label>

            <div class="controls">

                <c:forEach items="${roles}" var="role">
                    <div class="checkbox">
                            ${role} <form:checkbox path="roles" value="${role}"/>
                    </div>
                </c:forEach>

            </div>
        </div>
        </br>
        <div class="form-group">
            <div class="controls">
                <button type="submit" class="btn btn-default">Save</button>
                <a href="${Mappings.ADMIN_USER_LIST}" class="btn btn-default btn-lg" role="button">Back</a>
            </div>
        </div>
    </form:form>
</div>
