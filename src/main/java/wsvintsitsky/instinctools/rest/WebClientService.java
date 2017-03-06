package wsvintsitsky.instinctools.rest;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;

public interface WebClientService {

	public Client findClient(Long id);
	
	public Client saveClient(Client client);
	
	public Client updateClient(Client client);
	
	public void deleteClient(Long id);
}
