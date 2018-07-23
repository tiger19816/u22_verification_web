

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import verification01.entities.*;	// エンティティクラスのインポート。
import verification01.firebase.*;	// Firebase関連クラスのインポート。

/**
 * 「u22_android_verification」の「検証01」に対応したサーブレット。（検証用。）
 * 
 * Servlet implementation class Verification01JsonCreateServlet
 * 
 * @author Yuki Yoshida
 */
@WebServlet("/Verification01Servlet")
public class Verification01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * コンストラクタ。
     * 
     * @see HttpServlet#HttpServlet()
     */
    public Verification01Servlet() {
        super();
    }

	/**
	 * 実行内容。（検証用。）
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.createJson();
	}

}
