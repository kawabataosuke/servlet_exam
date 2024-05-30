package jp.co.sss.book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.book.bean.BookListBean;
import jp.co.sss.book.dao.BookListDAO;

/**
 * 書籍一覧用サーブレット
 * @author 川端
 */
@WebServlet("/bookList")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookListDAO bookListDao = new BookListDAO();
		//検索結果を取得
		List<BookListBean> bookList = bookListDao.findAll();
		//検索結果をセット
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/select/list.jsp").forward(request, response);
	}
}
