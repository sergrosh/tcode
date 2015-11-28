<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sec:authorize var="isAdmin" access="hasRole('ROLE_ADMIN')"/>

<h2>Technologies</h2>

<sec:authorize access="isAuthenticated()">
    <ul class="nav nav-pills">
        <li class="active">
            <a href="${Mappings.SUBMIT_TECHNOLOGY_PAGE}">Submit technology</a>
        </li>
    </ul>
    <hr>
</sec:authorize>

<%--@elvariable id="technologiesMap" type="java.util.HashMap<java.lang.String,com.tcode.persistence.model.Technology>"--%>
<c:forEach var="entry" items="${technologiesMap}">
    <h2><i>${entry.key}</i></h2>
    <c:forEach var="technology" items="${entry.value}">
        <hr>
        <div class="row">
            <div style="margin-left: 30px;">
                <h4>
                    <a href="${technology.link}" target="_blank">${technology.name}</a>
                </h4>
                <blockquote>${technology.about}</blockquote>

                <c:if test="${isAdmin}">
                    <p>Status:
                        <a href="#" id="${Constants.TECHNOLOGY_IS_PUBLISHED}"
                           data-pk="${technology.id}"
                           data-type="select"
                           data-placement="right"
                           data-value="${technology.published}"
                           data-url="${Mappings.REST_TECHNOLOGY_UPDATE_DO}"
                           data-source="${Mappings.REST_TECHNOLOGY_ENABLE_VALUES_JSON}"
                           data-original-title="Technology status"
                           class="editable editable-empty">${technology.published}</a>
                    </p>

                    <p>Delete technology:
                        <a href="${Mappings.ADMIN_DELETE_TECHNOLOGY_DO}?toolId=${technology.id}"
                           class="btn-small btn btn-inverse disabled pull-right"><i
                                class="icon-white icon-trash"></i></a>
                    </p>
                </c:if>

            </div>
        </div>
        <hr>
    </c:forEach>
</c:forEach>

<c:if test="${isAdmin}">
    <script>
        $(function () {
            $('.editable').editable();
        });
    </script>
</c:if>