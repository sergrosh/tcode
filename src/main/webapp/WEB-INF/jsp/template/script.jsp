<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:choose>
    <c:when test="${isDeveloperEnv}">
        <script src="${Mappings.JS_PATH}/jquery-1.9.1.min.js"></script>
        <script src="${Mappings.JS_PATH}/bootstrap.js"></script>
        <script src="${Mappings.JS_PATH}/alertify.js"></script>
        <script src="${Mappings.JS_PATH}/chosen.jquery.js"></script>
        <script src="${Mappings.JS_PATH}/jquery.nanoscroller.js"></script>

    </c:when>
    <c:otherwise>

        <script src="${Mappings.JS_PATH}/jquery-1.9.1.min.js"></script>
        <script src="${Mappings.JS_PATH}/bootstrap.min.js"></script>
        <script src="${Mappings.JS_PATH}/alertify.min.js"></script>
        <script src="${Mappings.JS_PATH}/chosen.jquery.min.js"></script>
        <script src="${Mappings.JS_PATH}/jquery.nanoscroller.min.js"></script>

    </c:otherwise>
</c:choose>

<script src="${Mappings.JS_PATH}/main.js"></script>
<script src="${Mappings.JS_PATH}/handlebars.js"></script>
<script src="${Mappings.JS_PATH}/html5shiv.js"></script>
<script src="${Mappings.JS_PATH}/bootstrap-wysiwyg.js"></script>
<script src="${Mappings.JS_PATH}/jquery.hotkeys.js"></script>
<script src="${Mappings.JS_PATH}/bootstrap-tooltip.js"></script>
<script src="${Mappings.JS_PATH}/bootstrap-tag.js"></script>
<script src="${Mappings.JS_PATH}/parsley.min.js"></script>
<script src="${Mappings.JS_PATH}/jquery.timeago.js" type="text/javascript"></script>

<link href="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.4.4/bootstrap-editable/css/bootstrap-editable.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.4.4/bootstrap-editable/js/bootstrap-editable.min.js"></script>