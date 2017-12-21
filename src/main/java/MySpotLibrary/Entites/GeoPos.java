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
	private Long id;

	private double latitude;

	private double Longitude;

	public GeoPos() {
	}

	public GeoPos(double latitude, double Longitude) {
		this.latitude = latitude;
		this.Longitude = Longitude;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double Longitude) {
		this.Longitude = Longitude;
	}
}
