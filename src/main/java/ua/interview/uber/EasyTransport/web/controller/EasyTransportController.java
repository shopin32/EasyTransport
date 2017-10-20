package ua.interview.uber.EasyTransport.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.interview.uber.EasyTransport.core.model.request.Coords;
import ua.interview.uber.EasyTransport.core.model.request.TransportScheduleRequest;
import ua.interview.uber.EasyTransport.core.model.response.BusScheduleInfo;
import ua.interview.uber.EasyTransport.core.task.TransportSearch;

@Controller
@RequestMapping("/")
public class EasyTransportController {
	
//	private static Logger logger = Logger.getLogger(EasyTransportController.class);
	
	/**
	 * For performance issues lets create threadpool with number
	 * of threads equal to cores number
	 */
	private static int cores = Runtime.getRuntime().availableProcessors();
	
	private ExecutorService _executor;
	
	/**
	 * Singleton of executor for all our Callable tasks for asynchronious work
	 * @return
	 */
	public ExecutorService getExecutorService()
	{
		if(_executor == null)
		{
			synchronized (ExecutorService.class) 
			{
				if(_executor == null)
				{
					_executor = Executors.newFixedThreadPool(cores);
				}
			}
		}
		return _executor;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
    public @ResponseBody long process(@RequestParam("numberOfTasks") final int numberOfTasks, Model map) throws InterruptedException, ExecutionException 
	{
		List<Future<List<BusScheduleInfo>>> result = new ArrayList<>();
		for(int i = 0; i < numberOfTasks; i++)
		{
			result.add(getExecutorService().submit(new TransportSearch(new TransportScheduleRequest(new Coords(12, 13, 14),  null,  null, null, 0L))));
		}
		long res = 0;
		for(Future<List<BusScheduleInfo>> fut : result)
        {
                    try {
                    	res += fut.get().size();
                    } catch (InterruptedException e) {                                               
                                e.printStackTrace();
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                    } catch (ExecutionException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                    }
        } 
		return res;
    }
}
