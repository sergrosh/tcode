<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="resource" type="com.tcode.persistence.model.Resource"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="resourceForm" action="${Mappings.SUBMIT_RESOURCE_DO}" method="POST" class="span11">
    <h2>Submit resource</h2>

    <c:if test="${not empty resource}">
        <div class="alert alert-info">
            Resource successfully submitted. After approving it would be at resources board. Thank you.
        </div>
    </c:if>

    <div class="row">
        <div class="span6">
            <label>Resource name</label>
            <input value="${resource.title}" type="text" name="${Constants.RESOURCE_TITLE}" class="span6"
                   placeholder="Title"
                   data-required="true"
                   data-trigger="focusout">
            <label>Link to site</label>
            <input value="${resource.link}" type="text" name="${Constants.RESOURCE_LINK}" class="span6"
                   placeholder="Link"
                   data-required="true"
                   data-trigger="focusout">
            <label>Category</label>
            <input value="${resource.category}" type="text" name="${Constants.RESOURCE_CATEGORY}" class="span6"
                   placeholder="Link"
                   data-provide="typeahead"
                   data-source="${Mappings.REST_RESOURCE_CATEGORIES_JSON}"
                   data-required="true"
                   data-trigger="focusout">
        </div>
        <div class="span8">
            <label>About resource</label>
            <textarea name="${Constants.RESOURCE_ABOUT}" class="input-xlarge span8"
                      rows="10">${resource.about}</textarea>
        </div>

    </div>
    <button id="resourceSubmitBtn" type="submit" class="btn btn-primary pull-left">Send</button>
</form>

<script>
    $(function () {
        $("#resourceSubmitBtn").click(function () {
            $("#resourceForm").parsley('validate');
        });
    });
</script>