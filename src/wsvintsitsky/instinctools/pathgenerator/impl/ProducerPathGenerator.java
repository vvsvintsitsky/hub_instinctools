package wsvintsitsky.instinctools.pathgenerator.impl;

import java.io.File;

import wsvintsitsky.instinctools.config.ConfigManager;
import wsvintsitsky.instinctools.pathgenerator.IPathGenerator;

public class ProducerPathGenerator implements IPathGenerator {

	@Override
	public String generatePath() {
		return ConfigManager.getInstance().getConfigBundle().getString("path") + File.separator
				+ ConfigManager.getInstance().getConfigBundle().getString("producerFolder") + File.separator;
	}

}
