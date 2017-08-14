package ua.interview.uber.EasyTransport.core.model.response;

/**
 * Class to hold the response about bus departures
 * @author pshopin
 *
 */
public class BussScheduleInfo 
{
	/**Bus iudentifier: number, letter etc**/
	private String busIdentifier; 
	
	/**Bus direction**/
	private String busDirection;
	
	/**Bus detination**/
	private String busDestination;
	
	/**Timestamp of departure (should be later than timestamp requested)**/
	private long departureTimestamp;
	
	public BussScheduleInfo(String busIdentifier, String busDirection, String busDestination, long departureTimestamp)
	{
		this.busIdentifier = busIdentifier;
		this.busDirection = busDirection;
		this.busDestination = busDestination;
		this.departureTimestamp = departureTimestamp;
	}

	public String getBusIdentifier() {
		return busIdentifier;
	}

	public String getBusDirection() {
		return busDirection;
	}

	public String getBusDestination() {
		return busDestination;
	}

	public long getDepartureTimestamp() {
		return departureTimestamp;
	}
}
