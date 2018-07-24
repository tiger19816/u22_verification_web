package verification01.firebase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * PUSH通知を送信するクラス。
 * 
 * @author Yuki Yoshida
 */
public class MyMessage {
	/**
	 * サーバーキー。
	 * Firebaseコンソール → プロジェクトの設定 → クラウドメッセージング → サーバーキー。
	 */
	private String SERVER_KEY = "AAAA1hAFF08:APA91bEO_kOwJgxCPOFDP9By4x_ExZ0XjPBHVOcNrdmqtvrW5xj-UiVJ5bS2wGdJg1N3EWOQ2F2XqJkpiZ1sRia28G1F4i7cuJuSqLy8HTvHM7J0WKbCeT-GwrbH3KtDh5Eme283uxdI9LGRzIQlMO93fJSUSYo5Tg";
	/**
	 * リクエスト先エンドポイント。
	 */
	private final String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
	/**
	 * JSONオブジェクト。
	 */
	private JSONObject _object;
	
	public MyMessage(String title, String message) throws JSONException {
	    this._object = new JSONObject();
	    JSONObject data = new JSONObject();
	    data.put("title", title);	// タイトル。
	    data.put("text", message);	// 内容。
	    this._object.put("notification", data);	// 上記２つをnotification内に書き込み。
	    this._object.put("priority", "high");	// 優先度:高。（アプリを終了しても通知。）
	}
	
	/**
	 * トピック単位で送信するメソッド。
	 * 
	 * @param topic トピックID。
	 * @throws JSONException JSON発行時の例外。
	 * @throws IOException 入出力に関する例外。
	 */
	public void sendToTopic(String topic) throws JSONException, IOException {
	    this._object.put("condition", "'"+topic+"' in topics");
	    this.sendPushNotification(true);
	}
	
	/**
	 * 複数の特定端末へ送信するメソッド。
	 * 
	 * @param mobileTokens 複数のトークンID。
	 * @throws JSONException JSON発行時の例外。
	 * @throws IOException 入出力に関する例外。
	 */
	public void sendToGroup(JSONArray mobileTokens) throws JSONException, IOException {
	    this._object.put("registration_ids", mobileTokens);
	    this.sendPushNotification(false);
	}
	
	/**
	 * 単一の特定端末へ送信するメソッド。
	 * 
	 * @param token トークンID。
	 * @throws JSONException JSON発行時の例外。
	 * @throws IOException 入出力に関する例外。
	 */
	public void sendToToken(String token) throws JSONException, IOException {
	    this._object.put("to", token);
	    this.sendPushNotification(false);
	}
	
	/**
	 * 通知を送信するメソッド。
	 * 
	 * @param toTopic トピック単位での送信か否か。
	 * @throws JSONException JSON発行時の例外。
	 * @throws IOException 入出力に関する例外。
	 */
    private void sendPushNotification(boolean toTopic) throws JSONException, IOException {
        URL url = new URL(API_URL_FCM);
        HttpURLConnection cnct = (HttpURLConnection) url.openConnection();

        cnct.setUseCaches(false);
        cnct.setDoInput(true);
        cnct.setDoOutput(true);
        cnct.setRequestMethod("POST");

        cnct.setRequestProperty("Content-Type", "application/json");
        cnct.setRequestProperty("Accept", "application/json");
        cnct.setRequestProperty("Authorization", "key=" + SERVER_KEY);

//        System.out.println(this._object.toString());

        OutputStreamWriter wr = new OutputStreamWriter(cnct.getOutputStream());
        wr.write(this._object.toString());
        wr.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader( (cnct.getInputStream())));

        String output;
        StringBuilder builder = new StringBuilder();
        while ((output = br.readLine()) != null) {
            builder.append(output);
        }
//        System.out.println(builder);
        String result = builder.toString();

        JSONObject obj = new JSONObject(result);
        
//        if(toTopic){
//            if(obj.has("message_id")){
//                return  "SUCCESS";
//            }
//        } else {
//           int success = Integer.parseInt(obj.getString("success"));
//           if (success > 0) {
//               return "SUCCESS";
//           }
//        }

    }
}
