package ua.interview.uber.EasyTransport.core.api.san_francisco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.xml.crypto.Data;

import ua.interview.uber.EasyTransport.core.api.IBusFinder;
import ua.interview.uber.EasyTransport.core.model.request.TransportScheduleRequest;
import ua.interview.uber.EasyTransport.core.model.response.BusScheduleInfo;

public class SanFranciscoBusFinder implements IBusFinder
{
	Random r = new Random();
	
	
	@Override
	public List<BusScheduleInfo> findBuses(TransportScheduleRequest request) throws InterruptedException 
	{
		List<BusScheduleInfo> result = new ArrayList<>();
		for(int i = 0; i < 1000 + r.nextInt(100);i++)
		{
			result.add(new BusScheduleInfo("1", "", "", new Date().getTime()));
		}
		return result;
	}

}
