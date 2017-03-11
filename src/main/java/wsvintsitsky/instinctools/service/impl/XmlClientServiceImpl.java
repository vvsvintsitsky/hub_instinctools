package wsvintsitsky.instinctools.service.impl;

import wsvintsitsky.instinctools.dataaccess.spring_data.ClientRepository;
import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;
import wsvintsitsky.instinctools.service.ClientService;

public class XmlClientServiceImpl implements ClientService {

	private ClientRepository clientDao;

	@Override
	public Client findClient(Long id) {
		return clientDao.findOne(id);
	}

	@Override
	public Client saveOrUpdate(Client client) {
		return clientDao.save(client);
	}

	@Override
	public void deleteClient(Long id) {
			clientDao.delete(id);
	}
	
	public void setClientDao(ClientRepository clientDao) {
		this.clientDao = clientDao;
	}

}
