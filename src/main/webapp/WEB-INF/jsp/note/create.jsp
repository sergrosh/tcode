<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="custom" uri="custom-tglib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--@elvariable id="user" type="com.tcode.persistence.model.SpringUser"--%>
<%--@elvariable id="note" type="com.tcode.persistence.model.Note"--%>

<link href="${Mappings.CSS_PATH}/mirror-theme/${user.options.codeMirrorTheme.css}" rel="stylesheet">
<link href="${Mappings.CSS_PATH}/bootstrap-tagmanager.css" rel="stylesheet">

<script src="${Mappings.JS_PATH}/codemirror/codemirror.js"></script>
<script src="${Mappings.JS_PATH}/codemirror/loadmode.js"></script>
<script src="${Mappings.JS_PATH}/codemirror/util/formatting.js"></script>
<script src="${Mappings.JS_PATH}/bootstrap-tagmanager.js"></script>

<script id="snippet-form-template" type="text/x-handlebars-template">
    <%@include file="/WEB-INF/jsp/handlebars/snippet-template.jsp" %>
</script>

<script id="link-template" type="text/x-handlebars-template">
    <%@include file="/WEB-INF/jsp/handlebars/link-template.jsp" %>
</script>

<style>
    /* Base class */
    .snippet-base {
        position: relative;
        margin: 15px 0;
        padding: 39px 19px 14px;
        *padding-top: 19px;
        background-color: #fff;
        border: 1px solid #ddd;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        border-radius: 4px;
    }

    /* Echo out a label for the example */
    .snippet-base:after {
        content: "Snippet";
        position: absolute;
        top: -1px;
        left: -1px;
        padding: 3px 7px;
        font-size: 12px;
        font-weight: bold;
        background-color: #f5f5f5;
        border: 1px solid #ddd;
        color: #9da0a4;
        -webkit-border-radius: 4px 0 4px 0;
        -moz-border-radius: 4px 0 4px 0;
        border-radius: 4px 0 4px 0;
    }
</style>
<script>
    var source = $("#snippet-form-template").html();
    var snippetTemplate = Handlebars.compile(source);
    var linkSource = $("#link-template").html();
    var linkTemplate = Handlebars.compile(linkSource);
    var snipIndex = ${empty note.snippets?"0": (fn:length(note.snippets))};
    var linkIndex = ${empty note.usefulLinks?"0": (fn:length(note.usefulLinks))};
    <%--<c:if test="${empty note}">--%>
    //    $(function () {
    //        addSnippet();
    //        addLink();
    //    });
    <%--</c:if>--%>

    function removeLink(index) {
        $("#link" + index).remove();
    }

    function addLink() {
        var context = {index: linkIndex};
        var html = linkTemplate(context);
        $("#linksHolder").append(html);
        linkIndex = linkIndex + 1;
    }

    function addSnippet() {
        var context = {index: snipIndex};
        var html = snippetTemplate(context);
        $("#snippetsHolder").append(html);
        snipIndex = snipIndex + 1;
    }

    $(function () {
        $("#progressLine").hide();
        $("#saveButton").click(function () {
            if (linkIndex != 0) {
                $("#linksCount").val(linkIndex - 1);
            }
            if (snipIndex != 0) {
                $("#snippetsCountIn").val(snipIndex - 1);
            }
            $("#noteDescriptionHidden").val($("#inputNoteDescription").html());
            $("#noteForm").parsley('validate');
            if ($('.tm-tag-info').length == 0) {
                var tags = $("#tags");
                tags.attr("class", tags.attr("class") + " parsley-validated parsley-error");
                tags.focus();
                $("#tagErrors").html("Tags are required!");
                return '';
            } else {
                $("#hiddenTags").val($('[name="hidden-tags"]').val());
            }
            $("#noteForm").submit();
        });
        $("#moreButton").click(function () {
            addSnippet();
        });
    });
</script>


