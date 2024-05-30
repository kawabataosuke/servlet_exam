<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<title>ログイン画面</title>
</head>
<body>
 <%@ include file="/common/header.jsp"%>
 <div id="main">
   <p>ユーザーIDとパスワードを入力してください。</p>
   <p class="error">${errMessage}</p>
   <form action="<%=request.getContextPath()%>/login" method="post">
     ユーザーID:<input type="text" name="bookUserId"><br>
     パスワード:<input type="password" name="password"><br>
     <input type="submit" value="ログイン">
   </form>
 </div>
 <%@ include file="/common/footer.jsp"%>
</body>
</html>