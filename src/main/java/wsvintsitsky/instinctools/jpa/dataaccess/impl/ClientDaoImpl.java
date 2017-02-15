package wsvintsitsky.instinctools.jpa.dataaccess.impl;

import wsvintsitsky.instinctools.jpa.dataaccess.ClientDao;
import wsvintsitsky.instinctools.jpa.datamodel.Client;

public class ClientDaoImpl extends AbstractDaoImpl<Client, Long> implements ClientDao {

	public ClientDaoImpl() {
		super();
		setEntityClass(Client.class);
	}
}
