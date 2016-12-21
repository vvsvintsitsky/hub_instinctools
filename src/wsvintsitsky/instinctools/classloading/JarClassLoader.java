package wsvintsitsky.instinctools.classloading;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;

public class JarClassLoader extends URLClassLoader {

	private URL url;

	public JarClassLoader(URL url) {
		super(new URL[] { url });
		this.url = url;
	}

	public String getMainClassName() throws IOException {
		return getMainAttributeValue(Attributes.Name.MAIN_CLASS.toString());
	}

	public String getMainAttributeValue(String attribute) throws IOException {
		URL u = new URL("jar", "", url + "!/");
		JarURLConnection uc = (JarURLConnection) u.openConnection();
		Attributes attr = uc.getMainAttributes();
		return attr != null ? attr.getValue(attribute) : null;
	}
	
}
