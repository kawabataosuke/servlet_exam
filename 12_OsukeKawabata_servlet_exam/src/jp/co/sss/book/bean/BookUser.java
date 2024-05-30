package jp.co.sss.book.bean;

/**
 * ユーザ情報Bean
 *
 * @author system_shared
 */
public class BookUser {
    /** ユーザID */
    private int bookUserId;

    /** ユーザ名 */
    private String bookUserName;

    /** パスワード */
    private String password;

    /**
     * ユーザIDを取得
     *
     * @return ユーザID
     */
    public int getBookUserId() {
        return bookUserId;
    }

    /**
     * ユーザIDを保存
     *
     * @param bookUserId ユーザID
     */
    public void setBookUserId(int bookUserId) {
        this.bookUserId = bookUserId;
    }

    /**
     * ユーザ名を取得
     *
     * @return ユーザ名
     */
    public String getBookUserName() {
        return bookUserName;
    }

    /**
     * ユーザ名を保存
     *
     * @param bookUserName ユーザ名
     */
    public void setBookUserName(String bookUserName) {
        this.bookUserName = bookUserName;
    }

    /**
     * パスワードを取得
     *
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを保存
     *
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
