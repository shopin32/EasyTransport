package ua.interview.uber.EasyTransport.core.model.request;

/**
 * Container to hold user request for this service
 * @author pshopin
 *
 */
public class TransportScheduleRequest 
{
	/**Geolocation**/
	private Coords coords;
	
	/**Buses with certain direction user can specify**/
	private String direction; 
	
	/**Bus destination that user is interested in**/
	private String destination;
	
	/**Bus number, letter etc**/
	private String busIdentifier;
	
	/**Timestemp of request**/
	private long timestamp;
	
	public TransportScheduleRequest(Coords coords, String direction, String destination, String busIdentifier, long timestamp)
	{
		this.coords = coords;
		this.direction = direction;
		this.destination = destination;
		this.busIdentifier = busIdentifier;
		this.timestamp = timestamp;
	}

	public Coords getCoords() {
		return coords;
	}

	public String getDirection() {
		return direction;
	}
	

	public String getDestination() {
		return destination;
	}

	public String getBusIdentifier() {
		return busIdentifier;
	}

	public long getTimestamp() {
		return timestamp;
	}
}
