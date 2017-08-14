This is a sceleton for the application: 

I have just designed how this should be working: 

The design: 
1)	For different places(cities, countries) we can register different services of retrieving buss schedules, 
	so we need IBussFinder interface and we can implement as many services as we want for any country we can 
	deploy our service to.
2)  The next step is the client side application , we can  make it as easy as possible because we can allow 	to specify the particular bus number that he or she is looking forward, destination / direction, and 
	other info we can grab directly from browsers: coords of geolocation and timestamp from the device;
3)  On the backend we will have Callable tasks that we be executed in parallel with the help of executor that 	has number of threads equal to number of cores.(ideally we need to iplement our framework of enqueuing 
	all of the requests and process them like threadpool; 


