<%--@elvariable id="note" type="com.tcode.persistence.model.Note"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="custom-tglib" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="sh.jsp" %>
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

<h2>${note.title}</h2>

<div style="overflow: auto;">
    <c:out value="${note.description}" escapeXml="false"/>
</div>
<c:forEach items="${note.snippets}" varStatus="i" var="snippet">
    <div class="snippet-base">
        <div>
            <label>
                <h4 class="lead">${snippet.title}</h4>
            </label>
            <c:if test="${not empty snippet.code}">
                <pre id="snippetCode${i.index}" class="brush: ${custom:shBrush(snippet.xtype)}"><c:out
                        value="${snippet.code}"/></pre>
            </c:if>
            <span>Language
                <span class="badge badge-info">
                        ${custom:langName(snippet.xtype)}
                </span>
            </span>
        </div>
        </br>
        <blockquote>
                ${snippet.description}
        </blockquote>
    </div>
</c:forEach>

<hr>
<c:if test="${not empty note.usefulLinks}">
    Usefull links:
    <ul>
        <c:forEach var="link" items="${note.usefulLinks}">
            <li><a href="${link.url}">${empty link.title ? link.url : link.title} </a></li>
        </c:forEach>
    </ul>
</c:if>
<hr>
<span>Tags:
<c:forEach var="tag" items="${note.tags}">
    <a href="${Mappings.SEARCH_PAGE}?q=[${tag}]"><span class="label">${tag}</span></a>
</c:forEach>

<%@include file="/WEB-INF/jsp/note/magic-buttons.jsp" %>

</span>
<hr>
<div id="disqus_thread"></div>
<script type="text/javascript">
    var disqus_shortname = 'tcode';
    (function () {
        var dsq = document.createElement('script');
        dsq.type = 'text/javascript';
        dsq.async = true;
        dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
        (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
    })();
</script>
<noscript>Please enable JavaScript to view the <a href="http://disqus.com/?ref_noscript">comments powered by Disqus.</a>
</noscript>
<a href="http://disqus.com" class="dsq-brlink">comments powered by <span class="logo-disqus">Disqus</span></a>

