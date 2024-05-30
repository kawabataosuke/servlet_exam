<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
<h3>書籍一覧システム</h3>
<c:if test="${bookUser!=null}">
<p class="head_menu">　　 <a class="head_menu" href="<%=request.getContextPath()%>/logout">ログアウト</a></p>
</c:if>
</header>
