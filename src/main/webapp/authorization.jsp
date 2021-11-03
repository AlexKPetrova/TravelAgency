<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
    <link
            href="styleAuth.css"
            rel="stylesheet"
            type="text/css"
    >
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
</head>

<body>


<div id="wrapper">
    <div class="user-icon"></div>
    <div class="pass-icon"></div>

    <%
        String username = "", password = "", remember = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userEmail")) {
                    username = cookie.getValue();
                } else if (cookie.getName().equals("userPassword")) {
                    password = cookie.getValue();
                } else if (cookie.getName().equals("userRemember")) {
                    remember = cookie.getValue();
                }
            }
        }
    %>

    <form name="login-form" class="login-form" action="/login" method="post">

        <div class="header">
            <h1>Авторизация</h1>
            <span>Введите ваши регистрационные данные для входа в ваш личный кабинет. </span>
        </div>

        <div class="content">
            <input name="username" type="text" class="input username" value="Логин" onfocus="this.value=''" />
            <input name="password" type="password" class="input password" value="Пароль" onfocus="this.value=''" />
        </div>

        <div class="rememb">
            <%="1".equals(remember) ? "checked='/checked'" : "" %>
        </div>

        <div class="footer">
            <input type="submit" name="submit" value="ВОЙТИ" class="button" />
            <a href="/registration" class="register" >Регистрация</a>
        </div>

    </form>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $(".username").focus(function() {
            $(".user-icon").css("left","-48px");
        });
        $(".username").blur(function() {
            $(".user-icon").css("left","0px");
        });

        $(".password").focus(function() {
            $(".pass-icon").css("left","-48px");
        });
        $(".password").blur(function() {
            $(".pass-icon").css("left","0px");
        });
    });
</script>
</body>
</html>
