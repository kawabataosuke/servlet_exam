package jp.co.sss.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.book.bean.BookListBean;
import jp.co.sss.book.bean.Genre;

/**
 * 書籍情報テーブル用DAO
 *@author 川端
*/
public class BookListDAO {
	
	/**
	 *書籍一覧機能 
	 *@return 書籍リスト
	*/
	
	
	public List<BookListBean> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BookListBean bookListBean = null;
		Genre genre = null;
		DBManager dbm = new DBManager();
		List<BookListBean> bookList = new ArrayList<>();

		try {
			// データベースへ接続
			connection = dbm.getConnection();

			// SQLの準備
			preparedStatement = connection
					.prepareStatement("SELECT b.book_id, b.book_name, b.author,"
							+ " TO_CHAR(b.publication_date, 'YYYY/MM/DD') AS publication_date, b.stock, g.genre_name"
							+ " FROM book b INNER JOIN genre g"
							+ " ON b.genre_id = g.genre_id ORDER BY b.book_id ASC");

			// SQLの実行
			ResultSet rs = preparedStatement.executeQuery();

			// 検索結果をJavaBeansに保存
			while (rs.next()) {
				bookListBean = new BookListBean();
				bookListBean.setBookId(rs.getInt("book_id"));
				bookListBean.setBookName(rs.getString("book_name"));
				bookListBean.setAuthor(rs.getString("author"));
				bookListBean.setDate(rs.getString("publication_date"));
				bookListBean.setStock(rs.getInt("stock"));
				genre = new Genre();
				genre.setGenreName(rs.getString("genre_name"));
				bookListBean.setGenre(genre);
				bookList.add(bookListBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースとの接続を切断
			dbm.close(preparedStatement, connection);
		}
		return bookList;
	}
	
	

	/**
	 *名前検索機能
	 *@param bookName 書籍名
	 *@return 名前検索結果リスト
	*/
	public List<BookListBean> findByNameContain(String bookName){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BookListBean bookListBean = null;
		DBManager dbm = new DBManager();
		Genre genre = null;
		List<BookListBean> bookList = new ArrayList<>();
		try {
			// データベースへ接続
			connection = dbm.getConnection();

			// SQLの準備
			preparedStatement = connection
					.prepareStatement("SELECT b.book_id, b.book_name, b.author, "
							+ "TO_CHAR(b.publication_date,'YYYY/MM/DD') AS publication_date, b.stock, g.genre_name"
							+ " FROM book b INNER JOIN genre g"
							+ " ON b.genre_id = g.genre_id WHERE book_name LIKE ? ORDER BY b.book_id ASC");
			preparedStatement.setString(1, "%" + bookName + "%");

			// SQLの実行
			ResultSet rs = preparedStatement.executeQuery();

			// 検索結果をJavaBeansに保存
			while (rs.next()) {
				bookListBean = new BookListBean();
				bookListBean.setBookId(rs.getInt("book_id"));
				bookListBean.setBookName(rs.getString("book_name"));
				bookListBean.setAuthor(rs.getString("author"));
				bookListBean.setDate(rs.getString("publication_date"));
				bookListBean.setStock(rs.getInt("stock"));
				genre = new Genre();
				genre.setGenreName(rs.getString("genre_name"));
				bookListBean.setGenre(genre);
				bookList.add(bookListBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースとの接続を切断
			dbm.close(preparedStatement, connection);
		}
		return bookList;
	}
	
	/**
	 *ジャンル検索機能 
	 *@param genreId ジャンルID
	 *@return ジャンル検索結果リスト
	*/
	public List<BookListBean> findByGenre (String genreId){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BookListBean bookListBean = null;
		DBManager dbm = new DBManager();
		Genre genre = null;
		List<BookListBean> bookList = new ArrayList<>();
		try {
			// データベースへ接続
			connection = dbm.getConnection();

			// SQLの準備
			preparedStatement = connection
					.prepareStatement("SELECT b.book_id, b.book_name, b.author,"
							+ " TO_CHAR(b.publication_date,'YYYY/MM/DD') AS publication_date, b.stock, g.genre_name"
							+ " FROM book b INNER JOIN genre g"
							+ " ON b.genre_id = g.genre_id WHERE g.genre_id = ? ORDER BY b.book_id ASC");
			preparedStatement.setString(1,genreId);

			// SQLの実行
			ResultSet rs = preparedStatement.executeQuery();

			// 検索結果をJavaBeansに保存
			while (rs.next()) {
				bookListBean = new BookListBean();
				bookListBean.setBookId(rs.getInt("book_id"));
				bookListBean.setBookName(rs.getString("book_name"));
				bookListBean.setAuthor(rs.getString("author"));
				bookListBean.setDate(rs.getString("publication_date"));
				bookListBean.setStock(rs.getInt("stock"));
				genre = new Genre();
				genre.setGenreName(rs.getString("genre_name"));
				bookListBean.setGenre(genre);
				bookList.add(bookListBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースとの接続を切断
			dbm.close(preparedStatement, connection);
		}
		return bookList;
	}
		


}
