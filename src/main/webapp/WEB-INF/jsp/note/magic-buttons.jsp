<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="isAdmin" access="hasRole('ROLE_ADMIN')"/>
<sec:authorize var="isAnonymous" access="isAnonymous()"/>
<sec:authorize var="isAuthenticated" access="isAuthenticated()"/>

<c:if test="${isAuthenticated}">
    <c:if test="${isAdmin or (note.username eq user.username)}">
        <div class=" pull-right">
            <div class="btn-group">
                <a onclick="deleteNote(this)" data-url="${Mappings.ADMIN_DELETE_NOTE_DO}?noteId=${note.id}"
                   class="btn-small btn btn-inverse disabled"><i
                        class="icon-white icon-trash"></i></a>
                <a href="${Mappings.NOTE_EDIT_PAGE}?id=${note.id}"
                   class="btn-small btn btn-inverse disabled"><i
                        class="icon-white icon-share-alt"></i></a>
            </div>
        </div>
        <script>
            function deleteNote(link) {
                alertify.confirm("Delete this note?", function (e) {
                    if (e) {
                        window.location = $(link).attr("data-url");
                    }
                });
            }
        </script>
    </c:if>
</c:if>
