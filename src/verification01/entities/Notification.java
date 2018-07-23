/**
 * 
 */
package verification01.entities;

import java.util.ArrayList;

/**
 * 通知内容のエンティティクラス。
 * 
 * @author Yuki Yoshida
 */
public class Notification {
	// ---フィールド。
	/**
	 * トークンIDの配列。
	 */
	private ArrayList<String> _tokens;
	/**
	 * 通知タイトル。
	 */
	private String _title;
	/**
	 * 小タイトル。
	 */
	private String _subTitle;
	/**
	 * 通知内容。
	 */
	private String _message;

	// ---コンストラクタ。
	/**
	 * コンストラクタ。
	 */
	public Notification() {
		this._tokens = new ArrayList<String>();
		this._tokens.set(0, "");
		this._title = "";
		this._message = "";
	}

	// ---パブリックメソッド。
	/**
	 * トークンが指定されているか確認するメソッド。
	 * 
	 * @return 特定の端末へ送信するか否か。
	 */
	public boolean isParticularTerminal() {
		if("".equals(this._tokens.get(0))) {
			return false;
		} else {
			return true;
		}
	}
	
	// ---アクセサメソッド。
	/**
	 * @param token トークンID。
	 */
	public void addToken(String token) {
		if("".equals(this._tokens.get(0))) {
			this._tokens.set(0, token);
		} else {
			this._tokens.add(token);
		}
	}
	/**
	 * @return 通知タイトル。
	 */
	public String getTitle() {
		return this._title;
	}
	/**
	 * @param title 通知タイトル。
	 */
	public void setTitle(String title) {
		this._title = title;
	}
	/**
	 * @return 小タイトル。
	 */
	public String getSubTitle() {
		return this._subTitle;
	}
	/**
	 * @param subTitle 小タイトル。
	 */
	public void setSubTitle(String subTitle) {
		this._subTitle = subTitle;
	}
	/**
	 * @return 通知内容。
	 */
	public String getMessage() {
		return this._message;
	}
	/**
	 * @param message 通知内容。
	 */
	public void setMessage(String message) {
		this._message = message;
	}
}
