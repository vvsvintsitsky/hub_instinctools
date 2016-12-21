package wsvintsitsky.instinctools.classloading;

import java.net.MalformedURLException;
import java.net.URL;
import wsvintsitsky.instinctools.config.ConfigManager;
import wsvintsitsky.instinctools.pathgenerator.IPathGenerator;
import wsvintsitsky.instinctools.pathgenerator.impl.ConsumerPathGenerator;
import wsvintsitsky.instinctools.pathgenerator.impl.ProducerPathGenerator;
import wsvintsitsky.instinctools.pathgenerator.impl.SharedResourcePathGenerator;

public enum JarTypeEnum {
	SHARED_RESOURCE {
		{
			pathGenerator = new SharedResourcePathGenerator();
		}
	},
	CONSUMER {
		{
			pathGenerator = new ConsumerPathGenerator();
		}
	},
	PRODUCER {
		{
			pathGenerator = new ProducerPathGenerator();
		}
	};
	IPathGenerator pathGenerator;
	public URL defineURL(String jarName) throws MalformedURLException {
		String jarPath = pathGenerator.generatePath() + jarName;
		String protocol = ConfigManager.getInstance().getConfigBundle().getString("protocol");
		URL url = new URL(protocol, "", jarPath);
		return url;
	}
}
