package jp.co.sss.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * データベースへの接続、切断用クラス
 *
 * @author system_shared
 */
public class DBManager {
	//データベースと接続
	public Connection getConnection() {
		Connection con = null;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/xe_book_user");
			con = ds.getConnection();
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	//データベースとの接続を切断
	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(PreparedStatement ps, Connection con) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
