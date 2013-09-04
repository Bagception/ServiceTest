package de.philipphock.android.servicetest;

public class ServiceTaskService extends GenericConsumerService<ServiceTask>{

	
	@Override
	public ServiceTask newInstance(GenericConsumerService<ServiceTask> service) {
		return new ServiceTask(service);
	}



}
