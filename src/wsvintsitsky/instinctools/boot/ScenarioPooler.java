package wsvintsitsky.instinctools.boot;

import java.lang.reflect.Constructor;
import wsvintsitsky.instinctools.resource.ISharedResource;
import wsvintsitsky.instinctools.resource.consuming.IConsumer;
import wsvintsitsky.instinctools.resource.consuming.IConsumingStrategy;
import wsvintsitsky.instinctools.resource.consuming.impl.ConsumingStrategy;
import wsvintsitsky.instinctools.resource.producing.IProducer;
import wsvintsitsky.instinctools.resource.producing.IProducingStrategy;
import wsvintsitsky.instinctools.resource.producing.impl.ProducingStrategy;

public class ScenarioPooler {

	public void poolScenario(Class<?> sharedResourceClass, Class<?> consumerClass, Class<?> producerClass, int consumerCount, int producerCount) {
		IConsumer iConsumer = null;
		IProducer iProducer = null;
		Thread consumerThread = null;
		Thread producerThread = null;
		try {
			ISharedResource iSharedResource = (ISharedResource) sharedResourceClass.newInstance();
			Constructor<?> consumerConstructor = consumerClass.getConstructor(ISharedResource.class,
					IConsumingStrategy.class);
			Constructor<?> producerConstructor = producerClass.getConstructor(ISharedResource.class,
					IProducingStrategy.class);
			
			for(int i = 0; i < consumerCount; i++) {
				iConsumer = (IConsumer) consumerConstructor.newInstance(iSharedResource, new ConsumingStrategy());
				consumerThread = new Thread(iConsumer);
				consumerThread.start();
			}
			
			for(int i = 0; i < producerCount; i++) {
				iProducer = (IProducer) producerConstructor.newInstance(iSharedResource, new ProducingStrategy());
				producerThread = new Thread(iProducer);
				producerThread.start();
			}
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}
	
	private IConsumer createConsumer(IConsumer consumer, Constructor<?> constructor, ISharedResource sharedResource) {
		try {
			consumer = (IConsumer) constructor.newInstance(sharedResource, new ConsumingStrategy());
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		return consumer;
	}
}
