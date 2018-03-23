<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up Login</title>
    <link rel="stylesheet" href="<%=basePath%>css/style.css">
</head>

<body>

<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>


<div class="cotn_principal">
    <div class="cont_centrar">
        <div class="cont_login">
            <div class="cont_info_log_sign_up">
                <div class="col_md_login">
                    <div class="cont_ba_opcitiy">
                        <h2>LOGIN</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur.</p>
                        <button class="btn_login" onClick="cambiar_login()">LOGIN</button>
                    </div>
                </div>
                <div class="col_md_sign_up">
                    <div class="cont_ba_opcitiy">
                        <h2>SIGN UP</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur.</p>
                        <button class="btn_sign_up" onClick="cambiar_sign_up()">SIGN UP</button>
                    </div>
                </div>
            </div>
            <div class="cont_back_info">
                <div class="cont_img_back_grey">
                    <img src="<%=basePath%>img/po2.jpg" alt=""/>
                </div>
            </div>
            <div class="cont_forms">
                <div class="cont_img_back_">
                    <img src="<%=basePath%>img/po.jpg" alt=""/>
                </div>

                <form id="login_form" action="<%=basePath%>login/ln">
                    <div class="cont_form_login">
                        <a href="#" onClick="ocultar_login_sign_up()">
                            <i class="material-icons">&#xE5C4;</i>
                        </a>
                        <h2>LOGIN</h2>
                        <input type="text" placeholder="User" name="username" id="u1"/>
                        <input type="password" placeholder="Password" name="password" id="p1"/>
                        <button type="submit" class="btn_login" onClick="login()">LOGIN</button>
                    </div>
                </form>

                <form id="sign_up" method="post" onsubmit="return checkForm()">
                    <div class="cont_form_sign_up">
                        <a href="#" onClick="ocultar_login_sign_up()">
                            <i class="material-icons">&#xE5C4;</i>
                        </a>
                        <h2>SIGN UP</h2>
                        <input type="text" placeholder="Email" id="email" name="email"/>
                        <input type="text" placeholder="User" id="username" name="username"/>
                        <input type="password" placeholder="Password" id="password" name="password" />
                        <input type="password" placeholder="Confirm Password" id="repassword" name="repassword" />
                        <button type="submit" class="btn_sign_up" onClick="register()">SIGN UP</button>

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<%=basePath%>js/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="<%=basePath%>js/messages_zh.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.validate.min.js"></script>

<script>
    /*(function(){
        $("#sign_up").validate({
            rules:{
                user:{
                    required:true,
                    minlength:3
                },
                password:{
                    required:true,
                    digits:true,
                    minlength:6
                },
                repassword:{
                    required:true,
                    equalTo:"[name='password']"
                },
                email:{
                    required:true,
                    email:true
                }
            },
            messages:{
                user:{
                    required:"用户名不能为空!",
                    minlength:"用户名不得少于3位!"
                },
                password:{
                    required:"密码不能为空!",
                    digits:"密码必须是整数!",
                    minlength:"密码不得少于6位!"
                },
                repassword:{
                    required:"确认密码不能为空!",
                    equalTo:"两次输入密码不一致!"
                },
                email:{
                    required:"邮箱不能为空!",
                    email:"邮箱格式不正确!"
                }
            },
            errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
            success: function(label) { //验证成功后的执行的回调函数
                //label指向上面那个错误提示信息标签label
                label.text(" ") //清空错误提示消息
                    .addClass("success"); //加上自定义的success类
            }
        });
    });*/

    function checkForm() {

        var email = document.getElementById("email").value;
        if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(email)){
            alert("邮箱格式不正确")
            return false;
        }

        var username = document.getElementById("username").value;
        if(username == ''){
            alert("用户名不能为空");
            return false;
        }else if(!/^[^\s'"!@#$%]+$/.test(username) ){
            alert("含空格与特殊字符")

        }

        var password = document.getElementById("password").value;
        if(password == ''){
            alert("密码不能为空");
            return false;
        }

        var repassword = document.getElementById("repassword").value;
        if(password != repassword){
            alert("密码不一致");
            return false;
        }

        return true;
    }



   /* function cEmail(obj) {
        if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(obj)){
            alert("邮箱格式不正确")
            return false;
        }
    }*/




    $(function () {

        $("#username").blur(function () {
            var username = $(this).val();

            $.post("<%=basePath%>/login/checkUser",{"username":username},function (data) {
                /*if(data==0){
                    // 用户名可以使用
                    $("#s1").html("<font color='green'>用户名可以使用</font>");
                    $("#regBut").prop("disabled",false);
                }else if(data==2){
                    // 用户名已经存在
                    $("#s1").html("<font color='red'>用户名已经被占用</font>");
                    $("#regBut").prop("disabled",true);
                }*/
                if(data==1){
                    // 用户名已存在
                    alert("用户名已存在");
                    return false;
                }
            });
        });

        /*$("#email").blur(function () {
            var email = $(this).val();
            if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(email)){
                alert("邮箱格式不正确")
                return false;
            }
        });*/


    })

    function register() {

        $.post("<%=basePath%>login/register",$("#sign_up").serialize(),function (data) {

            if(data == '1'){
                alert("数据错误，注册失败")
            }else if(data == '2'){
                alert("此用户名已存在，注册失败")
            }else if(data == '0'){
//                alert("注册成功，请登陆")
                    cambiar_login();
            }else {
                alert("未知错误！")
            }
        });
    }

    <%--function login() {--%>

        <%--$.get("<%=basePath%>login/ln",--%>
            <%--{"username":$("#u1").val(),"password":$("#p1").val()}--%>
            <%--,function (data) {--%>
            <%--if (data == 4) {--%>
                <%--alert("bbbbbb")--%>
                <%--window.location.href = "<%=basePath%>shop/list";--%>
                <%--alert("asda")--%>
            <%--} else {--%>
                <%--alert("密码错误");--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>


</script>

</body>
</html>
