<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="resources" type="java.util.List<com.tcode.persistence.model.Resource>"--%>
<%--@elvariable id="Mappings" type="java.util.HashMap"--%>

<h2>Submitted resources</h2>
<c:forEach var="resource" items="${resources}">

    <div class="row well">
        <div>
            <h4>
                Title: <a href="#" id="${Constants.RESOURCE_TITLE}"
                          data-pk="${resource.id}"
                          data-type="text"
                          data-placement="right"
                          data-value="${resource.title}"
                          data-url="${Mappings.REST_RESOURCE_UPDATE_JSON}"
                          class="editable editable-empty"></a>
            </h4>

            <p>Link: <a href="#" id="${Constants.RESOURCE_LINK}"
                        data-pk="${resource.id}"
                        data-type="text"
                        data-placement="right"
                        data-value="${resource.link}"
                        data-url="${Mappings.REST_RESOURCE_UPDATE_JSON}"
                        class="editable editable-empty"></a>
            </p>

            <p>
                <a href="${resource.link}" target="_blank">url</a>
            </p>

            <p>About:
                <a href="#" id="${Constants.RESOURCE_ABOUT}"
                   data-pk="${resource.id}"
                   data-type="textarea"
                   data-placement="right"
                   data-url="${Mappings.REST_RESOURCE_UPDATE_JSON}"
                   class="editable">${resource.about}</a>
            </p>

            <p>Category:
                <a href="#" id="${Constants.RESOURCE_CATEGORY}"
                   data-pk="${resource.id}"
                   data-type="text"
                   data-placement="right"
                   data-value="${resource.category}"
                   data-url="${Mappings.REST_RESOURCE_UPDATE_JSON}"
                   class="editable editable-empty"></a>
            </p>

            <p>Status:
                <a href="#" id="${Constants.RESOURCE_IS_PUBLISHED}"
                   data-pk="${resource.id}"
                   data-type="select"
                   data-placement="right"
                   data-url="${Mappings.REST_RESOURCE_UPDATE_JSON}"
                   data-source="${Mappings.REST_RESOURCE_ENABLE_VALUES_JSON}"
                   data-original-title="Resource status"
                   class="editable editable-empty">${resource.published}</a>
            </p>

            <p>Delete resource:
                <a href="${Mappings.ADMIN_DELETE_RESOURCE_DO}?resourceId=${resource.id}"
                   class="btn-small btn btn-inverse disabled pull-right"><i class="icon-white icon-trash"></i></a>
            </p>
        </div>
    </div>
</c:forEach>

<script>
    $(function () {
        $('.editable').editable({
                    success: function (data) {
                        alertify.success("Resource updated!");
                    },
                    error: function (data) {
                        alertify.error("Some problem was occurred! Please reload page and try again!");
                    }
                }
        );
    });
</script>