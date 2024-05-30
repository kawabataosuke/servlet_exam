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
 * ジャンル検索用サーブレット
 * @author 川端
 */
@WebServlet("/bookGenreSearch")
public class BookGenreSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//入力された文字列を取得
		String genreId = request.getParameter("genre");
		//DAOを生成
		BookListDAO bookListDao = new BookListDAO();
		//findByGernreメソッドの戻り値をリスト型に格納
		List<BookListBean> bookList = bookListDao.findByGenre(genreId);
		//検索結果をセット
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/select/list.jsp").forward(request, response);
	}
}
