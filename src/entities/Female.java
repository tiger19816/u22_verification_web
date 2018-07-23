package entities;

/**
 * 妻情報のエンティティクラス
 *
 * @author ohs60224
 *
 */
public class Female {
	/**
	 * フィールド
	 */
	private int _id;
	private String _name;
	private String _birthday;
	private String _password;
	private String _cardNumber;
	private String _cardExpirationDate;
	private String _cardSecurityCode;
	private String _cardNominee;
	private String _pointLatitude;
	private String _pointLongitude;
	private int _maleId; //※夫の主キー（あとで夫のエンティティクラスと連携）

	/**
	 * コンストラクタ
	 */
	public Female() {
		this._id = 0;
		this._birthday = "";
		this._password = "";
		this._cardNumber = "";
		this._cardExpirationDate = "";
		this._cardSecurityCode = "";
		this._cardNominee = "";
		this._pointLatitude = "";
		this._pointLongitude = "";
	}

//セッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 妻IDのセッター
	 * @param id 妻ID
	 */
	public void setId(int id) {
		this._id = id;
	}
	/**
	 * 妻IDのセッター
	 * @param id 妻ID
	 */
	public void setId(String id) {
		this._id = Integer.valueOf(id);
	}
	/**
	 * 妻名のセッター
	 * @param name 妻名
	 */
	public void setName(String name) {
		this._name = name;
	}
	/**
	 * 妻誕生日のセッター
	 * @param birthday 妻誕生日
	 */
	public void setBirthday(String birthday) {
		this._birthday = birthday;
	}
	/**
	 * 妻パスワードのセッター
	 * @param password 妻パスワード
	 */
	public void setPassword(String password) {
		this._password = password;
	}
	/**
	 * 妻カードナンバーのセッター
	 * @param cardNumber 妻カードナンバー
	 */
	public void setCardNumber(String cardNumber) {
		this._cardNumber = cardNumber;
	}
	/**
	 * 妻有効期限のセッター
	 * @param cardExpirationDate 妻有効期限
	 */
	public void setCardExpirationDate(String cardExpirationDate) {
		this._cardExpirationDate = cardExpirationDate;
	}
	/**
	 * 妻セキュリティコードのセッター
	 * @param cardSecurityCode 妻セキュリティコード
	 */
	public void setCardSecurityCode(String cardSecurityCode) {
		this._cardSecurityCode = cardSecurityCode;
	}
	/**
	 * 妻名義名のセッター
	 * @param cardNominee 妻名義名のセッター
	 */
	public void setCardNominee(String cardNominee) {
		this._cardNominee = cardNominee;
	}
	/**
	 * 妻登録地（緯度）のセッター
	 * @param pointLatitude 妻登録地（緯度）
	 */
	public void setPointLatitude(String pointLatitude) {
		this._pointLatitude = pointLatitude;
	}
	/**
	 * 妻登録地（緯度）のセッター
	 * @param pointLatitude 妻登録地（緯度）
	 */
	public void setPointLatitude(Double pointLatitude) {
		this._pointLatitude = Double.toString(pointLatitude);
	}

	/**
	 * 妻登録地（経度）のセッター
	 * @param pointLongitude 妻登録地（経度）
	 */
	public void setPointLongitude(String pointLongitude) {
		this._pointLongitude = pointLongitude;
	}
	/**
	 * 妻登録地（経度）のセッター
	 * @param pointLongitude 妻登録地（経度）
	 */
	public void setPointLongitude(Double pointLongitude) {
		this._pointLongitude = Double.toString(pointLongitude);
	}
	/**
	 * 夫IDのセッター
	 * @param maleId 夫ID
	 */
	public void setMaleId(int maleId) {
		this._maleId = maleId;
	}
	/**
	 * 夫IDのセッター
	 * @param maleId 夫ID
	 */
	public void setMaleId(String maleId) {
		this._maleId = Integer.valueOf(maleId);
	}

//ゲッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 妻IDのゲッター
	 * @return 妻IDのゲッター
	 */
	public int getId() {
		return this._id;
	}
	/**
	 * 妻名のゲッター
	 * @return 妻名のゲッター
	 */
	public String getName() {
		return this._name;
	}
	/**
	 * 妻誕生日のゲッター
	 * @return 妻誕生日
	 */
	public String getBirthday() {
		return this._birthday;
	}
	/**
	 * 妻パスワードのゲッター
	 * @return 妻パスワード
	 */
	public String getPassword() {
		return this._password;
	}
	/**
	 * 妻カードナンバーのゲッター
	 * @return 妻カードナンバー
	 */
	public String getCardNumber() {
		return this._cardNumber;
	}
	/**
	 * 妻有効期限のゲッター
	 * @return 妻有効期限
	 */
	public String getCardExpirationDate() {
		return this._cardExpirationDate;
	}
	/**
	 * 妻セキュリティコードのゲッター
	 * @return 妻セキュリティコード
	 */
	public String getCardSecurityCode() {
		return this._cardSecurityCode;
	}
	/**
	 * 妻名義名のゲッター
	 * @return 妻名義名
	 */
	public String getCardNominee() {
		return this._cardNominee;
	}
	/**
	 * 妻登録地（緯度）のゲッター
	 * @return 妻登録地（緯度）
	 */
	public String getPointLatitude() {
		return this._pointLatitude;
	}
	/**
	 * 妻登録地（経度）のゲッター
	 * @return 妻登録地（経度）
	 */
	public String getPointLongitude() {
		return this._pointLongitude;
	}
	/**
	 * 夫IDのゲッター
	 * @return 夫ID
	 */
	public int getMaleId() {
		return this._maleId;
	}
}
