<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="breadcrumb">
    <li class="active">Users</li>
</ul>

<%--@elvariable id="user" type="com.tcode.persistence.model.SpringUser"--%>
<%--@elvariable id="page" type="org.springframework.data.domain.Page"--%>

<c:if test="${page.totalElements gt 0}">
    <c:forEach var="user" items="${page.content}">
        <div class="well well-small">
            <p>Username:&nbsp;
                <a href="${Mappings.SEARCH_PAGE}?q=@${user.username}@"><i
                        class="icon-user"></i>&nbsp;${user.username}
                </a>
            </p>

            <p>Registered:&nbsp;<i class="icon-time"></i>
                <fmt:formatDate var="cDate" pattern="yyyy-MM-dd'T'HH:mm:ss" value="${user.creationDate}"/>
                <span id="cDate${user.id}" class="timeago" title="${cDate}">${cDate}</span>
            </p>

            <p>
                User id: ${user.id}
            </p>

            <p>Add role:
                <a href="#" id="role"
                   data-pk="${user.id}"
                   data-type="text"
                   data-placement="right"
                   data-value="${user.roles}"
                   data-url="${Mappings.ADMIN_SET_ROLE_JSON}"
                   class="editable editable-empty"></a>
            </p>
        </div>
    </c:forEach>
</c:if>

<div class="pagination pagination-centered">
    <ul>
        <c:choose>
            <c:when test="${page.firstPage}">
                <li class="disabled"><a href="#">&laquo;</a>
                <li>
            </c:when>
            <c:otherwise>
                <li><a href="${Mappings.ADMIN_USERS}/${page.number}.page">&laquo;</a></li>
            </c:otherwise>
        </c:choose>
        <c:if test="${page.totalPages gt 0}">
            <c:forEach varStatus="i" begin="0" end="${page.totalPages-1 }">
                <c:choose>
                    <c:when test="${i.index eq page.number}">
                        <li class="active"><a href="#">${i.index+1}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${Mappings.ADMIN_USERS}/${i.index+1}.page">${i.index+1}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:choose>
                <c:when test="${page.lastPage}">
                    <li class="disabled"><a href="#">&raquo;</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${Mappings.ADMIN_USERS}/${page.number+2}.page">&raquo;</a></li>
                </c:otherwise>
            </c:choose>
        </c:if>
    </ul>
</div>

<script>
    $(document).ready(function () {
        $('.editable').editable();
        $(".timeago").timeago();
    });

</script>
