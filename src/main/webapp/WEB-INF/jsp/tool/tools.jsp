<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sec:authorize var="isAdmin" access="hasRole('ROLE_ADMIN')"/>

<h2>Developer tools</h2>

<sec:authorize access="isAuthenticated()">
    <ul class="nav nav-pills">
        <li class="active">
            <a href="${Mappings.SUBMIT_TOOL_PAGE}">Submit tool</a>
        </li>
    </ul>
    <hr>
</sec:authorize>


<%--@elvariable id="toolsMap" type="java.util.HashMap<java.lang.String,com.tcode.persistence.model.Tool>"--%>
<c:forEach var="entry" items="${toolsMap}">
    <h2><i>${entry.key}</i></h2>
    <c:forEach var="tool" items="${entry.value}">
        <hr>
        <div class="row">
            <div style="margin-left: 30px;">
                <h4>
                    <a href="${tool.link}" target="_blank">${tool.name}</a>
                </h4>
                <blockquote>${tool.about}</blockquote>
                <c:if test="${isAdmin}">
                    <p>Status:
                        <a href="#" id="${Constants.TOOL_IS_PUBLISHED}"
                           data-pk="${tool.id}"
                           data-type="select"
                           data-placement="right"
                           data-value="${tool.published}"
                           data-url="${Mappings.REST_TOOL_UPDATE_DO}"
                           data-source="${Mappings.REST_TOOL_ENABLE_VALUES_JSON}"
                           data-original-title="Tool status"
                           class="editable editable-empty">${tool.published}</a>
                    </p>

                    <p>Delete tool:
                        <a href="${Mappings.ADMIN_DELETE_TOOL_DO}?resourceId=${tool.id}"
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