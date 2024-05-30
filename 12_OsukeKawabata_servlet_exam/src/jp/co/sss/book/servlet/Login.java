package jp.co.sss.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.book.bean.BookUser;
import jp.co.sss.book.dao.BookUserDAO;

/**
 * ログイン用サーブレット
 *
 * @author system_shared
 */
@WebServlet( "/login" )
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookUserId = request.getParameter("bookUserId");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		BookUser bookUser = BookUserDAO.findByUserIDAndPassword(bookUserId, password);
		

		if (bookUser != null) {
			//セッションスコープを追加
			session.setAttribute("bookUser", bookUser);
			response.sendRedirect(request.getContextPath() + "/bookList");
			
		} else {
			request.setAttribute("errMessage", "ユーザID、またはパスワードが間違っています。");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}
