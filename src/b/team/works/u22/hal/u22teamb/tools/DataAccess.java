package b.team.works.u22.hal.u22teamb.tools;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Female;

/**
 * SQL文クラス
 *
 * @author ohs60224
 *
 */
public class DataAccess extends Dao{
	/**
	 * フィールド。
	 */
	private String _sql;

	/**
	 * コンストラクタ。
	 *
	 * @throws Exception 全ての例外。
	 */
	public DataAccess() throws Exception, SQLException {
		super();
	}

	public void DataAccessClose() throws Exception, SQLException {
		super.close();
	}

//基本構文+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * SELECT文
	 *
	 * @param table 抽出先のテーブル名
	 * @throws Exception
	 * @throws SQLException
	 */
	public void Select(String table) throws Exception, SQLException {
		try {
			this._sql = "SELECT * FROM " + table + ";";
			this.pst = this.cn.prepareStatement(this._sql);
			this.rs = this.pst.executeQuery(this._sql);
			System.out.println(_sql);
		}
		catch(Exception e){
			e.printStackTrace();
            throw e;
		}
	}

	/**
	 * WHERE付きのSELECT文
	 *
	 * @param table 抽出先のテーブル名
	 * @param where 条件
	 * @throws Exception
	 * @throws SQLException
	 */
	public void SelectWhere(String table, String where) throws Exception, SQLException {
		try {
			this._sql = "SELECT * FROM " + table + " WHERE " + where + ";";
			System.out.println(_sql);
			this.pst = this.cn.prepareStatement(this._sql);
			this.rs = this.pst.executeQuery(this._sql);
		}
		catch(Exception e){
			e.printStackTrace();
            throw e;
		}
	}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


//抽出系+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	//妻の情報を抽出
	public ArrayList<Female> FemaleSelect() throws Exception, SQLException {
		this.Select("female");
		ArrayList<Female> result = new ArrayList<Female>();
		try {
			Female f = null;
			while(rs.next()) {
				f = new Female();
				f.setId( rs.getInt("id") );
				f.setName( rs.getString("name") );
				f.setBirthday( rs.getString("birthday") );
				f.setPassword( rs.getString("password") );
				f.setCardNumber( rs.getString("card_number") );
				f.setCardExpirationDate( rs.getString("card_expiration_date") );
				f.setCardSecurityCode( rs.getString("card_security_code") );
				f.setCardNominee( rs.getString("card_nominee") );
				f.setPointLatitude( rs.getString("point_latitude") );
				f.setPointLongitude( rs.getString("point_longitude") );
				f.setMaleId( rs.getInt("male_id") );

				result.add(f);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}

	//妻の情報を抽出（主キー検索）
		public ArrayList<Female> FemaleSelect(String id) throws Exception, SQLException {
			String where = "id = " + id;
			this.SelectWhere("female", where);
			ArrayList<Female> result = new ArrayList<Female>();
			try {
				Female f = null;
				while(rs.next()) {
					f = new Female();
					f.setId( rs.getInt("id") );
					f.setName( rs.getString("name") );
					f.setBirthday( rs.getString("birthday") );
					f.setPassword( rs.getString("password") );
					f.setCardNumber( rs.getString("card_number") );
					f.setCardExpirationDate( rs.getString("card_expiration_date") );
					f.setCardSecurityCode( rs.getString("card_security_code") );
					f.setCardNominee( rs.getString("card_nominee") );
					f.setPointLatitude( rs.getString("point_latitude") );
					f.setPointLongitude( rs.getString("point_longitude") );
					f.setMaleId( rs.getInt("male_id") );

					result.add(f);
				}
				return result;
			}
			catch(Exception e) {
				e.printStackTrace();
	            throw e;
			}
		}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

}
