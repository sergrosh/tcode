<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval var="publicKey" expression="@reCaptchaHolder.getPublicKey()"/>
<div id="recaptcha_div"></div>

<script type="text/javascript" src="http://www.google.com/recaptcha/api/js/recaptcha_ajax.js"></script>

<script type="text/javascript">
    $(function () {
        Recaptcha.create("${publicKey}", 'recaptcha_div', {
            theme: "white"
        });
    });
</script>