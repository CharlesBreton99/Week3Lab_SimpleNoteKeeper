<%-- 
    Document   : viewnote
    Created on : Sep 30, 2020, 8:25:14 AM
    Author     : Birdd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>

        <h2>View Note</h2>

        <p><b>Title:</b> ${data.title}</p>
        <p><b>Contents:</b><br> ${data.content}</p>
        
        <a href="editnote">Edit</a>
    </body>
</html>
