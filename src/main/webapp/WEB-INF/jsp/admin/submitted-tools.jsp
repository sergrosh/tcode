<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="tools" type="java.util.List<com.tcode.persistence.model.Tool>"--%>
<%--@elvariable id="Mappings" type="java.util.HashMap"--%>

<h2>Submitted tools</h2>
<c:forEach var="tool" items="${tools}">

    <div class="row well">
        <div>
            <h4>
                Title: <a href="#" id="${Constants.TOOL_NAME}"
                          data-pk="${tool.id}"
                          data-type="text"
                          data-placement="right"
                          data-value="${tool.name}"
                          data-url="${Mappings.REST_TOOL_UPDATE_DO}"
                          class="editable editable-empty"></a>
            </h4>

            <p>Link: <a href="#" id="${Constants.TOOL_LINK}"
                        data-pk="${tool.id}"
                        data-type="text"
                        data-placement="right"
                        data-value="${tool.link}"
                        data-url="${Mappings.REST_TOOL_UPDATE_DO}"
                        class="editable editable-empty"></a>
            </p>

            <p>
                <a href="${tool.link}" target="_blank">url</a>
            </p>

            <p>About:
                <a href="#" id="${Constants.TOOL_ABOUT}"
                   data-pk="${tool.id}"
                   data-type="textarea"
                   data-placement="right"
                   data-url="${Mappings.REST_TOOL_UPDATE_DO}"
                   class="editable">${tool.about}</a>
            </p>

            <p>Category:
                <a href="#" id="${Constants.TOOL_CATEGORY}"
                   data-pk="${tool.id}"
                   data-type="text"
                   data-placement="right"
                   data-value="${tool.category}"
                   data-url="${Mappings.REST_TOOL_UPDATE_DO}"
                   class="editable editable-empty"></a>
            </p>

            <p>Status:
                <a href="#" id="${Constants.TOOL_IS_PUBLISHED}"
                   data-pk="${tool.id}"
                   data-type="select"
                   data-placement="right"
                   data-url="${Mappings.REST_TOOL_UPDATE_DO}"
                   data-source="${Mappings.REST_TOOL_ENABLE_VALUES_JSON}"
                   data-original-title="Tool status"
                   class="editable editable-empty">${tool.published}</a>
            </p>

            <p>Delete tool:
                <a href="${Mappings.ADMIN_DELETE_TOOL_DO}?toolId=${tool.id}"
                   class="btn-small btn btn-inverse disabled pull-right"><i
                        class="icon-white icon-trash"></i></a>
            </p>
        </div>
    </div>
</c:forEach>

<script>
    $(function () {
        $('.editable').editable();
    });
</script>