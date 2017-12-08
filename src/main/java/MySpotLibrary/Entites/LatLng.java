package MySpotLibrary.Entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class LatLng implements Serializable {

	public final static int PRECISION = 100000;

	@Id
	@GeneratedValue
	private long id;

	private double latitude;

	private double longitude;

	public LatLng() {
	}

	public LatLng(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof LatLng)) {
			return false;
		}

		return equals((LatLng)obj);
	}

	public boolean equals(LatLng latLng) {
		return (int)(getLatitude() * PRECISION) == (int)(latLng.getLatitude() * PRECISION) &&
				(int)(getLongitude() * PRECISION) == (int)(latLng.getLongitude() * PRECISION);
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
