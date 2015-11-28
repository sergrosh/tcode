<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sec:authorize var="isAdmin" access="hasRole('ROLE_ADMIN')"/>

<h2>Resources</h2>

<sec:authorize access="isAuthenticated()">
    <ul class="nav nav-pills">
        <li class="active">
            <a href="${Mappings.SUBMIT_RESOURCE_PAGE}">Submit resource</a>
        </li>
    </ul>
    <hr>
</sec:authorize>

<%--@elvariable id="resourcesMap" type="java.util.HashMap<java.lang.String,com.tcode.persistence.model.Resource>"--%>
<c:forEach var="entry" items="${resourcesMap}">
    <h3><i>${entry.key}</i></h3>
    <c:forEach var="resource" items="${entry.value}">
        <div class="row">
            <div style="margin-left: 30px;">
                <h5>
                    <a href="${resource.link}" target="_blank">${resource.title}</a>
                </h5>
                <blockquote>${resource.about}</blockquote>

                <c:if test="${isAdmin}">
                    <p>Status:
                        <a href="#" id="${Constants.RESOURCE_IS_PUBLISHED}"
                           data-pk="${resource.id}"
                           data-type="select"
                           data-placement="right"
                           data-value="${resource.published}"
                           data-url="${Mappings.REST_RESOURCE_UPDATE_JSON}"
                           data-source="${Mappings.REST_RESOURCE_ENABLE_VALUES_JSON}"
                           data-original-title="Resource status"
                           class="editable editable-empty">${resource.published}</a>
                    </p>

                    <p>Delete resource:
                        <a href="${Mappings.ADMIN_DELETE_RESOURCE_DO}?resourceId=${resource.id}"
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