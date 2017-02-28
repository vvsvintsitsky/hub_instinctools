package wsvintsitsky.instinctools.service;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;

public interface ClientService {

	public Client findClient(Long id);
	
	public Client saveOrUpdate(Client client);
}
