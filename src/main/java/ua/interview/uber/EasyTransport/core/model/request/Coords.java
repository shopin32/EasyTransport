package ua.interview.uber.EasyTransport.core.model;

/**
 * Class to contain users geolocation
 * @author pshopin
 *
 */
public class Coords 
{
	private long accuracy;
	
	private float latitude;
	
	private float longitude;
	
	public Coords(long accuracy, float latitude, float longitude)
	{
		this.accuracy = accuracy;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getAccuracy() {
		return accuracy;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}
}
