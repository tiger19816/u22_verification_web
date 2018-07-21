package tool;

/**
 * 距離測定クラス。
 *
 * @author Taiga Hirai
 */
public class Distance {

	/**
	 * 距離を求めるメソッド.
	 *
	 * @param lat1 地点1の緯度。
	 * @param lng1 地点1の経度。
	 * @param lat2 地点2の緯度。
	 * @param lng2 地点2の経度。
	 * @param precision 。
	 * @return 距離。
	 */
	public static float getDistance(double lat1, double lng1, double lat2, double lng2) {
	    int R = 6371; // km
	    double lat = Math.toRadians(lat2 - lat1);
	    double lng = Math.toRadians(lng2 - lng1);
	    double A = Math.sin(lat / 2) * Math.sin(lat / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lng / 2) * Math.sin(lng / 2);
	    double C = 2 * Math.atan2(Math.sqrt(A), Math.sqrt(1 - A));
	    double decimalNo = Math.pow(10, 3);
	    double distance = R * C;
	    distance = Math.round(decimalNo * distance / 1) / decimalNo;
	    return (float) distance;
	}
}
