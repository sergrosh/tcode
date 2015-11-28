<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="tool" type="com.tcode.persistence.model.Tool"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="toolForm" action="${Mappings.SUBMIT_TOOL_DO}" method="POST" class="span11">
    <h2>Submit tool</h2>

    <c:if test="${not empty tool}">
        <div class="alert alert-info">
            Tool successfully submitted. After approving it would be at tools board. Thank you.
        </div>
    </c:if>

    <div class="row">
        <div class="span6">
            <label>Tool name</label>
            <input value="${tool.name}" type="text" name="${Constants.TOOL_NAME}" class="span6" placeholder="Title"
                   data-required="true"
                   data-trigger="focusout">
            <label>Link to site</label>
            <input value="${tool.link}" type="text" name="${Constants.TOOL_LINK}" class="span6" placeholder="Link"
                   data-required="true"
                   data-trigger="focusout">
            <label>Category</label>

            <input value="${tool.category}" type="text" name="${Constants.TOOL_CATEGORY}" class="span6 typeahead"
                   placeholder="Category"
                   data-provide="typeahead"
                   data-source="${categories}"
                   data-required="true">
        </div>
        <div class="span8">
            <label>About tool</label>
            <textarea name="${Constants.TOOL_ABOUT}" class="input-xlarge span8" rows="10">${tool.about}</textarea>
        </div>

    </div>
    <button id="toolSubmitBtn" type="submit" class="btn btn-primary pull-left">Send</button>
</form>

<script>
    $(function () {
        $('.typeahead').typeahead();
        $("#toolSubmitBtn").click(function () {
            $("#toolForm").parsley('validate');
        });
    });
</script>