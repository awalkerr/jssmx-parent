<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>Login Page - Ace Admin</title>

    <meta name="description" content="User login page" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="/static/ace/css/bootstrap.css" />
    <link rel="stylesheet" href="/static/ace/css/font-awesome.css" />

    <!-- text fonts -->
    <link rel="stylesheet" href="/static/ace/css/ace-fonts.css" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="/static/ace/css/ace-part2.css" />
    <![endif]-->
    <link rel="stylesheet" href="/static/ace/css/ace-rtl.css" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="/static/ace/css/ace-ie.css" />
    <![endif]-->

    <!-- ace styles -->
    <link rel="stylesheet" href="/static/ace/css/ace.css" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="/static/ace/js/html5shiv.js"></script>
    <script src="/static/ace/js/respond.js"></script>
    <![endif]-->

    <style type="text/css">
        .mt-10{margin-top:6%;}
        .cavs{
            /*z-index: 1;*/
            position: fixed;
            width:95%;
            margin-left: 20px;
            margin-right: 20px;
            pointer-events: none;
        }
    </style>
</head>
<body class="login-layout light-login">
<canvas class="cavs"></canvas>
<div class="main-container">
    <div class="main-content">
        <div class="row mt-10">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="ace-icon fa fa-leaf green"></i>
                            <span class="red">管理系统</span>
                            <span class="grey" id="id-text2">登录</span>
                        </h1>
                        <h4 class="blue" id="id-company-text">&copy; 重庆凌瑞图书有限公司</h4>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="ace-icon fa fa-coffee green"></i>
                                        请输入你的信息
                                    </h4>

                                    <div class="space-6" id="loginBox"></div>

                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input type="text" name="loginName" id="loginName" class="form-control" placeholder="用户名/邮箱" />
                                                    <i class="ace-icon fa fa-user"></i>
                                                </span>
                                            </label>

                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input type="password" name="password" id="password" class="form-control" placeholder="密码" />
                                                    <i class="ace-icon fa fa-lock"></i>
                                                </span>
                                            </label>

                                            <div class="space"></div>

                                            <div class="clearfix">
                                                <label class="inline">
                                                    <input type="checkbox" class="ace" id="saveId" onclick="savePwd();"/>
                                                    <span class="lbl"> 记住我</span>
                                                </label>

                                                <button type="button" class="width-35 pull-right btn btn-sm btn-primary">
                                                    <i class="ace-icon fa fa-key"></i>
                                                    <span class="bigger-110" onclick="serverCheck();">登录</span>
                                                </button>
                                            </div>

                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>

                                    <div class="social-or-login center">
                                        <span class="bigger-110">其他登录</span>
                                    </div>

                                    <div class="space-6"></div>

                                    <div class="social-login center">
                                        <a class="btn btn-primary">
                                            <i class="ace-icon fa fa-facebook" style="padding: 10px"></i>
                                        </a>

                                        <a class="btn btn-info">
                                            <i class="ace-icon fa fa-twitter" style="padding: 10px"></i>
                                        </a>

                                        <a class="btn btn-danger">
                                            <i class="ace-icon fa fa-google-plus" style="padding: 10px"></i>
                                        </a>
                                    </div>
                                </div><!-- /.widget-main -->

                                <div class="toolbar clearfix">
                                    <div>
                                        <a href="#" data-target="#forgot-box" class="forgot-password-link">
                                            <i class="ace-icon fa fa-arrow-left"></i>
                                            忘记密码
                                        </a>
                                    </div>

                                    <div>
                                        <a href="#" data-target="#signup-box" class="user-signup-link">
                                            注册
                                            <i class="ace-icon fa fa-arrow-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </div><!-- /.widget-body -->
                        </div><!-- /.login-box -->

                        <div id="forgot-box" class="forgot-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header red lighter bigger">
                                        <i class="ace-icon fa fa-key"></i>
                                        找回密码
                                    </h4>

                                    <div class="space-6"></div>
                                    <p>
                                        输入你的电子邮箱
                                    </p>

                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input type="email" class="form-control" placeholder="邮箱" />
                                                    <i class="ace-icon fa fa-envelope"></i>
                                                </span>
                                            </label>

                                            <div class="clearfix">
                                                <button type="button" class="width-35 pull-right btn btn-sm btn-danger">
                                                    <i class="ace-icon fa fa-lightbulb-o"></i>
                                                    <span class="bigger-110">发送</span>
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div><!-- /.widget-main -->

                                <div class="toolbar center">
                                    <a href="#" data-target="#login-box" class="back-to-login-link">
                                        去登录
                                        <i class="ace-icon fa fa-arrow-right"></i>
                                    </a>
                                </div>
                            </div><!-- /.widget-body -->
                        </div><!-- /.forgot-box -->

                        <div id="signup-box" class="signup-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header green lighter bigger">
                                        <i class="ace-icon fa fa-users blue"></i>
                                        注册新用户
                                    </h4>

                                    <div class="space-6"></div>
                                    <p> 输入注册信息: </p>

                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input type="email" class="form-control" placeholder="邮箱" />
                                                    <i class="ace-icon fa fa-envelope"></i>
                                                </span>
                                            </label>

                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input type="text" class="form-control" placeholder="用户名" />
                                                    <i class="ace-icon fa fa-user"></i>
                                                </span>
                                            </label>

                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input type="password" class="form-control" placeholder="密码" />
                                                    <i class="ace-icon fa fa-lock"></i>
                                                </span>
                                            </label>

                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input type="password" class="form-control" placeholder="再一次输入" />
                                                    <i class="ace-icon fa fa-retweet"></i>
                                                </span>
                                            </label>

                                            <label class="block">
                                                <input type="checkbox" class="ace" />
                                                <span class="lbl">
                                                    我接受
                                                    <a href="#">用户协议</a>
                                                </span>
                                            </label>

                                            <div class="space-24"></div>

                                            <div class="clearfix">
                                                <button type="reset" class="width-30 pull-left btn btn-sm">
                                                    <i class="ace-icon fa fa-refresh"></i>
                                                    <span class="bigger-110">重设</span>
                                                </button>

                                                <button type="button" class="width-65 pull-right btn btn-sm btn-success">
                                                    <span class="bigger-110">注册</span>

                                                    <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>

                                <div class="toolbar center">
                                    <a href="#" data-target="#login-box" class="back-to-login-link">
                                        <i class="ace-icon fa fa-arrow-left"></i>
                                        去登录
                                    </a>
                                </div>
                            </div><!-- /.widget-body -->
                        </div><!-- /.signup-box -->
                    </div><!-- /.position-relative -->

                    <div class="navbar-fixed-top align-right">
                        <br />
                        &nbsp;
                        <a id="btn-login-dark" href="#">Dark</a>
                        &nbsp;
                        <span class="blue">/</span>
                        &nbsp;
                        <a id="btn-login-blur" href="#">Blur</a>
                        &nbsp;
                        <span class="blue">/</span>
                        &nbsp;
                        <a id="btn-login-light" href="#">Light</a>
                        &nbsp; &nbsp; &nbsp;
                    </div>
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.main-content -->
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='/static/ace/js/jquery.js'>"+"<"+"/script>");
</script>
<script type="text/javascript" src="/static/js/jquery-1.7.2.js"></script>
<script src="/static/login/js/ban.js"></script>
<!-- <![endif]-->

