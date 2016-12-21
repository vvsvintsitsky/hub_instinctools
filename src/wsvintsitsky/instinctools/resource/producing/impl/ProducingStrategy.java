package wsvintsitsky.instinctools.resource.producing.impl;

import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import wsvintsitsky.instinctools.config.ConfigManager;
import wsvintsitsky.instinctools.resource.ISharedResource;
import wsvintsitsky.instinctools.resource.producing.IProducingStrategy;

public class ProducingStrategy implements IProducingStrategy {

	private final static Logger LOGGER = LogManager.getLogger(ProducingStrategy.class);
	
	private int producingValue;
	private int maxResourceValue;
	
	public ProducingStrategy() {
		producingValue = new Random().nextInt(5);
		if(producingValue == 0) {
			producingValue++;
		}
		maxResourceValue = Integer.parseInt(ConfigManager.getInstance().getConfigBundle().getString("maxResourceValue"));
	}
	
	@Override
	public Integer produce(ISharedResource resource) {
		if(resource.getValue() <= maxResourceValue - producingValue) {
			resource.increaseValue(producingValue);
			LOGGER.info("produced " + producingValue + " units, resource value = " + resource.getValue());
			return new Integer(resource.getValue());
		} else {
			LOGGER.info("couldn't produce " + producingValue + " units, resource value = " + resource.getValue());
			return null;
		}
	}

}
