<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 01.11.2021
  Time: 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Account</title>

    <link
            href="stylePersAcc.css"
            rel="stylesheet"
            type="text/css"
    >
</head>
<body>

<div id="wrapper">

    <form name="persAcc" class="persAcc" action="/dateUpdate" method="get">
        <div class="update">
            <input type="submit" name="submit" value="Добавить данные о себе" class="button" />
        </div>
    </form>

    <form name="persAcc2" class="persAcc" action="/reservation" method="get">
        <div class="reservation">
            <input type="submit" name="submit" value="Забронировать поездку" class="button" />
        </div>
    </form>
</div>



</body>
</html>
