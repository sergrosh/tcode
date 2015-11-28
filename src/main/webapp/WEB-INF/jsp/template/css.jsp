<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="${Mappings.CSS_PATH}/alertify.core.css" rel="stylesheet">
<link href="${Mappings.CSS_PATH}/alertify.default.css" rel="stylesheet">
<link href="${Mappings.CSS_PATH}/style.css" rel="stylesheet">
<link href="${Mappings.CSS_PATH}/prettify.css" rel="stylesheet">
<link href="${Mappings.CSS_PATH}/chosen.css" rel="stylesheet">
<link href="${Mappings.CSS_PATH}/nanoscroller.css" rel="stylesheet">
<link href="${Mappings.CSS_PATH}/bootstrap-tag.css" rel="stylesheet">
<link href="${Mappings.CSS_PATH}/codemirror.css" rel="stylesheet">

<c:choose>
    <c:when test="${isDeveloperEnv}">
        <link href="${Mappings.CSS_PATH}/${user ne null ? user.options.siteTheme.css : 'bootstrap.css'}"
              rel="stylesheet">
        <link href="${Mappings.CSS_PATH}/bootstrap-responsive.css" rel="stylesheet">
    </c:when>
    <c:otherwise>
        <link href="${Mappings.CSS_PATH}/${user ne null ? user.options.siteTheme.css : 'bootstrap.min.css'}"
              rel="stylesheet">
        <link href="${Mappings.CSS_PATH}/bootstrap-responsive.min.css" rel="stylesheet">
    </c:otherwise>
</c:choose>

<style type="text/css">
    /* Override some defaults */
    html, body {
        background-color: #eee;
    }

    body {
        padding-top: 40px; /* 40px to make the container go all the way to the bottom of the topbar */
    }

    .container > footer p {
        text-align: center; /* center align it with the container */
    }

    /*.container {*/
    /*width: 1020px; *//* downsize our container to make the content feel a bit tighter and more cohesive. NOTE: this removes two full columns from the grid, meaning you only go to 14 columns and not 16. */
    /*}*/

    /* The white background content wrapper */
    .content {
        background-color: #fff;
        padding: 20px;
        margin: 0 -20px; /* negative indent the amount of the padding to maintain the grid system */
        -webkit-border-radius: 0 0 6px 6px;
        -moz-border-radius: 0 0 6px 6px;
        border-radius: 0 0 6px 6px;
        -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
        -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
        box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
    }

    /* Page header tweaks */
    .page-header {
        background-color: #f5f5f5;
        padding: 20px 20px 10px;
        margin: -20px -20px 20px;
    }

    /* Styles you shouldn't keep as they are for displaying this base example only */
    .content .span10,
    .content .span4 {
        min-height: 500px;
    }

    /* Give a quick and non-cross-browser friendly divider */
    .content .span4 {
        margin-left: 0;
        padding-left: 19px;
        border-left: 1px solid #eee;
    }

    .topbar .btn {
        border: 0;
    }

</style>