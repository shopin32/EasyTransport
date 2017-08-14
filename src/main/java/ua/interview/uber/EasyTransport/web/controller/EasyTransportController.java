package ua.interview.uber.EasyTransport.web.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.interview.uber.EasyTransport.core.model.request.TransportScheduleRequest;
import ua.interview.uber.EasyTransport.core.model.response.BussScheduleInfo;
import ua.interview.uber.EasyTransport.core.task.TransportSearch;

@Controller
@RequestMapping("/")
public class EasyTransportController {
	
	private static Logger logger = Logger.getLogger(EasyTransportController.class);
	
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
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	@ResponseBody 
    public List<BussScheduleInfo> process(@RequestBody TransportScheduleRequest request) throws InterruptedException, ExecutionException 
	{
		Future<List<BussScheduleInfo>> task = getExecutorService().submit(new TransportSearch(request));
		while(!task.isDone())
		{
			Thread.sleep(1);
		}
        return task.get();
    }
	
}