<script type="text/javascript" src="/static/js/jquery.tips.js"></script>
<script type="text/javascript" src="/static/js/jquery.cookie.js"></script>

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/static/ace/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='/static/ace/js/jquery.mobile.custom.js'>"+"<"+"/script>");
</script>

<script type="text/javascript">
    function serverCheck() {
        if(check()){
            var loginName = $("#loginName").val();
            var password = $("#password").val();
            $.ajax({
                type: "post",
                url: "login_login",
                data:{data:loginName+","+password,tm:new Date().getTime()},
                dataType:"json",
                cache:false,
                success:function (data) { //success,error,userErr,bitErr
                    if("success" === data.result){
                        saveCookie();
                        window.location.href="main/index";
                    }else if("userErr" === data.result){
                        $("#loginName").tips({
                            side : 1,
                            msg : "用户名或密码有误",
                            bg : '#FF5080',
                            time : 15
                        });
                        $("#loginName").focus();
                    }else if("bitErr" === data.result){
                        $("#loginName").tips({
                            side : 1,
                            msg : "用户名必须8位以上",
                            bg : '#FF5080',
                            time : 15
                        });
                        $("#loginName").focus();
                    }else {
                        $("#loginName").tips({
                            side : 1,
                            msg : "缺少参数",
                            bg : '#FF5080',
                            time : 15
                        });
                        $("#loginName").focus();
                    }
                }
            })
        }
    }

    // 客户端校验
    function check() {
        if($("#loginName").val() === ""){
            $("#loginName").tips({
                side : 2,
                msg : '用户名不得为空',
                bg : '#AE81FF',
                time : 3
            });
            $("#loginName").focus();
            return false;
        }else {
            $("#loginName").val(jQuery.trim($("#loginName").val()));
        }

        if ($("#password").val() === ""){
            $("#password").tips({
                side : 2,
                msg : '密码不得为空',
                bg : '#AE81FF',
                time : 3
            });
            $("#password").focus();
            return false;
        }

        $("#loginBox").tips({
            side : 1,
            msg : '正在登录 , 请稍后 ...',
            bg : '#68B500',
            time : 10
        });

        return true;
    }

    // 保存密码
    function savePwd() {
        if(!$("#saveId").is(":checked")){
            $.cookie('loginName', '', {
                expires : -1
            });
            $.cookie('password', '', {
                expires : -1
            });
            $("#loginName").val('');
            $("#password").val('');
        }
    }

    // 保存到Cookie中
    function saveCookie() {
        if($("#saveId").is(":checked")){
            $.cookie('loginName',$("#loginName").val(),{
                expires:7
            });
            $.cookie('password',$("#password").val(),{
                expires:7
            })
        }
    }

    jQuery(function ($) {
        var loginName = $.cookie('loginName');
        var password = $.cookie('password');
        if(typeof (loginName) !== "undefined" || typeof (password) !== "undefined"){
            $("#loginName").val(loginName);
            $("#password").val(password);
            $("#saveId").attr("checked",true);
        }
    })

</script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function($) {
        $(document).on('click', '.toolbar a[data-target]', function(e) {
            e.preventDefault();
            var target = $(this).data('target');
            $('.widget-box.visible').removeClass('visible');//hide others
            $(target).addClass('visible');//show target
        });
    });



    //you don't need this, just used for changing background
    jQuery(function($) {
        $('#btn-login-dark').on('click', function(e) {
            $('body').attr('class', 'login-layout');
            $('#id-text2').attr('class', 'white');
            $('#id-company-text').attr('class', 'blue');

            e.preventDefault();
        });
        $('#btn-login-light').on('click', function(e) {
            $('body').attr('class', 'login-layout light-login');
            $('#id-text2').attr('class', 'grey');
            $('#id-company-text').attr('class', 'blue');

            e.preventDefault();
        });
        $('#btn-login-blur').on('click', function(e) {
            $('body').attr('class', 'login-layout blur-login');
            $('#id-text2').attr('class', 'white');
            $('#id-company-text').attr('class', 'light-blue');

            e.preventDefault();
        });

    });
</script>

</body>
</html>
