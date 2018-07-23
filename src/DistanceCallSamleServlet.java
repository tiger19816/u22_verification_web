


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Distance;

/**
 * 2地点間の距離を測定するサンプルサーブレット。
 * DistanceクラスのgetDistanceを呼び出す。
 *
 * @author Taiga Hirai
 */
@WebServlet("/DistanceCallSamleServlet")
public class DistanceCallSamleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistanceCallSamleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//地点1の緯度・経度(東梅田駅)
		float lat1 = Float.parseFloat("34.700940");
		float lng1 = Float.parseFloat("135.499657");

		//地点2の緯度・経度(HAL大阪)
		float lat2 = Float.parseFloat("34.699884");
		float lng2 = Float.parseFloat("135.493027");

		//2地点間の距離を測定。
		float range = Distance.getDistance(lat1, lng1, lat2, lng2);

		//距離をメートルにする。
		range *= 1000;

		System.out.println("距離（メートル）" + range);

		//エリアを指定する（メートル）
		float area = Float.parseFloat("800");

		//2地点の距離がエリア範囲内か判定。
		if(range <= area){
			System.out.println("エリア内");
		}
		else {
			System.out.println("エリア外");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
