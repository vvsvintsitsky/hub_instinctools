package wsvintsitsky.instinctools.resource.consuming.impl;

import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import wsvintsitsky.instinctools.config.ConfigManager;
import wsvintsitsky.instinctools.resource.ISharedResource;
import wsvintsitsky.instinctools.resource.consuming.IConsumingStrategy;

public class ConsumingStrategy implements IConsumingStrategy {

	private final static Logger LOGGER = LogManager.getLogger(ConsumingStrategy.class);
	
	private int consumingValue;
	private int minResourceValue;
	
	public ConsumingStrategy() {
		consumingValue = new Random().nextInt(5);
		if(consumingValue == 0) {
			consumingValue++;
		}
		minResourceValue = Integer.parseInt(ConfigManager.getInstance().getConfigBundle().getString("minResourceValue"));
	}
	
	@Override
	public int consume(ISharedResource resource) {
		if(resource.getValue() >= minResourceValue + consumingValue) {
			resource.decreaseValue(consumingValue);
			LOGGER.info("consumed " + consumingValue + " units, resource value = " + resource.getValue());
			return resource.getValue();
		} else {
			LOGGER.info("couldn't consume " + consumingValue + " units, resource value = " + resource.getValue());
			return -1;
		}
	}

}
