package jp.co.sss.book.bean;
/**
 *ジャンル情報を格納するJavabenas
 *@author 川端
*/
public class Genre {
	/**ジャンルIDの情報　*/
	private int genreId;
	/**ジャンル名の情報　*/
	private String genreName;
	/**
	 *ジャンルIDの取得
	 *
	 *@return ジャンルIDの値
	 */
	public int getGenreId() {
		return genreId;
	}
	/**
	 *ジャンル名の取得
	 *
	 *@return ジャンル名の文字列
	 */
	public String getGenreName() {
		return genreName;
	}
	/**
	 *ジャンルIDの設定
	 *
	 *@param genreId ジャンルIDに代入する値
	 */
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	/**
	 *ジャンル名の設定
	 *
	 *@param genreName ジャンル名に代入する値
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

}
