package jp.co.sss.book.bean;

/**
 *書籍情報を格納するJavabeans
 *@author 川端
 */
public class BookListBean {
	/**書籍IDの情報　*/
	private int bookId;
	/**書籍名の情報　*/
	private String bookName;
	/**筆者名の情報　*/
	private String author;
	/**発行日の情報　*/
	private String date;
	/**在庫の情報　*/
	private int stock;
	/**ジャンルクラスの情報　*/
	private Genre genre;
	
	/**
	 *書籍IDの取得
	 *
	 *@return 書籍IDの値
	 */
	public int getBookId() {
		return bookId;
	}
	/**
	 *書籍名の取得
	 *
	 *@return 書籍名の文字列
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 *著者名の取得
	 *
	 *@return 著者名の文字列
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 *発行日の取得
	 *
	 *@return 発行日の文字列
	 */
	public String getDate() {
		return date;
	}
	/**
	 *在庫数の取得
	 *
	 *@return 在庫数の値
	 */
	public int getStock() {
		return stock;
	}
	/**
	 *ジャンルクラスの情報の取得
	 *
	 *@return ジャンルクラスに格納されている値
	 */
	public Genre getGenre() {
		return genre;
	}
	/**
	 *書籍IDの設定
	 *
	 *@param bookId 書籍IDに代入する値
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	/**
	 *書籍名の設定
	 *
	 *@param bookName 書籍名に代入する文字列
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 *著者名の設定
	 *
	 *@param author 著者名に代入する値
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 *発行日の設定
	 *
	 *@param date 発行日に代入する文字列
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 *在庫数の設定
	 *
	 *@param stock 在庫数に代入する値
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 *ジャンルクラスの設定
	 *
	 *@param genre ジャンルクラスに代入する値
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
	
}
