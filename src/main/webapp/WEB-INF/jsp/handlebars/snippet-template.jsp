<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="custom-tglib" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="snippet{{index}}">
    <div class="snippet-base">
        <fieldset>

            <div class="control-group">
                <label class="control-label">Title</label>

                <div class="controls">
                    <input name="${Constants.SNIPPET_TITLE}{{index}}" type="text" class="input-block-level input-xlarge" data-required="true"
                           data-trigger="focusout">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">Code</label>

                <div class="controls">
                    <textarea id="snippetCode{{index}}" name="${Constants.SNIPPET_CODE}{{index}}" class="input-block-level"
                              style="height: 100px;"></textarea>
                </div>
            </div>
            <div class="row-fluid">
                <p class="span2" title="Programming language of code">
                    Language
                </p>
                <select id="snippet{{index}}Language" name="${Constants.SNIPPETS_LANGUAGE}{{index}}" data-required="true"
                        data-placeholder="Choose a language" class="chzn-select span4"
                        style="width: 350px; display: none;" tabindex="-1">
                    <option value=""></option>
                    <%--@elvariable id="codeLanguages" type="java.util.List<com.jcoderepository.util.CodeInfo>"--%>
                    <c:forEach var="codeLang" items="${custom:codes()}">
                        <option value="${codeLang.cmFileName}=${codeLang.xtype}">${codeLang.name}</option>
                    </c:forEach>
                </select>
                <button id="formatBtn{{index}}" type="button" class="btn btn-primary btn-small" title="Formatting mostly for CSS, HTML, XML"
                        style="margin-left: 25px;">Format code
                </button>
                <small class="alert alert-info">*Formatting mostly for CSS, HTML, XML</small>
            </div>
            <!-- Textarea -->
            <div class="control-group">
                <label class="control-label" title="Some description about code">Code
                    description</label>

                <div class="controls">
                    <textarea name="${Constants.SNIPPETS_DESCRIPTION}{{index}}" class="input-block-level"></textarea>
                </div>
            </div>
        </fieldset>
        <div class="btn-group">
            <button id="removeSnippetBtn{{index}}" type="button" class="btn "><div class="icon-trash"></div><small>Remove snippet</small></button>
        </div>
    </div>
    <hr>
    <script>
        $(function () {
            $("#removeSnippetBtn{{index}}").click(function () {
                document.getElementById("snippetsHolder").removeChild(document.getElementById("snippet{{index}}"));
            });

            CodeMirror.modeURL = "/static/js/codemirror/mode/%N.js";
            var editor{{index}} = CodeMirror.fromTextArea(document.getElementById("snippetCode{{index}}"), {
                lineNumbers: true,
                viewportMargin: Infinity,
                theme:'${user.options.codeMirrorTheme.value}'
            });

            $("#snippet{{index}}Language").change(function () {
                var value = $("#snippet{{index}}Language").val().split("=");
                var fileName = value[0];
                var mime = value[1];
                CodeMirror.autoLoadMode(editor{{index}}, fileName);
                editor{{index}}.setOption("mode", mime);
            });

            $("#formatBtn{{index}}").click(function () {
                editor{{index}}.autoFormatRange({line: 0, ch: 0}, {line: editor{{index}}.lineCount(), ch: editor{{index}}.getLine(editor{{index}}.lineCount() - 1).length});
                editor{{index}}.setCursor({line: 0, ch: 0});
            });

            $("#snippet{{index}}Language").chosen({no_results_text: "No results matched"});

        });
    </script>

</div>