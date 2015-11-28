<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="technology" type="com.tcode.persistence.model.Tool"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="technologyForm" action="${Mappings.SUBMIT_TECHNOLOGY_DO}" method="POST" class="span11">
    <h2>Submit technology</h2>

    <c:if test="${not empty technology}">
        <div class="alert alert-info">
            Technology successfully submitted. After approving it would be at technologies board. Thank you.
        </div>
    </c:if>

    <div class="row">
        <div class="span6">
            <label>Technology name</label>
            <input value="${technology.name}" type="text" name="${Constants.TECHNOLOGY_NAME}" class="span6"
                   placeholder="Title"
                   data-required="true"
                   data-trigger="focusout">
            <label>Link to site</label>
            <input value="${technology.link}" type="text" name="${Constants.TECHNOLOGY_LINK}" class="span6"
                   placeholder="Link"
                   data-required="true"
                   data-trigger="focusout">
            <label>Category</label>
            <input value="${technology.category}" type="text" name="${Constants.TECHNOLOGY_CATEGORY}" class="span6"
                   placeholder="Link"
                   data-provide="typeahead"
                   data-source="${Mappings.REST_TECHNOLOGY_CATEGORIES_JSON}"
                   data-required="true"
                   data-trigger="focusout">
        </div>
        <div class="span8">
            <label>About technology</label>
            <textarea name="${Constants.TECHNOLOGY_ABOUT}" class="input-xlarge span8"
                      rows="10">${technology.about}</textarea>
        </div>

    </div>
    <button id="technologySubmitBtn" type="submit" class="btn btn-primary pull-left">Send</button>
</form>

<script>
    $(function () {
        $("#technologySubmitBtn").click(function () {
            $("#technologyForm").parsley('validate');
        });
    });
</script>