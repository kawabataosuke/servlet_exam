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
 * 書籍名検索用サーブレット
 * @author 川端
 */
@WebServlet("/bookNameSearch")
public class BookNameSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//入力された文字列を取得
		String bookName = request.getParameter("bookName");
		//DAOを生成
		BookListDAO bookListDao = new BookListDAO();
		//findByNameContainメソッドの戻り値をリスト型に格納
		List<BookListBean> bookList = bookListDao.findByNameContain(bookName);
		//検索結果をセット
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/select/list.jsp").forward(request, response);
	}

}
