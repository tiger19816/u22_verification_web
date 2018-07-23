<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ImageUploadServlet" method="post" enctype="multipart/form-data">
<input type="file" name="filename" id="inputphoto" size="50" accept="image/jpeg,image/png">
<button type="submit" id="sbbutton">投稿する</button>
</form>
</body>
</html>