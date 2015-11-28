<%--REGISTER--%>

<div id="signUpModal" class="modal hide" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">x</button>
        <h3>Sign Up</h3>
    </div>
    <div class="modal-body">
        <form id="signUpForm" class="form-horizontal" method="POST" action="${Mappings.SIGN_UP_DO}"
              data-validate="parsley">

            <div class="control-group">
                <label class="control-label" for="inputEmail">Email</label>

                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-envelope"></i></span>
                        <input id="inputEmail"
                               type="text"
                               name="email"
                               placeholder="Email"
                               data-required="true"
                               data-trigger="focusout"
                               data-remote="${Mappings.REST_USER_CHECK_EMAIL_JSON}"
                               data-remote-datatype="json"
                               data-type="email">
                    </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputUsername">Username</label>

                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-user"></i></span>
                        <input id="inputUsername"
                               type="text"
                               name="username"
                               data-required="true"
                               data-trigger="focusout"
                               data-remote="${Mappings.REST_USER_CHECK_USERNAME_JSON}"
                               data-remote-datatype="json"
                               placeholder="Username">
                    </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputPassword">Password</label>

                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-lock"></i></span>
                        <input type="password"
                               id="inputPassword"
                               data-required="true"
                               data-trigger="focusout"
                               name="password"
                               placeholder="Password">
                    </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">Are you a robot?</label>

                <div class="controls">
                    <jsp:include page="../captcha.jsp"/>
                </div>
            </div>
            <div class="form-actions">
                <span class="pull-right"><input type="submit" id="signUpSubmitBtn"
                                                class="btn btn-primary" value="Register"></span>
            </div>
        </form>
    </div>
</div>

<script>
    $(function () {
        $("#signUpSubmitBtn").click(function () {
            $("#signUpForm").parsley('validate');
        });
    });
</script>
