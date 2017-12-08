package MySpotLibrary.Entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class GeoPos implements Serializable {

	public final static int PRECISION = 100000;

	@Id
	@GeneratedValue
	private long id;

	private double latitude;

	private double longitude;

	public GeoPos() {
	}

	public GeoPos(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof GeoPos)) {
			return false;
		}

		return equals((GeoPos)obj);
	}

	public boolean equals(GeoPos geoPos) {
		return (int)(getLatitude() * PRECISION) == (int)(geoPos.getLatitude() * PRECISION) &&
				(int)(getLongitude() * PRECISION) == (int)(geoPos.getLongitude() * PRECISION);
	}

	@Override
	public int hashCode() {
		return new Integer((int) (getLatitude() * PRECISION)).hashCode() ^
				new Integer((int) (getLongitude() * PRECISION)).hashCode();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
