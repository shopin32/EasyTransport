package ua.interview.uber.EasyTransport.core.api;

import java.util.List;

import ua.interview.uber.EasyTransport.core.model.request.TransportScheduleRequest;
import ua.interview.uber.EasyTransport.core.model.response.BusScheduleInfo;

/**
 * We predict that in each region there will be it is own service 
 * of providing info about bus schedule, so at any time we can add
 * new service for any location. 
 * @author pshopin
 *
 */
public interface IBusFinder 
{
	/**
	 * Finds the busses schedule in some location
	 * @param request - request containing timestamp and location
	 * @return - list of busses with info of departure times
	 */
	List<BusScheduleInfo> findBuses(TransportScheduleRequest request);
}
