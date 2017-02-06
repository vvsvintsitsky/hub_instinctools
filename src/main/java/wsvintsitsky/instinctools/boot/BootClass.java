package wsvintsitsky.instinctools.boot;

import wsvintsitsky.instinctools.jpa.dataaccess.impl.ClientDaoImpl;
import wsvintsitsky.instinctools.jpa.datamodel.Client;

public class BootClass {

	public static void main(String[] args) {
		Client client = new Client();
		client = new ClientDaoImpl().insert(client);
	}
}
