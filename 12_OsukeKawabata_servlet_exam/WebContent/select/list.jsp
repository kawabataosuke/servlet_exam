<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="jp.co.sss.book.bean.BookListBean" %>
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
   書籍一覧画面<br/>
   <div class="form">
   <form action="<%=request.getContextPath()%>/bookNameSearch" method="post">
    書籍名：<input type="text" name="bookName">
    <input type="submit" value="検索">
   </form>
   <form action ="<%=request.getContextPath()%>/bookGenreSearch" method="post"> 
    <div>
    ジャンル名：<select name="genre">
                   <option value="1">文学</option>
                   <option value="2">経済</option>
                   <option value="3">技術</option>
                </select>
                <input type="submit" value="検索">
    </form><br/>
    </div>
   </div>
   <c:if test="${!empty bookList}" >
   <table>
    <tr>
     <th>書籍ID</th>
     <th>書籍名</th>
     <th>著者</th>
     <th>発行日</th>
     <th>在庫</th>
     <th>ジャンル名</th>
    </tr>
    <c:forEach var="bookList" items="${bookList}">
     <tr>
      <td>${bookList.bookId}</td>
      <td>${bookList.bookName}</td>
      <td>${bookList.author}</td>
      <td>${bookList.date}</td>
      <td>${bookList.stock}</td>
      <td>${bookList.genre.genreName}</td>
     </tr>
     </c:forEach>
    </table>
    </c:if>
    <c:if test="${empty bookList}" >
     <p class=error>該当する書籍は存在しません。</p>
     <a href="<%=request.getContextPath() %>/bookList">一覧表示に戻る</a>
    </c:if>
  
  </div>
  <%@ include file="/common/footer.jsp"%>
</body>
</html>