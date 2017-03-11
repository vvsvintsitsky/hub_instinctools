package wsvintsitsky.instinctools.boot;

import wsvintsitsky.instinctools.jpa.dataaccess.ClientDao;
import wsvintsitsky.instinctools.jpa.dataaccess.impl.ClientDaoImpl;
import wsvintsitsky.instinctools.jpa.datamodel.Person;

public class JpaBoot implements IBoot {

	@Override
	public void boot() {
		Person client = new Person();
		ClientDao clientDao = new ClientDaoImpl();
		client = clientDao.insert(client);
		System.out.println(client);
	}
}
