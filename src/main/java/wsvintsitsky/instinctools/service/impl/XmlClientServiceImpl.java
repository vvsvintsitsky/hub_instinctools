package wsvintsitsky.instinctools.service.impl;

import wsvintsitsky.instinctools.dataaccess.ClientDao;
import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;
import wsvintsitsky.instinctools.service.ClientService;

public class XmlClientServiceImpl implements ClientService {

	private ClientDao clientDao;

	@Override
	public Client findClient(Long id) {
		Client client = null;
		try {
			client = clientDao.find(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public Client saveOrUpdate(Client client) {
		try {
			if (client.getId() == null) {
				client = clientDao.insert(client);
			} else {
				client = clientDao.update(client);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public void deleteClient(Long id) {
		try {
			clientDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

}
