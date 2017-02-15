package wsvintsitsky.instinctools.boot;

import wsvintsitsky.instinctools.jpa.dataaccess.ClientDao;
import wsvintsitsky.instinctools.jpa.dataaccess.impl.ClientDaoImpl;
import wsvintsitsky.instinctools.jpa.datamodel.Client;

public class JpaBoot implements IBoot {

	@Override
	public void boot() {
		Client client = new Client();
		ClientDao clientDao = new ClientDaoImpl();
		client = clientDao.insert(client);
		System.out.println(client);
	}
}
