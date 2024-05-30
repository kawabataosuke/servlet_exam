package jp.co.sss.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sss.book.bean.BookUser;

/**
 * ユーザ情報テーブル用DAO
 *
 * @author system_shared
 */
public class BookUserDAO {
	/**
	 * ユーザIDとパスワードが一致するユーザ情報を検索
	 *
	 * @param userId ユーザID
	 * @param password パスワード
	 * @return ユーザ情報
	 *             
	 */
	public static BookUser findByUserIDAndPassword(String userId, String password) {
		Connection connection = null;
		DBManager dbm = new DBManager();
		PreparedStatement preparedStatement = null;
		BookUser bookUser = null;

		try {
			// データベースへ接続
			connection = dbm.getConnection();

			// SQLの準備
			preparedStatement = connection
					.prepareStatement("SELECT * FROM book_user WHERE book_user_id = ? AND password = ?");
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);

			// SQLの実行
			ResultSet rs = preparedStatement.executeQuery();

			// 検索結果をJavaBeansに保存
			if (rs.next()) {
				bookUser = new BookUser();
				bookUser.setBookUserId(rs.getInt("book_user_id"));
				bookUser.setBookUserName(rs.getString("book_user_name"));
				bookUser.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースとの接続を切断
			dbm.close(preparedStatement, connection);
		}
		return bookUser;
	}

}
