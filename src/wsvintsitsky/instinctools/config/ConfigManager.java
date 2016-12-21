package wsvintsitsky.instinctools.config;

import java.util.ResourceBundle;

public class ConfigManager {

	private final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("classloading-config");
	
	private static final ConfigManager INSTANCE = new ConfigManager();
	
	private ConfigManager() {
	}
	
	public static ConfigManager getInstance() {
		return INSTANCE;
	}
	
	public ResourceBundle getConfigBundle() {
		return RESOURCE_BUNDLE;
	}
}
