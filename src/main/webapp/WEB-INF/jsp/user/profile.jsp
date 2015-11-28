<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" uri="custom-tglib" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="user" type="com.tcode.persistence.model.SpringUser"--%>
<sec:authentication var="user" property="principal"/>
<h2>Profile</h2>
<table id="user" class="table table-bordered table-striped">
    <tbody>
    <tr>
        <td>Avatar</td>
        <td>
            <img src="${user.avatarUrl}"/>

            <p>
                <small>*If you wanna avatar, go to <a href="http://www.gravatar.com" target="_blank">gravatar.com</a>
                    register with your mail and
                    upload photo.
                </small>
            </p>
        </td>
    </tr>
    <tr>
        <td width="30%">Username</td>
        <td>${user.username}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td>Change Password</td>
        <td>${user.password}</td>
    </tr>
    <tr>
        <td>Editor code theme</td>
        <td><a href="#" id="${Constants.CM_THEME}"
               data-pk="1"
               data-type="select"
               data-placement="right"
               data-value="${user.options.codeMirrorTheme}"
               data-url="${Mappings.REST_USER_UPDATE_DO}"
               data-source="${Mappings.REST_USER_CODE_MIRROR_THEMES_JSON}"
               data-original-title="Select code theme"
               class="editable editable-empty"></a></td>
    </tr>
    <tr>
        <td>Show code theme</td>
        <td><a href="#" id="${Constants.SH_THEME}"
               data-pk="1"
               data-type="select"
               data-placement="right"
               data-value="${user.options.syntaxHighlighterTheme}"
               data-url="${Mappings.REST_USER_UPDATE_DO}"
               data-source="${Mappings.REST_USER_CODE_SH_THEMES_JSON}"
               data-original-title="Select show code theme"
               class="editable editable-empty"></a></td>
    </tr>
    <tr>
        <td>Site theme</td>
        <td><a href="#" id="${Constants.SITE_THEME}"
               data-pk="1"
               data-type="select"
               data-value="${user.options.siteTheme}"
               data-placement="right"
               data-url="${Mappings.REST_USER_UPDATE_DO}"
               data-source="${Mappings.REST_USER_SITE_THEMES_JSON}"
               data-original-title="Select site theme"
               class="editable editable-empty"></a></td>
    </tr>
    </tbody>
</table>
<script>
    $(function () {
        $('.editable').editable({
            success: function (data) {
                alertify.success("User profile updated!");
            },
            error: function (data) {
                alertify.error("Some problem was occurred! Please reload page and try again!");
            }
        });
    });
</script>