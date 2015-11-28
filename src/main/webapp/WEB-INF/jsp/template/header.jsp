<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="requestedPage" value="${requestScope['javax.servlet.forward.request_uri']}"/>

<c:set var="active"> class="active"</c:set>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="${Mappings.INDEX_PAGE}">tcode</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li ${requestedPage eq Mappings.INDEX_PAGE ?active:''}>
                        <a href="${Mappings.INDEX_PAGE}">
                            <i class="icon-home icon-white"></i>
                            Home
                        </a>
                    </li>
                    <li ${requestedPage eq Mappings.TECHNOLOGIES_PAGE?active:''}>
                        <a href="${Mappings.TECHNOLOGIES_PAGE}">
                            <i class="icon-fire icon-white"></i> Technologies
                        </a>
                    </li>
                    <li ${requestedPage eq Mappings.TOOLS_PAGE?active:''}>
                        <a href="${Mappings.TOOLS_PAGE}">
                            <i class="icon-wrench icon-white"></i> Tools
                        </a>
                    </li>
                    <li ${requestedPage eq Mappings.RESOURCES_PAGE?active:''}>
                        <a href="${Mappings.RESOURCES_PAGE}">
                            <i class="icon-leaf icon-white"></i> Resources
                        </a>
                    </li>
                    <li ${requestedPage eq Mappings.ABOUT_PAGE?active:''}>
                        <a href="${Mappings.ABOUT_PAGE}">
                            <i class=""></i> About
                        </a>
                    </li>
                </ul>
                <form action="${Mappings.SEARCH_PAGE}" class="navbar-search pull-left">
                    <input name="q" type="text" class="search-query" placeholder="Search" value="${searchString}">
                </form>
            </div>


            <sec:authorize access="isAnonymous()">

                <ul class="nav pull-right">
                    <li>
                        <a href="#signUpModal" role="button" data-toggle="modal">Sign up</a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" href="#" data-toggle="dropdown">Login<strong class="caret"></strong></a>

                        <div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px;">
                            <form class="form-vertical" action="${Mappings.SECURITY_CHECK}" method="POST"
                                  data-validate="parsley"
                                  accept-charset="UTF-8">
                                <div class="control-group">
                                    <div class="controls">
                                        <div class="input-prepend">
                                            <span class="add-on"><i class="icon-user"></i></span>
                                            <input type="text"
                                                   data-required="true"
                                                   name="j_username"
                                                   placeholder="Email or Username">
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <div class="input-prepend">
                                            <span class="add-on"><i class="icon-lock"></i></span>
                                            <input type="password"
                                                   data-required="true"
                                                   name="j_password"
                                                   placeholder="Password">
                                        </div>
                                    </div>
                                </div>
                                <span>
                                    <input type="checkbox" checked="true" id="c1" name="_spring_security_remember_me"/>
                                    <label for="c1" class="text-info"><span></span>Remember Me</label>
                                        <%--<span class="pull-right">--%>
                                    <input type="submit" class="btn btn-primary pull-right"
                                           style="margin-bottom: 10px;" value="Login">
                                </span>
                            </form>
                        </div>
                    </li>
                </ul>
                <style>
                    input[type="checkbox"] {
                        display: none;
                    }

                    input[type="checkbox"] + label {
                        font-family: Arial, sans-serif;
                        font-size: 14px;
                    }

                    input[type="checkbox"] + label span {
                        display: inline-block;
                        width: 19px;
                        height: 19px;
                        margin: -1px 4px 0 0;
                        vertical-align: middle;
                        background: url('/static/img/check_radio_sheet.png') left top no-repeat;
                        cursor: pointer;
                    }

                    input[type="checkbox"]:checked + label span {
                        background: url('/static/img/check_radio_sheet.png') -19px top no-repeat;
                    }

                </style>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <div class="pull-right">
                    <ul class="nav pull-right">
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <sec:authentication property="principal.username"/>
                            <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li ${requestedPage eq Mappings.NOTE_CREATE_PAGE?active:''}>
                                    <a href="${Mappings.NOTE_CREATE_PAGE}">
                                        <i class="icon-list-alt"></i>
                                        Create a note</a>
                                </li>
                                <li>
                                    <a href="${Mappings.SEARCH_PAGE}?q=@${user.username}@"><i
                                            class="icon-user"></i>&nbsp;My notes</a>
                                </li>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <li><a href="${Mappings.ADMIN_SUBMITTED_TOOLS_PAGE}"><i class="icon-wrench"></i>
                                        Submitted
                                        tools</a></li>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <li><a href="${Mappings.ADMIN_SUBMITTED_TECHNOLOGIES_PAGE}"><i
                                            class="icon-fire"></i> Submitted
                                        technologies</a></li>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <li><a href="${Mappings.ADMIN_SUBMITTED_RESOURCES_PAGE}"><i class="icon-leaf"></i>
                                        Submitted
                                        resources</a></li>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <li><a href="${Mappings.ADMIN_USER_LIST}"><i class="icon-leaf"></i> Registered
                                        users</a></li>
                                </sec:authorize>
                                <li  ${requestedPage eq Mappings.USER_PROFILE_PAGE?active:''}>
                                    <a href="${Mappings.USER_PROFILE_PAGE}"><i class="icon-cog"></i> Profile</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="${Mappings.LOGOUT}"><i class="icon-off"></i> Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </sec:authorize>

        </div>
    </div>
</div>
<sec:authorize access="isAnonymous()">
    <%@ include file="registration.jsp" %>
</sec:authorize>