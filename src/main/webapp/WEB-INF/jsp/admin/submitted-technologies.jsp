<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="technologies" type="java.util.List<com.tcode.persistence.model.Technology>"--%>
<%--@elvariable id="Mappings" type="java.util.HashMap"--%>

<h2>Submitted technologies</h2>
<c:forEach var="technology" items="${technologies}">

    <div class="row well">
        <div>
            <h4>
                Title: <a href="#" id="${Constants.TECHNOLOGY_NAME}"
                          data-pk="${technology.id}"
                          data-type="text"
                          data-placement="right"
                          data-value="${technology.name}"
                          data-url="${Mappings.REST_TECHNOLOGY_UPDATE_DO}"
                          class="editable editable-empty"></a>
            </h4>

            <p>Link: <a href="#" id="${Constants.TECHNOLOGY_LINK}"
                        data-pk="${technology.id}"
                        data-type="text"
                        data-placement="right"
                        data-value="${technology.link}"
                        data-url="${Mappings.REST_TECHNOLOGY_UPDATE_DO}"
                        class="editable editable-empty"></a>
            </p>

            <p>
                <a href="${technology.link}" target="_blank">url</a>
            </p>

            <p>About:
                <a href="#" id="${Constants.TECHNOLOGY_ABOUT}"
                   data-pk="${technology.id}"
                   data-type="textarea"
                   data-placement="right"
                   data-url="${Mappings.REST_TECHNOLOGY_UPDATE_DO}"
                   class="editable">${technology.about}</a>
            </p>

            <p>Category:
                <a href="#" id="${Constants.TECHNOLOGY_CATEGORY}"
                   data-pk="${technology.id}"
                   data-type="text"
                   data-placement="right"
                   data-value="${technology.category}"
                   data-url="${Mappings.REST_TECHNOLOGY_UPDATE_DO}"
                   class="editable editable-empty"></a>
            </p>

            <p>Status:
                <a href="#" id="${Constants.TECHNOLOGY_IS_PUBLISHED}"
                   data-pk="${technology.id}"
                   data-type="select"
                   data-placement="right"
                   data-url="${Mappings.REST_TECHNOLOGY_UPDATE_DO}"
                   data-source="${Mappings.REST_TECHNOLOGY_ENABLE_VALUES_JSON}"
                   data-original-title="Technology status"
                   class="editable editable-empty">${technology.published}</a>
            </p>

            <p>Delete technology:
                <a href="${Mappings.ADMIN_DELETE_TECHNOLOGY_DO}?technologyId=${technology.id}"
                   class="btn-small btn btn-inverse disabled pull-right"><i class="icon-white icon-trash"></i></a>
            </p>
        </div>
    </div>
</c:forEach>

<script>
    $(function () {
        $('.editable').editable();
    });
</script>