<form id="noteForm" data-validate="parsley" method="POST" action="${Mappings.NOTE_CREATE_DO}">
    <div class="well well-large">
        <input id="snippetsCountIn" type="hidden" name="${Constants.SNIPPETS_COUNT}"
               value="${empty note.snippets? '0': (fn:length(note.snippets))}">
        <input id="linksCount" type="hidden" name="${Constants.LINKS_COUNT}"
               value="${empty note.usefulLinks? '0': (fn:length(note.usefulLinks))}">

        <input id="noteDescriptionHidden" name="${Constants.NOTE_DESCRIPTION}" type="hidden">
        <input name="${Constants.NOTE_ID}" value="${note.id}" type="hidden">
        <input id="hiddenTags" name="${Constants.NOTE_TAGS}" type="hidden"/>

        <p>

        <h2>${empty note? "New Note":"Edit Note"}</h2>
        <c:if test="${not empty note}">
            <small>
                <p><a href="${Mappings.NOTE_VIEW_PAGE}?id=${note.id}"><h5>Preview this note</h5></a></p>
            </small>
        </c:if>

        </p>
        <c:if test="${success}">
            <div class="alert alert-info">
                <h4>Success!</h4>
                Note successfully saved!
            </div>
        </c:if>

        <c:if test="${not empty errorsMap}">
            <div class="alert alert-error">
                <ul>
                    <c:forEach var="entity" items="${errorsMap}">
                        <li>${entity.key} - ${entity.value}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <p>
            <label class="control-label left" for="inputNoteTitle">Title</label>
            <input type="text" id="inputNoteTitle" name="${Constants.NOTE_TITLE}"
                   class="input-block-level input-xlarge"
                   placeholder="Title"
                   data-required="true"
                   data-trigger="focusout"
                   value="${note.title}">
        </p>

        <div class="control-group">
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" href="#collapseOne">
                        <label class="control-label" for="inputNoteDescription">Description</label>
                    </a>
                </div>
                <div id="collapseOne" class="accordion-body collapse in">
                    <div class="accordion-inner">
                        <%@include file="../rich-text.jsp" %>
                    </div>
                </div>
            </div>
        </div>
        <div class="divider"></div>
    </div>
    <legend>Snippets</legend>
    <div id="snippetsHolder">
        <c:forEach var="snippet" varStatus="cursor" items="${note.snippets}">
            <c:set var="index" value="${cursor.index}"/>
            <%@include file="/WEB-INF/jsp/note/snippet.jsp" %>
        </c:forEach>
    </div>
    <div class="btn-group">
        <a id="moreButton" class="btn btn-large btn-info" data-toggle="tab"><i class="icon-plus icon-white"></i></a>
        <a href="" class="btn btn-large btn-info active" data-toggle="tab" disabled>Add snippet</a>
    </div>
    <hr>

    <div class="control-group" id="links">
        <legend>Useful links</legend>
        <div id="linksHolder">
            <c:forEach var="link" varStatus="cursor" items="${note.usefulLinks}">
                <c:set var="index" value="${cursor.index}"/>
                <%@include file="link.jsp" %>
            </c:forEach>
            <p id="linkErrors"></p>
        </div>
        <button onClick="addLink()" class="btn btn-info" type="button">+</button>
    </div>

    <hr>
    <div class="control-group">
        <label class="control-label" title="split by comma">Note Tags</label>

        <div class="controls">

            <input id="tags" type="text" name="tags"
                   placeholder="Tags" class='tm-input tm-input-info tm-tag-large'>

            <script>
                jQuery("#tags").tagsManager({prefilled: "${custom:join(note.tags, ',')}"});
            </script>
            <ul class="parsley-error-list">
                <li id="tagErrors" class="custom-error-message"></li>
            </ul>
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <button id="saveButton" type="button" class="btn btn-inverse btn-large">Save</button>
        </div>
    </div>
    <div id="progressLine" class="progress progress-striped active ">
        <div class="bar" style="width: 100%;"></div>
    </div>
</form>