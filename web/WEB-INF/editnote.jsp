<%-- 
    Document   : editnote
    Created on : Sep 30, 2020, 8:25:05 AM
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
        <h2>Edit Note</h2>
        
        <form method="post">
        <p>Title: </p><input name="title" type="text" value="${data.getTitle()}">
        <br>
        <p>Contents:</p><textarea name="content" rows="4" cols="50">${data.getContent()}</textarea>
        <br>
        <button type="submit">Save</button>
        </form>
    </body>
</html>
