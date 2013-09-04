package de.philipphock.android.servicetest;

public class ServiceTaskService extends GenericConsumerService{

	
	@Override
	public ServiceTask newInstance(GenericConsumerService service) {
		return new ServiceTask(service);
	}



}
