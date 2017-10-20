package ua.interview.uber.EasyTransport.core.factory;

import java.util.HashMap;
import java.util.Map; 

import ua.interview.uber.EasyTransport.core.api.IBusFinder;
import ua.interview.uber.EasyTransport.core.api.san_francisco.SanFranciscoBusFinder;
import ua.interview.uber.EasyTransport.core.model.request.Coords;

public class RetriveLocalTransportApi 
{
	
	public static Map<String, IBusFinder> locationServiceMap = new HashMap<>();
	
	static
	{
		locationServiceMap.put("SanFrancisco", new SanFranciscoBusFinder());
	}
	
	public static IBusFinder getBussFinderByLocation(Coords coords)
	{
		return locationServiceMap.get(getCityName(coords));
	}
	
	public static String getCityName(Coords coords)
	{
		//TODO: 
		return "SanFrancisco";
	}
}
