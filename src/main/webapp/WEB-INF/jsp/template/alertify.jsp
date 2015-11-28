<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty errors}">
    <script>
        $(function () {
            <c:forEach var="error" items="${errors}">
            alertify.error("${error}");
            </c:forEach>
        });
    </script>
</c:if>


<c:if test="${not empty messages}">
    <script>
        $(function () {
            <c:forEach var="message" items="${messages}">
            alertify.message("${message}");
            </c:forEach>
        });
    </script>
</c:if>
