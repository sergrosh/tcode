<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        .center {
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: auto;
            margin-top: auto;
        }
    </style>
</head>
<body>
<div class="hero-unit center">
    <h1>
        <small><font face="Tahoma" color="red">Error ${pageContext.errorData.statusCode}</font></small>
    </h1>
    <br/>

    <p>The page you requested could not be found, either contact your webmaster or try again. Use your browsers
        <b>Back</b> button to navigate to the page you have prevously come from</p>

    <p><b>Or you could just press this neat little button:</b></p>
    <a href="/index.page" class="btn btn-large btn-info"><i class="icon-home icon-white"></i> Take Me Home</a>
</div>
<br/>
</body>
</html>