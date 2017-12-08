package MySpotLibrary.BLL;

import MySpotLibrary.Entites.GeoPos;

import java.util.List;

public class LatLngBLL {

	public static double distance(GeoPos geoPos1, GeoPos geoPos2) {
		double earthRadius = 3958.75;
		double latDiff = Math.toRadians(geoPos1.getLatitude() - geoPos2.getLatitude());
		double lngDiff = Math.toRadians(geoPos1.getLongitude() - geoPos2.getLongitude());
		double a = Math.sin(latDiff /2) * Math.sin(latDiff /2) +
				Math.cos(Math.toRadians(geoPos2.getLatitude())) * Math.cos(Math.toRadians(geoPos1.getLatitude())) *
						Math.sin(lngDiff /2) * Math.sin(lngDiff /2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double distance = earthRadius * c;

		int meterConversion = 1609;

		return distance * meterConversion;
	}

	public static boolean isPointInPolygon(GeoPos point, List<GeoPos> polygon) {
		int i;
		double angle=0;
		GeoPos point1 = new GeoPos(), point2 = new GeoPos();


		for (i=0; i < polygon.size(); i++) {
			point1.setLatitude(polygon.get(i).getLatitude() - point.getLatitude());
			point1.setLongitude(polygon.get(i).getLongitude() - point.getLongitude());
			point2.setLatitude(polygon.get((i+1)% polygon.size()).getLatitude() - point.getLatitude());
			point2.setLongitude(polygon.get((i+1)% polygon.size()).getLongitude() - point.getLongitude());
			angle += angle2D(point1.getLatitude(),point1.getLongitude(),point2.getLatitude(),point2.getLongitude());
		}

		return Math.abs(angle) >= Math.PI;
	}

	/*
	   Return the angle between two vectors on a plane
	   The angle is from vector 1 to vector 2, positive anticlockwise
	   The result is between -pi -> pi
	*/
	public static double angle2D(double x1, double y1, double x2, double y2)
	{
		double dtheta, theta1, theta2;

		theta1 = Math.atan2(y1,x1);
		theta2 = Math.atan2(y2,x2);
		dtheta = theta2 - theta1;
		while (dtheta > Math.PI)
			dtheta -= Math.PI * 2;
		while (dtheta < -Math.PI)
			dtheta += Math.PI * 2;

		return(dtheta);
	}
}
