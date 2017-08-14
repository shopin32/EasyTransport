package ua.interview.uber.EasyTransport.core.factory;

import java.util.Map;

import ua.interview.uber.EasyTransport.core.api.IBussFinder;
import ua.interview.uber.EasyTransport.core.model.request.Coords;

public class RetriveLocalTransportApi 
{
	
	public static Map<String, IBussFinder> locationServiceMap;
	
	static
	{
		//TODO: should register services by location : dependancy injection, hardcode here etc
	}
	
	public static IBussFinder getBussFinderByLocation(Coords coords)
	{
		return locationServiceMap.get(getCityName(coords));
	}
	
	public static String getCityName(Coords coords)
	{
		//TODO: 
		return "Kyiv";
	}
}
