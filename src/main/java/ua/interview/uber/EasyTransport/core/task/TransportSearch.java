package ua.interview.uber.EasyTransport.core.task;

import java.util.List;
import java.util.concurrent.Callable;

import ua.interview.uber.EasyTransport.core.api.IBusFinder;
import ua.interview.uber.EasyTransport.core.factory.RetriveLocalTransportApi;
import ua.interview.uber.EasyTransport.core.model.request.TransportScheduleRequest;
import ua.interview.uber.EasyTransport.core.model.response.BusScheduleInfo;


/**
 * Callable service of finding busses to allow find the assynchroniously
 * @author pshopin
 *
 */
public class TransportSearch implements Callable<List<BusScheduleInfo>> 
{
	/**User request**/
	private TransportScheduleRequest _request;
	
	/**Concrete implementation of this interface that depends on location**/
	private IBusFinder _busFinder;
	
	public TransportSearch(TransportScheduleRequest request)
	{
		_request = request;
		_busFinder = RetriveLocalTransportApi.getBussFinderByLocation(request.getCoords());
	}

	@Override
	public List<BusScheduleInfo> call() throws Exception {
		return _busFinder.findBuses(_request);
	}
}
