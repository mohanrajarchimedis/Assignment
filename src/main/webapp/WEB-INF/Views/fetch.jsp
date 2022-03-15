<%-- 
    Document   : fetch
    Created on : 14-Mar-2022, 5:02:16 pm
    Author     : mohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to DB Fetcher</title>
    </head>
    <body>
        <h1>Hello User!</h1><br><br>
        <form action="allfetch" method="GET">
            <input type="submit" value="Click me to fetch All Data"/><br><br><br><br>
        </form>
        <form action="fetch" method="POST">
            <input type=text" name="filter"/><br><br>
            <input type="submit" value="Click me to fetch particular data"/>
        </form>
    </body>
</html>
