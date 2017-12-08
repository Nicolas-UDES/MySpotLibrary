package MySpotLibrary.BLL;

import java.util.List;

public class LatLng {

	public static double distance(MySpotLibrary.Entites.LatLng latLng1, MySpotLibrary.Entites.LatLng latLng2) {
		double earthRadius = 3958.75;
		double latDiff = Math.toRadians(latLng1.getLatitude() - latLng2.getLatitude());
		double lngDiff = Math.toRadians(latLng1.getLongitude() - latLng2.getLongitude());
		double a = Math.sin(latDiff /2) * Math.sin(latDiff /2) +
				Math.cos(Math.toRadians(latLng2.getLatitude())) * Math.cos(Math.toRadians(latLng1.getLatitude())) *
						Math.sin(lngDiff /2) * Math.sin(lngDiff /2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double distance = earthRadius * c;

		int meterConversion = 1609;

		return distance * meterConversion;
	}

	public static boolean isPointInPolygon(MySpotLibrary.Entites.LatLng point, List<MySpotLibrary.Entites.LatLng> points) {
		int i;
		int j;
		boolean result = false;
		for (i = 0, j = points.size() - 1; i < points.size(); j = i++) {
			if ((points.get(i).getLongitude() > point.getLongitude()) != (points.get(j).getLongitude() > point.getLongitude()) &&
					(point.getLatitude() < (points.get(j).getLatitude() - points.get(i).getLatitude()) * (point.getLongitude() - points.get(i).getLongitude()) / (points.get(j).getLongitude()-points.get(i).getLongitude()) + points.get(i).getLatitude())) {
				result = !result;
			}
		}
		return result;
	}

	private static boolean rayCastIntersect(MySpotLibrary.Entites.LatLng point, MySpotLibrary.Entites.LatLng vertA, MySpotLibrary.Entites.LatLng vertB) {

		double aY = vertA.getLatitude();
		double bY = vertB.getLatitude();
		double aX = vertA.getLongitude();
		double bX = vertB.getLongitude();
		double pY = point.getLatitude();
		double pX = point.getLongitude();

		if ((aY > pY && bY > pY) || (aY < pY && bY < pY)
				|| (aX < pX && bX < pX)) {
			return false; // a and b can't both be above or below pt.y, and a or
			// b must be east of pt.x
		}

		double m = (aY - bY) / (aX - bX); // Rise over run
		double bee = (-aX) * m + aY; // y = mx + b
		double x = (pY - bee) / m; // algebra is neat!

		return x > pX;
	}
}
