<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="note" type="com.tcode.persistence.model.Note"--%>
<%--@elvariable id="page" type="org.springframework.data.domain.Page"--%>

<c:choose>
    <c:when test="${not empty searchString}">
        <ul class="breadcrumb">
            <li><a href="${Mappings.INDEX_PAGE}">Home</a> <span class="divider">/</span></li>
            <li class="active">Search</li>
        </ul>
        <h4 title="place between @@ username, for searching all his notes;  place between [ ] tag, for searching all notes with this tag">
            You are looking for: <i>${searchString}</i></h4>
        <small>place between @@ username, for searching all his notes</small>
        </br>
        <small>place between [ ] tag, for searching all notes with this tag</small>
        </br>
        </br>
    </c:when>
    <c:otherwise>
        <ul class="breadcrumb">
            <li><a href="${Mappings.INDEX_PAGE}">Home</a> <span class="divider">/</span></li>
            <li class="active">Notes</li>
        </ul>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${page.totalElements gt 0}">
        <c:forEach var="note" items="${page.content}">
            <div class="well well-small">
                <table style="width:100%">
                    <tr>
                        <td>
                            <p><a href="${Mappings.NOTE_VIEW_PAGE}?id=${note.id}"><h5>${note.title}</h5></a></p>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            <i class="icon-tags"></i>
                            <c:forEach var="tag" items="${note.tags}">
                                <a href="${Mappings.SEARCH_PAGE}?q=[${tag}]"><span class="label">${tag}</span></a>
                            </c:forEach>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>
                                <a href="${Mappings.SEARCH_PAGE}?q=@${note.username}@"><i
                                        class="icon-user"></i>&nbsp;${note.username}</a>
                                <fmt:formatDate var="cDate" pattern="yyyy-MM-dd'T'HH:mm:ss"
                                                value="${note.creationDate}"/>
                                &nbsp;<i class="icon-time"></i>
                                <span id="cDate${note.id}" class="timeago" title="${cDate}">${cDate}</span>
                            </p>
                        </td>
                        <td>
                            <%@include file="/WEB-INF/jsp/note/magic-buttons.jsp" %>
                        </td>
                    </tr>
                </table>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <i>Sorry, cannot find anything...</i>
    </c:otherwise>
</c:choose>

<div class="pagination pagination-centered">
    <ul>
        <c:if test="${page.totalPages gt 1}">

            <c:choose>
                <c:when test="${page.firstPage}">
                    <li class="disabled"><a href="#">&laquo;</a>
                    <li>
                </c:when>
                <c:otherwise>
                    <li><a href="${Mappings.NOTES}/${page.number}.page">&laquo;</a></li>
                </c:otherwise>
            </c:choose>
            <c:forEach varStatus="i" begin="0" end="${page.totalPages-1 }">
                <c:choose>
                    <c:when test="${i.index eq page.number}">
                        <li class="active"><a href="#">${i.index+1}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${Mappings.NOTES}/${i.index+1}.page">${i.index+1}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:choose>
                <c:when test="${page.lastPage}">
                    <li class="disabled"><a href="#">&raquo;</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${Mappings.NOTES}/${page.number+2}.page">&raquo;</a></li>
                </c:otherwise>
            </c:choose>
        </c:if>
    </ul>
</div>

<script>
    $(document).ready(function () {
        $(".timeago").timeago();
    });
</script>
