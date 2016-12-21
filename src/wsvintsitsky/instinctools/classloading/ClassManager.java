package wsvintsitsky.instinctools.classloading;

import java.io.IOException;
import java.net.URL;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import wsvintsitsky.instinctools.config.ConfigManager;

public class ClassManager {
	
	private final static ClassManager INSTANCE = new ClassManager();
	
	private static final Logger LOGGER = LogManager.getLogger(ClassManager.class);
	
	private ClassManager() {
	}
	
	public static ClassManager getInstace() {
		return INSTANCE;
	}
	
	public Class<?> getClassFromJar(JarTypeEnum jarType, String jarName) throws IOException {
		String classNameAttribute = ConfigManager.getInstance().getConfigBundle().getString("metaInfClass");
		Class<?> requiredClass = null;
		String requiredClassName = null;
		URL url = jarType.defineURL(jarName);
		JarClassLoader jarClassLoader = new JarClassLoader(url);
		try {
			requiredClassName = jarClassLoader.getMainAttributeValue(classNameAttribute);
			requiredClass = jarClassLoader.loadClass(requiredClassName);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Class not found: " + requiredClassName);
		}
		jarClassLoader.close();
		return requiredClass;
	}

}
