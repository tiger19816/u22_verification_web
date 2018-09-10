

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
		String token = request.getParameter("token");	
//		String token = "fZqdRJP3Q0s:APA91bHKT-yZFVIGDUemRjZpX8fiwWYeWo-LtZLlmg42P9BTcnLNFSkLfqgiWO9FiCH6v2JeOzVz6rD03k27pY88JmRpBelH_uyuqCIJFW9f4WWPeKcG3oGunwvMj21I0goHAa62F0s-shqWVODLqrHhSlz_NM1KrQ";
		System.out.println("トークン: " + token);
		
		MyMessage msg = new MyMessage("検証1", "これは、通知テストです。");
		msg.sendToToken(token); // Androidから受け取ったトークンを代入。
	}

	/**
	 * ぽすと。
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
