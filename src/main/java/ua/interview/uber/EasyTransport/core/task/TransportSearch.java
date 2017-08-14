package ua.interview.uber.EasyTransport.core.task;

import java.util.List;
import java.util.concurrent.Callable;

import ua.interview.uber.EasyTransport.core.api.IBussFinder;
import ua.interview.uber.EasyTransport.core.factory.RetriveLocalTransportApi;
import ua.interview.uber.EasyTransport.core.model.request.TransportScheduleRequest;
import ua.interview.uber.EasyTransport.core.model.response.BussScheduleInfo;


/**
 * Callable service of finding busses to allow find the assynchroniously
 * @author pshopin
 *
 */
public class TransportSearch implements Callable<List<BussScheduleInfo>> 
{
	/**User request**/
	private TransportScheduleRequest _request;
	
	/**Concrete implementation of this interface that depends on location**/
	private IBussFinder _bussFinder;
	
	public TransportSearch(TransportScheduleRequest request)
	{
		_request = request;
		_bussFinder = RetriveLocalTransportApi.getBussFinderByLocation(request.getCoords());
	}

	@Override
	public List<BussScheduleInfo> call() throws Exception {
		return _bussFinder.findBusses(_request);
	}
}
